package org.example.backend.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.example.backend.entity.child.chatbot.*;
import org.example.backend.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ChatbotService {
    private static final Logger logger = LoggerFactory.getLogger(ChatbotService.class);

    private static final double DEFAULT_CONFIDENCE_THRESHOLD = 0.7;
    private static final int DEFAULT_MAX_RESPONSES = 1;
    private static final String DEFAULT_FALLBACK_STRATEGY = "default";

    private Map<String, Object> settings = new HashMap<>();

    @Autowired
    private ChatIntentRepository chatIntentRepository;

    @Autowired
    private ChatTrainingPhraseRepository chatTrainingPhraseRepository;

    @Autowired
    private ChatResponseRepository chatResponseRepository;

    @Autowired
    private ChatConversationRepository chatConversationRepository;

    @Autowired
    private ChatBotMessageRepository chatBotMessageRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    public ChatbotService() {
        settings.put("confidenceThreshold", DEFAULT_CONFIDENCE_THRESHOLD);
        settings.put("maxResponses", DEFAULT_MAX_RESPONSES);
        settings.put("fallbackStrategy", DEFAULT_FALLBACK_STRATEGY);
        settings.put("enableLearning", true);
    }

    /**
     * Xử lý tin nhắn từ người dùng
     */
    @Transactional
    public ChatBotMessage processUserMessage(String sessionId, String message, Long userId) {
        // Tìm hoặc tạo cuộc trò chuyện
        ChatConversation conversation = findOrCreateConversation(sessionId, userId);

        // Lưu tin nhắn người dùng
        ChatBotMessage userMessage = new ChatBotMessage();
        userMessage.setMessageText(message);
        userMessage.setIsFromBot(false);
        userMessage.setConversation(conversation);
        userMessage.setSentAt(LocalDateTime.now());
        chatBotMessageRepository.save(userMessage);

        // Phân tích ý định với mối quan hệ mới
        Map<String, Object> intentResult = detectIntent(message);
        ChatIntent detectedIntent = (ChatIntent) intentResult.get("intent");
        Double confidence = (Double) intentResult.get("confidence");

        // Tạo tin nhắn trả lời từ bot
        ChatBotMessage botResponse = new ChatBotMessage();
        botResponse.setIsFromBot(true);
        botResponse.setConversation(conversation);
        botResponse.setSentAt(LocalDateTime.now());

        // Nếu không nhận dạng được ý định hoặc độ tin cậy thấp
        double confidenceThreshold = (double) settings.get("confidenceThreshold");
        if (detectedIntent == null || confidence < confidenceThreshold) {
            // Lưu câu hỏi chưa được xử lý
            saveUnprocessedQuery(message);

            // Trả lời mặc định
            botResponse.setMessageText("Tôi không hiểu câu hỏi của bạn. Có thể bạn thử diễn đạt theo cách khác?");
            botResponse.setDetectedIntent(null);
            botResponse.setConfidenceScore(confidence != null ? confidence.floatValue() : 0);
        } else {
            // Lấy phản hồi dựa trên ý định
            String responseText = getResponseForIntent(detectedIntent);
            botResponse.setMessageText(responseText);
            botResponse.setDetectedIntent(detectedIntent);
            botResponse.setConfidenceScore(confidence.floatValue());
        }

        chatBotMessageRepository.save(botResponse);
        return botResponse;
    }

    /**
     * Tìm hoặc tạo cuộc trò chuyện
     */
    private ChatConversation findOrCreateConversation(String sessionId, Long userId) {
        List<ChatConversation> conversations = chatConversationRepository.findBySessionId(sessionId);

        if (!conversations.isEmpty()) {
            return conversations.get(0);
        }

        ChatConversation conversation = new ChatConversation();
        conversation.setSessionId(sessionId);
        conversation.setStartedAt(LocalDateTime.now());

        // Nếu có ID người dùng, gán cho cuộc trò chuyện
        if (userId != null) {
            // Giả sử bạn có một service để lấy User entity từ ID
            // User user = userService.findById(userId);
            // conversation.setUser(user);
        }

        return chatConversationRepository.save(conversation);
    }

    /**
     * Lưu câu hỏi chưa được xử lý
     */
    private void saveUnprocessedQuery(String message) {
        // Kiểm tra xem câu hỏi đã tồn tại chưa
        Optional<ChatTrainingPhrase> existingPhrase = chatTrainingPhraseRepository.findByPhraseText(message);

        if (existingPhrase.isPresent()) {
            // Nếu đã tồn tại, tăng tần suất
            ChatTrainingPhrase phrase = existingPhrase.get();
            phrase.setFrequency(phrase.getFrequency() + 1);
            chatTrainingPhraseRepository.save(phrase);
        } else {
            // Nếu chưa tồn tại, tạo mới
            ChatTrainingPhrase phrase = new ChatTrainingPhrase();
            phrase.setPhraseText(message);
            phrase.setIsProcessed(false);
            phrase.setFrequency(1);
            phrase.setCreatedAt(LocalDateTime.now());
            chatTrainingPhraseRepository.save(phrase);
        }
    }

    /**
     * Phát hiện ý định từ tin nhắn
     */
    private Map<String, Object> detectIntent(String message) {
        Map<String, Object> result = new HashMap<>();
        result.put("intent", null);
        result.put("confidence", 0.0);

        // Lấy tất cả các câu training
        List<ChatTrainingPhrase> allPhrases = chatTrainingPhraseRepository.findAll();

        // Nếu không có câu training nào, trả về null
        if (allPhrases.isEmpty()) {
            return result;
        }

        // Chuẩn hóa tin nhắn
        String normalizedMessage = normalizeText(message);

        // Tính điểm tương đồng và tìm intent có điểm cao nhất
        double highestSimilarity = 0;
        ChatIntent bestIntent = null;

        for (ChatTrainingPhrase phrase : allPhrases) {
            // Bỏ qua các câu chưa được xử lý
            if (!phrase.getIsProcessed() || phrase.getIntent() == null) {
                continue;
            }

            String normalizedPhrase = normalizeText(phrase.getPhraseText());
            double similarity = calculateSimilarity(normalizedMessage, normalizedPhrase);

            if (similarity > highestSimilarity) {
                highestSimilarity = similarity;
                bestIntent = phrase.getIntent();
            }
        }

        result.put("intent", bestIntent);
        result.put("confidence", highestSimilarity);
        return result;
    }

    /**
     * Chuẩn hóa văn bản
     */
    private String normalizeText(String text) {
        return text.toLowerCase()
                .replaceAll("[.!?,:;]", "")
                .replaceAll("\\s+", " ")
                .trim();
    }

    /**
     * Tính toán độ tương đồng giữa hai chuỗi (đơn giản)
     */
    private double calculateSimilarity(String text1, String text2) {
        // Simple implementation using Jaccard similarity for testing
        Set<String> set1 = new HashSet<>(Arrays.asList(text1.split(" ")));
        Set<String> set2 = new HashSet<>(Arrays.asList(text2.split(" ")));

        Set<String> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        Set<String> union = new HashSet<>(set1);
        union.addAll(set2);

        if (union.isEmpty()) {
            return 0;
        }

        return (double) intersection.size() / union.size();
    }

    /**
     * Lấy phản hồi dựa trên intent
     */
    private String getResponseForIntent(ChatIntent intent) {
        if (intent == null) {
            return "Tôi không hiểu được ý định của bạn. Xin vui lòng diễn đạt lại.";
        }
        List<ChatResponse> responses = chatResponseRepository.findByIntentIdOrderByDisplayOrderAsc(intent.getId());

        if (responses.isEmpty()) {
            return "Tôi hiểu ý định của bạn là " + intent.getIntentName() + ", nhưng tôi chưa có câu trả lời cho câu hỏi này.";
        }
        Random random = new Random();
        ChatResponse selectedResponse = responses.get(random.nextInt(responses.size()));
        if (selectedResponse.getRequiresDbQuery() && selectedResponse.getQueryTemplate() != null) {
            return processResponseWithDbQuery(selectedResponse);
        }
        return selectedResponse.getResponseText();
    }

    /**
     * Xử lý phản hồi có kèm truy vấn database
     */
    private String processResponseWithDbQuery(ChatResponse response) {
        try {
            // Thực hiện truy vấn
            List<Map<String, Object>> queryResults = executeQuery(response.getQueryTemplate());

            if (queryResults.isEmpty()) {
                // Không có kết quả
                return "Tôi không tìm thấy thông tin phù hợp với yêu cầu của bạn.";
            }

            // Lấy kết quả đầu tiên
            Map<String, Object> result = queryResults.get(0);

            // Thay thế các placeholders trong văn bản phản hồi
            String responseText = response.getResponseText();
            Pattern pattern = Pattern.compile("\\{\\{(.*?)\\}\\}");
            Matcher matcher = pattern.matcher(responseText);

            StringBuffer sb = new StringBuffer();
            while (matcher.find()) {
                String key = matcher.group(1);
                Object value = result.get(key);
                String replacement = value != null ? value.toString() : "không rõ";
                matcher.appendReplacement(sb, replacement);
            }
            matcher.appendTail(sb);

            return sb.toString();
        } catch (Exception e) {
            logger.error("Error executing database query: " + e.getMessage(), e);
            return "Xin lỗi, đã xảy ra lỗi khi truy vấn dữ liệu.";
        }
    }

    /**
     * Thực hiện truy vấn SQL và trả về kết quả dưới dạng List<Map>
     */
    public List<Map<String, Object>> executeQuery(String sql) {
        try {
            Query query = entityManager.createNativeQuery(sql);
            List<Object[]> results = query.getResultList();

            // Lấy tên cột từ truy vấn SQL
            List<String> columnNames = extractColumnNamesFromSql(sql);

            // Map kết quả vào danh sách các map
            List<Map<String, Object>> mappedResults = new ArrayList<>();

            for (Object[] row : results) {
                Map<String, Object> mappedRow = new HashMap<>();

                for (int i = 0; i < Math.min(row.length, columnNames.size()); i++) {
                    mappedRow.put(columnNames.get(i), row[i]);
                }

                mappedResults.add(mappedRow);
            }

            return mappedResults;
        } catch (Exception e) {
            logger.error("Error executing SQL query: " + e.getMessage(), e);
            throw e;
        }
    }

    /**
     * Trích xuất tên cột từ câu lệnh SQL
     */
    private List<String> extractColumnNamesFromSql(String sql) {
        List<String> columnNames = new ArrayList<>();

        // Regex để lấy tên cột từ SQL
        Pattern pattern = Pattern.compile("SELECT\\s+(.*?)\\s+FROM", Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher matcher = pattern.matcher(sql);

        if (matcher.find()) {
            String columnsSection = matcher.group(1);
            String[] columns = columnsSection.split(",");

            for (String column : columns) {
                column = column.trim();

                // Kiểm tra xem có alias không
                if (column.toLowerCase().contains(" as ")) {
                    String[] parts = column.split("(?i) as ");
                    columnNames.add(parts[1].trim());
                } else {
                    // Lấy phần cuối cùng nếu có dấu chấm (table.column)
                    String[] parts = column.split("\\.");
                    columnNames.add(parts[parts.length - 1].trim());
                }
            }
        }

        return columnNames;
    }

    /**
     * Thực thi truy vấn kiểm thử
     */
    public List<Map<String, Object>> executeTestQuery(String sql) {
        return executeQuery(sql);
    }

    /**
     * Lấy các câu hỏi chưa được xử lý
     */
    public List<ChatTrainingPhrase> getUnprocessedQueries(int limit) {
        return chatTrainingPhraseRepository.findTopUnprocessedPhrases(limit);
    }

    /**
     * Tìm tin nhắn gốc dựa trên nội dung
     */
    public ChatBotMessage findOriginalMessage(String text) {
        List<ChatBotMessage> messages = chatBotMessageRepository.findAll();

        for (ChatBotMessage message : messages) {
            if (!message.getIsFromBot() && message.getMessageText().equals(text)) {
                return message;
            }
        }

        return null;
    }

    /**
     * Xử lý câu hỏi chưa được nhận dạng
     */
    @Transactional
    public void processUnrecognizedQuery(Long queryId, String intentName, String responseText, boolean requiresDbQuery, String queryTemplate) {
        ChatTrainingPhrase phrase = chatTrainingPhraseRepository.findById(queryId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy câu hỏi với ID: " + queryId));

        if ("ignored_query".equals(intentName)) {
            // Chỉ đánh dấu là đã xử lý mà không thêm vào intent
            phrase.setIsProcessed(true);
            chatTrainingPhraseRepository.save(phrase);
            return;
        }

        // Tìm hoặc tạo intent
        ChatIntent intent = chatIntentRepository.findByIntentName(intentName)
                .orElseGet(() -> {
                    ChatIntent newIntent = new ChatIntent();
                    newIntent.setIntentName(intentName);
                    return chatIntentRepository.save(newIntent);
                });

        // Cập nhật phrase
        phrase.setIntent(intent);
        phrase.setIsProcessed(true);
        chatTrainingPhraseRepository.save(phrase);

        // Thêm phản hồi nếu có
        if (responseText != null && !responseText.isEmpty()) {
            ChatResponse response = new ChatResponse();
            response.setResponseText(responseText);
            response.setIntent(intent);
            response.setRequiresDbQuery(requiresDbQuery);

            if (requiresDbQuery && queryTemplate != null && !queryTemplate.isEmpty()) {
                response.setQueryTemplate(queryTemplate);
            }

            chatResponseRepository.save(response);
        }
    }

    /**
     * Thêm intent mới
     */
    @Transactional
    public ChatIntent addIntent(String intentName, String description, List<String> trainingPhrases,
                                List<String> responses, boolean requiresDbQuery, String dbQuery) {
        // Kiểm tra xem intent đã tồn tại chưa
        Optional<ChatIntent> existingIntent = chatIntentRepository.findByIntentName(intentName);

        if (existingIntent.isPresent()) {
            throw new RuntimeException("Intent với tên " + intentName + " đã tồn tại");
        }

        // Tạo intent mới
        ChatIntent intent = new ChatIntent();
        intent.setIntentName(intentName);
        intent.setDescription(description);
        intent = chatIntentRepository.save(intent);

        // Thêm các câu training
        if (trainingPhrases != null && !trainingPhrases.isEmpty()) {
            for (String phraseText : trainingPhrases) {
                ChatTrainingPhrase phrase = new ChatTrainingPhrase();
                phrase.setPhraseText(phraseText);
                phrase.setIsProcessed(true);
                phrase.setIntent(intent);
                chatTrainingPhraseRepository.save(phrase);
            }
        }

        // Thêm các phản hồi
        if (responses != null && !responses.isEmpty()) {
            int order = 0;
            for (String responseText : responses) {
                ChatResponse response = new ChatResponse();
                response.setResponseText(responseText);
                response.setDisplayOrder(order++);
                response.setIntent(intent);

                // Nếu là response đầu tiên và có yêu cầu truy vấn DB
                if (order == 1 && requiresDbQuery && dbQuery != null && !dbQuery.isEmpty()) {
                    response.setRequiresDbQuery(true);
                    response.setQueryTemplate(dbQuery);
                }

                chatResponseRepository.save(response);
            }
        }

        return intent;
    }

    /**
     * Cập nhật intent hiện có
     */
    @Transactional
    public ChatIntent updateIntent(Long intentId, String intentName, String description, List<String> trainingPhrases) {
        ChatIntent intent = chatIntentRepository.findById(intentId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy intent với ID: " + intentId));

        // Cập nhật thông tin intent
        intent.setIntentName(intentName);
        intent.setDescription(description);

        // Xóa các câu training cũ và thêm câu mới
        if (trainingPhrases != null) {
            List<ChatTrainingPhrase> existingPhrases = chatTrainingPhraseRepository.findByIntentId(intentId);
            chatTrainingPhraseRepository.deleteAll(existingPhrases);

            for (String phraseText : trainingPhrases) {
                ChatTrainingPhrase phrase = new ChatTrainingPhrase();
                phrase.setPhraseText(phraseText);
                phrase.setIsProcessed(true);
                phrase.setIntent(intent);
                chatTrainingPhraseRepository.save(phrase);
            }
        }

        return chatIntentRepository.save(intent);
    }

    /**
     * Xóa intent
     */
    @Transactional
    public void deleteIntent(Long intentId) {
        chatIntentRepository.deleteById(intentId);
    }

    /**
     * Lấy chi tiết intent
     */
    public Map<String, Object> getIntentDetails(Long intentId) {
        ChatIntent intent = chatIntentRepository.findById(intentId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy intent với ID: " + intentId));

        Map<String, Object> details = new HashMap<>();
        details.put("id", intent.getId());
        details.put("intentName", intent.getIntentName());
        details.put("description", intent.getDescription());

        // Lấy danh sách câu training
        List<ChatTrainingPhrase> phrases = chatTrainingPhraseRepository.findByIntentId(intentId);
        List<Map<String, Object>> phrasesList = phrases.stream()
                .map(phrase -> {
                    Map<String, Object> phraseMap = new HashMap<>();
                    phraseMap.put("id", phrase.getId());
                    phraseMap.put("text", phrase.getPhraseText());
                    phraseMap.put("frequency", phrase.getFrequency());
                    return phraseMap;
                })
                .collect(Collectors.toList());
        details.put("trainingPhrases", phrasesList);

        // Lấy danh sách phản hồi
        List<ChatResponse> responses = chatResponseRepository.findByIntentIdOrderByDisplayOrderAsc(intentId);
        List<Map<String, Object>> responsesList = responses.stream()
                .map(response -> {
                    Map<String, Object> responseMap = new HashMap<>();
                    responseMap.put("id", response.getId());
                    responseMap.put("text", response.getResponseText());
                    responseMap.put("requiresDbQuery", response.getRequiresDbQuery());
                    responseMap.put("queryTemplate", response.getQueryTemplate());
                    responseMap.put("displayOrder", response.getDisplayOrder());
                    return responseMap;
                })
                .collect(Collectors.toList());
        details.put("responses", responsesList);

        return details;
    }

    /**
     * Thêm phản hồi cho intent
     */
    @Transactional
    public ChatResponse addResponseToIntent(Long intentId, String responseText, boolean requiresDbQuery, String queryTemplate) {
        ChatIntent intent = chatIntentRepository.findById(intentId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy intent với ID: " + intentId));

        // Tìm display order cao nhất hiện tại
        List<ChatResponse> existingResponses = chatResponseRepository.findByIntentIdOrderByDisplayOrderAsc(intentId);
        int displayOrder = existingResponses.isEmpty() ? 0 :
                existingResponses.get(existingResponses.size() - 1).getDisplayOrder() + 1;

        ChatResponse response = new ChatResponse();
        response.setResponseText(responseText);
        response.setIntent(intent);
        response.setDisplayOrder(displayOrder);

        if (requiresDbQuery && queryTemplate != null && !queryTemplate.isEmpty()) {
            response.setRequiresDbQuery(true);
            response.setQueryTemplate(queryTemplate);
        }

        return chatResponseRepository.save(response);
    }

    /**
     * Cập nhật phản hồi
     */
    @Transactional
    public ChatResponse updateResponse(Long responseId, String responseText, boolean requiresDbQuery, String queryTemplate) {
        ChatResponse response = chatResponseRepository.findById(responseId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phản hồi với ID: " + responseId));

        response.setResponseText(responseText);
        response.setRequiresDbQuery(requiresDbQuery);

        if (requiresDbQuery && queryTemplate != null && !queryTemplate.isEmpty()) {
            response.setQueryTemplate(queryTemplate);
        } else {
            response.setQueryTemplate(null);
        }

        return chatResponseRepository.save(response);
    }

    /**
     * Xóa phản hồi
     */
    @Transactional
    public void deleteResponse(Long responseId) {
        chatResponseRepository.deleteById(responseId);
    }

    /**
     * Lấy thống kê chatbot
     */
    public Map<String, Object> getChatbotStatistics() {
        Map<String, Object> statistics = new HashMap<>();

        // Tổng số cuộc hội thoại
        Long totalConversations = chatConversationRepository.countTotalConversations();
        statistics.put("totalConversations", totalConversations);

        // Tổng số tin nhắn
        Long totalMessages = chatBotMessageRepository.countTotalMessages();
        statistics.put("totalMessages", totalMessages);

        // Độ hài lòng trung bình
        Double avgSatisfaction = chatConversationRepository.getAverageSatisfactionRating();
        statistics.put("averageSatisfaction", avgSatisfaction);

        // Số câu hỏi chưa nhận dạng
        Long unrecognizedQueries = (long) chatTrainingPhraseRepository.findByIsProcessedFalse().size();
        statistics.put("unrecognizedQueries", unrecognizedQueries);

        // Top intents phổ biến
        List<Object[]> popularIntents = chatBotMessageRepository.getPopularIntents();
        List<Map<String, Object>> topIntents = new ArrayList<>();

        int count = 0;
        for (Object[] row : popularIntents) {
            if (count >= 5) break; // Chỉ lấy top 5

            Map<String, Object> intent = new HashMap<>();
            intent.put("intent", row[0]);
            intent.put("count", row[1]);
            topIntents.add(intent);
            count++;
        }

        statistics.put("topIntents", topIntents);

        return statistics;
    }

    /**
     * Cập nhật cài đặt chatbot
     */
    public void updateSettings(Map<String, Object> newSettings) {
        // Cập nhật các cài đặt
        if (newSettings.containsKey("confidenceThreshold")) {
            settings.put("confidenceThreshold", newSettings.get("confidenceThreshold"));
        }

        if (newSettings.containsKey("maxResponses")) {
            settings.put("maxResponses", newSettings.get("maxResponses"));
        }

        if (newSettings.containsKey("fallbackStrategy")) {
            settings.put("fallbackStrategy", newSettings.get("fallbackStrategy"));
        }

        if (newSettings.containsKey("enableLearning")) {
            settings.put("enableLearning", newSettings.get("enableLearning"));
        }
    }

    /**
     * Lấy cài đặt chatbot
     */
    public Map<String, Object> getSettings() {
        return new HashMap<>(settings);
    }
}
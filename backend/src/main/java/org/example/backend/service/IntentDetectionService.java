package org.example.backend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.backend.entity.child.chatbot.ChatIntent;
import org.example.backend.entity.child.chatbot.ChatTrainingPhrase;
import org.example.backend.repository.ChatIntentRepository;
import org.example.backend.repository.ChatTrainingPhraseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class IntentDetectionService {
    private static final Logger logger = LoggerFactory.getLogger(IntentDetectionService.class);

    @Autowired
    private AIService aiService;

    @Autowired
    private ChatIntentRepository chatIntentRepository;

    @Autowired
    private ChatTrainingPhraseRepository chatTrainingPhraseRepository;

    /**
     * Phát hiện intent sử dụng AI
     */
    public Map<String, Object> detectIntentWithAI(String message) {
        try {
            // Tạo prompt cho AI
            String prompt = buildIntentDetectionPrompt(message);

            // Gọi AI để phân tích
            String aiResponse = aiService.callOllamaForIntentDetection(prompt);

            // Xử lý kết quả từ AI
            return parseAIResponse(aiResponse, message);
        } catch (Exception e) {
            logger.error("Error detecting intent with AI: {}", e.getMessage(), e);
            return fallbackEmptyResult();
        }
    }

    /**
     * Tạo prompt cho việc phát hiện intent
     */
    private String buildIntentDetectionPrompt(String message) {
        List<ChatIntent> intents = chatIntentRepository.findAll();
        StringBuilder intentDescriptions = new StringBuilder();

        // Xây dựng mô tả về các intent
        for (ChatIntent intent : intents) {
            intentDescriptions.append("- ").append(intent.getIntentName())
                    .append(": ").append(intent.getDescription())
                    .append("\n");

            // Thêm một số ví dụ cho mỗi intent
            List<ChatTrainingPhrase> examples = chatTrainingPhraseRepository
                    .findByIntentId(intent.getId()).stream()
                    .filter(ChatTrainingPhrase::getIsProcessed)
                    .sorted(Comparator.comparing(ChatTrainingPhrase::getFrequency).reversed())
                    .limit(3)
                    .collect(Collectors.toList());

            if (!examples.isEmpty()) {
                intentDescriptions.append("  Ví dụ: ");
                for (int i = 0; i < examples.size(); i++) {
                    if (i > 0) intentDescriptions.append("; ");
                    intentDescriptions.append("\"").append(examples.get(i).getPhraseText()).append("\"");
                }
                intentDescriptions.append("\n");
            }
        }

        return "Bạn là hệ thống phân tích ngôn ngữ tự nhiên. Hãy phân tích câu hỏi sau và xác định intent phù hợp nhất.\n\n" +
                "Danh sách các intent:\n" + intentDescriptions.toString() + "\n" +
                "Câu hỏi: \"" + message + "\"\n\n" +
                "Đặc biệt chú ý: Nếu câu hỏi liên quan đến kỹ năng hoặc công việc, hãy trích xuất chính xác các kỹ năng được đề cập." +
                "Ví dụ nếu câu hỏi là \"tôi có những kĩ năng java, react thì có công việc nào phù hợp\", phải trích xuất kỹ năng là [\"java\", \"react\"]." +
                "Nếu là \"Tôi biết Python và SQL\", trích xuất [\"Python\", \"SQL\"].\n\n" +
                "Trả về kết quả dưới dạng JSON với format:\n" +
                "{\n" +
                "  \"intent\": \"tên_intent\",\n" +
                "  \"confidence\": số_từ_0_đến_1,\n" +
                "  \"params\": {\n" +
                "    \"skills\": [\"skill1\", \"skill2\"], // Danh sách các kỹ năng được trích xuất\n" +
                "    // Các tham số khác nếu có\n" +
                "  }\n" +
                "}\n" +
                "Nếu không tìm thấy intent phù hợp, trả về intent là null và confidence là 0.";
    }
    /**
     * Phân tích kết quả từ AI
     */
    private Map<String, Object> parseAIResponse(String aiResponse, String originalMessage) {
        Map<String, Object> result = new HashMap<>();
        result.put("intent", null);
        result.put("confidence", 0.0f);

        try {
            // Tìm phần JSON trong phản hồi của AI
            int jsonStart = aiResponse.indexOf('{');
            int jsonEnd = aiResponse.lastIndexOf('}');

            if (jsonStart >= 0 && jsonEnd > jsonStart) {
                String jsonStr = aiResponse.substring(jsonStart, jsonEnd + 1);

                ObjectMapper mapper = new ObjectMapper();
                JsonNode rootNode = mapper.readTree(jsonStr);

                String intentName = rootNode.path("intent").asText(null);
                if (intentName != null && !intentName.equals("null")) {
                    Optional<ChatIntent> intentOpt = chatIntentRepository.findByIntentName(intentName);
                    if (intentOpt.isPresent()) {
                        result.put("intent", intentOpt.get());
                        result.put("confidence", (float)rootNode.path("confidence").asDouble(0.7));

                        // Xử lý các tham số
                        JsonNode paramsNode = rootNode.path("params");
                        if (paramsNode.isObject()) {
                            // Xử lý đặc biệt cho skills nếu là mảng
                            JsonNode skillsNode = paramsNode.path("skills");
                            if (!skillsNode.isMissingNode() && skillsNode.isArray()) {
                                List<String> skills = new ArrayList<>();
                                for (JsonNode skill : skillsNode) {
                                    skills.add(skill.asText());
                                }
                                // Chuyển mảng skills thành chuỗi ngăn cách bởi dấu phẩy
                                result.put("skills", String.join(", ", skills));
                            }

                            // Xử lý các tham số khác
                            Iterator<Map.Entry<String, JsonNode>> fields = paramsNode.fields();
                            while (fields.hasNext()) {
                                Map.Entry<String, JsonNode> field = fields.next();
                                if (!field.getKey().equals("skills") || !field.getValue().isArray()) {
                                    result.put(field.getKey(), field.getValue().asText());
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error("Error parsing AI intent response: {}", e.getMessage(), e);
        }

        return result;
    }

    /**
     * Kết quả mặc định khi xảy ra lỗi
     */
    private Map<String, Object> fallbackEmptyResult() {
        Map<String, Object> result = new HashMap<>();
        result.put("intent", null);
        result.put("confidence", 0.0f);
        return result;
    }
}
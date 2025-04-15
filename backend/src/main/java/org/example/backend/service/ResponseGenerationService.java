package org.example.backend.service;

import org.example.backend.entity.child.chatbot.ChatIntent;
import org.example.backend.entity.child.chatbot.ChatResponse;
import org.example.backend.repository.ChatResponseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ResponseGenerationService {
    private static final Logger logger = LoggerFactory.getLogger(ResponseGenerationService.class);

    @Autowired
    private AIService aiService;

    @Autowired
    private ChatResponseRepository chatResponseRepository;

    /**
     * Tạo câu trả lời cho intent sử dụng AI
     */
    public String generateResponse(ChatIntent intent, String message, Map<String, String> params) {
        try {
            // Đảm bảo tất cả các tham số cần thiết đều có mặt
            ensureRequiredParams(intent, params);

            String prompt = buildResponsePrompt(intent, message, params);
            return aiService.callOllamaForResponseGeneration(prompt);
        } catch (Exception e) {
            logger.error("Error generating response with AI: {}", e.getMessage(), e);
            return getTemplateResponse(intent, params);
        }
    }

    // Thêm phương thức mới
    private void ensureRequiredParams(ChatIntent intent, Map<String, String> params) {
        List<ChatResponse> responses = chatResponseRepository.findByIntentIdOrderByDisplayOrderAsc(intent.getId());
        if (responses.isEmpty()) return;

        // Tìm tất cả placeholder cần thiết từ mẫu câu trả lời
        Set<String> requiredParams = new HashSet<>();
        Pattern pattern = Pattern.compile("\\{\\{(.*?)\\}\\}");

        for (ChatResponse response : responses) {
            Matcher matcher = pattern.matcher(response.getResponseText());
            while (matcher.find()) {
                requiredParams.add(matcher.group(1));
            }

            if (response.getQueryTemplate() != null) {
                matcher = pattern.matcher(response.getQueryTemplate());
                while (matcher.find()) {
                    requiredParams.add(matcher.group(1));
                }
            }
        }

        // Thêm giá trị mặc định cho các tham số còn thiếu
        for (String param : requiredParams) {
            if (!params.containsKey(param)) {
                switch (param) {
                    case "skills":
                        params.put("skills", "bạn đề cập");
                        break;
                    case "skill":
                        if (params.containsKey("skills")) {
                            params.put("skill", params.get("skills"));
                        } else {
                            params.put("skill", "bạn quan tâm");
                        }
                        break;
                    case "category":
                        params.put("category", "bạn quan tâm");
                        break;
                    default:
                        params.put(param, "không xác định");
                        break;
                }
            }
        }
    }

    /**
     * Tạo prompt cho việc tạo câu trả lời
     */
    private String buildResponsePrompt(ChatIntent intent, String message, Map<String, String> params) {
        // Lấy các phản hồi mẫu cho intent này
        List<ChatResponse> responseTemplates = chatResponseRepository.findByIntentIdOrderByDisplayOrderAsc(intent.getId());
        StringBuilder exampleResponses = new StringBuilder();

        for (ChatResponse template : responseTemplates) {
            // Thay thế placeholder trong mẫu câu trả lời để tạo ví dụ hoàn chỉnh
            String processedResponse = template.getResponseText();
            for (Map.Entry<String, String> param : params.entrySet()) {
                processedResponse = processedResponse.replace("{{" + param.getKey() + "}}", param.getValue());
            }
            exampleResponses.append("- ").append(processedResponse).append("\n");
        }

        StringBuilder paramStr = new StringBuilder();
        for (Map.Entry<String, String> param : params.entrySet()) {
            paramStr.append("- ").append(param.getKey()).append(": \"").append(param.getValue()).append("\"\n");
        }

        return "Bạn là trợ lý chatbot có tên TalentHub Bot, hãy tạo câu trả lời cho người dùng.\n\n" +
                "Intent được phát hiện: " + intent.getIntentName() + "\n" +
                "Mô tả intent: " + intent.getDescription() + "\n\n" +
                "Câu hỏi gốc của người dùng: \"" + message + "\"\n\n" +
                "Các tham số trích xuất:\n" + paramStr.toString() + "\n" +
                "Các mẫu phản hồi tham khảo:\n" + exampleResponses.toString() + "\n" +
                "Hãy tạo một câu trả lời tự nhiên, thân thiện và hữu ích, có tính đến các tham số được cung cấp. " +
                "Không cần giải thích bạn là AI, không nhắc đến tên bạn, không cần giải thích quá trình phân tích. " +
                "Trả lời ngắn gọn và trực tiếp vào vấn đề. Sử dụng tiếng Việt thân thiện, tự nhiên.";
    }

    /**
     * Lấy phản hồi mẫu khi AI gặp lỗi
     */
    private String getTemplateResponse(ChatIntent intent, Map<String, String> params) {
        List<ChatResponse> responses = chatResponseRepository.findByIntentIdOrderByDisplayOrderAsc(intent.getId());

        if (!responses.isEmpty()) {
            String responseText = responses.get(0).getResponseText();

            // Thay thế các placeholder
            for (Map.Entry<String, String> param : params.entrySet()) {
                responseText = responseText.replace("{{" + param.getKey() + "}}", param.getValue());
            }

            return responseText;
        } else {
            return "Tôi hiểu ý định của bạn là " + intent.getIntentName() + ", nhưng tôi chưa có câu trả lời cụ thể.";
        }
    }
}
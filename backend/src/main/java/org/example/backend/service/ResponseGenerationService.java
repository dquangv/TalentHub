package org.example.backend.service;

import org.example.backend.entity.child.chatbot.ChatIntent;
import org.example.backend.entity.child.chatbot.ChatResponse;
import org.example.backend.repository.ChatResponseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
            String prompt = buildResponsePrompt(intent, message, params);
            return aiService.callOllamaForResponseGeneration(prompt);
        } catch (Exception e) {
            logger.error("Error generating response with AI: {}", e.getMessage(), e);
            return getTemplateResponse(intent, params);
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
            exampleResponses.append("- ").append(template.getResponseText()).append("\n");
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
                "Trả lời ngắn gọn và trực tiếp vào vấn đề.";
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
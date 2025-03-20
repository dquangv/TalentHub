package org.example.backend.controller;

import org.example.backend.dto.request.chatbot.ChatBotMessageDTO;
import org.example.backend.dto.request.chatbot.IntentDTO;
import org.example.backend.dto.request.chatbot.ProcessQueryDTO;
import org.example.backend.dto.request.chatbot.ResponseDTO;
import org.example.backend.dto.response.chatbot.ChatResponseDTO;
import org.example.backend.entity.child.chatbot.ChatIntent;
import org.example.backend.entity.child.chatbot.ChatBotMessage;
import org.example.backend.entity.child.chatbot.ChatResponse;
import org.example.backend.entity.child.chatbot.ChatTrainingPhrase;
import org.example.backend.repository.ChatIntentRepository;
import org.example.backend.repository.ChatResponseRepository;
import org.example.backend.service.ChatbotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/chatbot")
public class ChatbotController {

    @Autowired
    private ChatbotService chatbotService;

    @Autowired
    private ChatIntentRepository chatIntentRepository;

    @Autowired
    private ChatResponseRepository chatResponseRepository;

    /**
     * Process a user message and get a response
     */
    @PostMapping("/message")
    public ResponseEntity<ChatResponseDTO> processMessage(@RequestBody ChatBotMessageDTO messageDTO) {
        ChatBotMessage botResponse = chatbotService.processUserMessage(
                messageDTO.getSessionId(),
                messageDTO.getMessage(),
                messageDTO.getUserId()
        );

        ChatResponseDTO responseDTO = new ChatResponseDTO();
        responseDTO.setMessage(botResponse.getMessageText());
        responseDTO.setDetectedIntent(botResponse.getDetectedIntent());
        responseDTO.setConfidence(botResponse.getConfidenceScore());
        responseDTO.setTimestamp(botResponse.getSentAt());

        return ResponseEntity.ok(responseDTO);
    }

    /**
     * Get unprocessed queries for training
     */
    @GetMapping("/training/unprocessed")
    public ResponseEntity<List<Map<String, Object>>> getUnprocessedQueries(
            @RequestParam(defaultValue = "10") int limit
    ) {
        List<ChatTrainingPhrase> unprocessedQueries = chatbotService.getUnprocessedQueries(limit);

        List<Map<String, Object>> result = unprocessedQueries.stream()
                .map(query -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("id", query.getId());
                    map.put("text", query.getPhraseText());
                    map.put("frequency", query.getFrequency());
                    map.put("createdAt", query.getCreatedAt());
                    // Thêm thông tin người dùng nếu có
                    ChatBotMessage message = chatbotService.findOriginalMessage(query.getPhraseText());
                    if (message != null && message.getConversation() != null) {
                        map.put("userId", message.getConversation().getUser() != null ?
                                message.getConversation().getUser().getId() : null);
                        map.put("sessionId", message.getConversation().getSessionId());
                        map.put("timestamp", message.getSentAt());
                        // Thêm email người dùng nếu có
                        if (message.getConversation().getUser() != null &&
                                message.getConversation().getUser().getAccount() != null) {
                            map.put("userEmail", message.getConversation().getUser().getAccount().getEmail());
                        }
                    }
                    return map;
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    /**
     * Process an unrecognized query
     */
    @PostMapping("/training/process-query")
    public ResponseEntity<String> processQuery(@RequestBody ProcessQueryDTO processQueryDTO) {
        chatbotService.processUnrecognizedQuery(
                processQueryDTO.getQueryId(),
                processQueryDTO.getIntentName(),
                processQueryDTO.getResponseText(),
                processQueryDTO.isRequiresDbQuery(),
                processQueryDTO.getQueryTemplate()
        );

        return ResponseEntity.ok("Query processed successfully");
    }

    /**
     * Add a new intent with training phrases and responses
     */
    @PostMapping("/intent")
    public ResponseEntity<ChatIntent> addIntent(@RequestBody IntentDTO intentDTO) {
        ChatIntent intent = chatbotService.addIntent(
                intentDTO.getIntentName(),
                intentDTO.getDescription(),
                intentDTO.getTrainingPhrases(),
                intentDTO.getResponses(),
                intentDTO.isRequiresDbQuery(),
                intentDTO.getDbQuery()
        );

        return ResponseEntity.ok(intent);
    }

    /**
     * Get intent details by ID
     */
    @GetMapping("/intent/{id}")
    public ResponseEntity<Map<String, Object>> getIntentDetails(@PathVariable Long id) {
        return ResponseEntity.ok(chatbotService.getIntentDetails(id));
    }

    /**
     * Update an existing intent
     */
    @PutMapping("/intent/{id}")
    public ResponseEntity<ChatIntent> updateIntent(
            @PathVariable Long id,
            @RequestBody IntentDTO intentDTO
    ) {
        ChatIntent updatedIntent = chatbotService.updateIntent(
                id,
                intentDTO.getIntentName(),
                intentDTO.getDescription(),
                intentDTO.getTrainingPhrases()
        );

        return ResponseEntity.ok(updatedIntent);
    }

    /**
     * Delete an intent
     */
    @DeleteMapping("/intent/{id}")
    public ResponseEntity<String> deleteIntent(@PathVariable Long id) {
        chatbotService.deleteIntent(id);
        return ResponseEntity.ok("Intent deleted successfully");
    }

    /**
     * Get all responses for an intent
     */
    @GetMapping("/intent/{id}/responses")
    public ResponseEntity<List<ChatResponse>> getResponses(@PathVariable Long id) {
        List<ChatResponse> responses = chatResponseRepository.findByIntentIdOrderByDisplayOrderAsc(id);
        return ResponseEntity.ok(responses);
    }

    /**
     * Add a response to an intent
     */
    @PostMapping("/intent/{id}/response")
    public ResponseEntity<ChatResponse> addResponse(
            @PathVariable Long id,
            @RequestBody ResponseDTO responseDTO
    ) {
        ChatResponse response = chatbotService.addResponseToIntent(
                id,
                responseDTO.getResponseText(),
                responseDTO.isRequiresDbQuery(),
                responseDTO.getQueryTemplate()
        );

        return ResponseEntity.ok(response);
    }

    /**
     * Update a response
     */
    @PutMapping("/response/{id}")
    public ResponseEntity<ChatResponse> updateResponse(
            @PathVariable Long id,
            @RequestBody ResponseDTO responseDTO
    ) {
        ChatResponse response = chatbotService.updateResponse(
                id,
                responseDTO.getResponseText(),
                responseDTO.isRequiresDbQuery(),
                responseDTO.getQueryTemplate()
        );

        return ResponseEntity.ok(response);
    }

    /**
     * Delete a response
     */
    @DeleteMapping("/response/{id}")
    public ResponseEntity<String> deleteResponse(@PathVariable Long id) {
        chatbotService.deleteResponse(id);
        return ResponseEntity.ok("Response deleted successfully");
    }

    /**
     * Test database query for a response
     */
    @PostMapping("/test-query")
    public ResponseEntity<List<Map<String, Object>>> testQuery(@RequestBody String query) {
        List<Map<String, Object>> results = chatbotService.executeTestQuery(query);
        return ResponseEntity.ok(results);
    }

    /**
     * Get chatbot statistics
     */
    @GetMapping("/statistics")
    public ResponseEntity<Map<String, Object>> getStatistics() {
        return ResponseEntity.ok(chatbotService.getChatbotStatistics());
    }

    /**
     * Get all available intents
     */
    @GetMapping("/intents")
    public ResponseEntity<List<ChatIntent>> getAllIntents() {
        List<ChatIntent> intents = chatIntentRepository.findAll();
        return ResponseEntity.ok(intents);
    }

    /**
     * Update chatbot configuration settings
     */
    @PostMapping("/settings")
    public ResponseEntity<String> updateSettings(@RequestBody Map<String, Object> settings) {
        chatbotService.updateSettings(settings);
        return ResponseEntity.ok("Settings updated successfully");
    }

    /**
     * Get current chatbot configuration settings
     */
    @GetMapping("/settings")
    public ResponseEntity<Map<String, Object>> getSettings() {
        Map<String, Object> settings = chatbotService.getSettings();
        return ResponseEntity.ok(settings);
    }
}
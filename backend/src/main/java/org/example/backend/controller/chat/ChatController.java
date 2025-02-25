package org.example.backend.controller.chat;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.chat.ChatDto;
import org.example.backend.dto.chat.ReadMessageRequest;
import org.example.backend.service.chat.ChatService;
import org.example.backend.dto.ResponseObject;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/conversations/{userId}")
    public ResponseObject<List<ChatDto.ConversationSummary>> getConversations(@PathVariable Long userId) {
        List<ChatDto.ConversationSummary> conversations = chatService.getRecentConversations(userId);
        return ResponseObject.<List<ChatDto.ConversationSummary>>builder()
                .message("Successfully retrieved conversations")
                .status(200)
                .data(conversations)
                .build();
    }

    @GetMapping("/messages/{user1Id}/{user2Id}")
    public ResponseObject<List<ChatDto.MessageResponse>> getMessages(
            @PathVariable Long user1Id,
            @PathVariable Long user2Id) {
        List<ChatDto.MessageResponse> messages = chatService.getConversation(user1Id, user2Id);
        return ResponseObject.<List<ChatDto.MessageResponse>>builder()
                .message("Successfully retrieved messages")
                .status(200)
                .data(messages)
                .build();
    }

    @PostMapping("/messages/read")
    public ResponseObject<Void> markMessagesAsRead(@RequestBody ReadMessageRequest request) {
        chatService.markAsRead(request.getReceiverId(), request.getSenderId());
        return ResponseObject.<Void>builder()
                .message("Messages marked as read")
                .status(200)
                .build();
    }

    @MessageMapping("/chat.connect")
    public void connect(@Payload Long userId, SimpMessageHeaderAccessor headerAccessor) {
        // Store the user ID in the WebSocket session
        headerAccessor.getSessionAttributes().put("userId", userId);
        chatService.userConnected(userId);
    }

    @MessageMapping("/chat.disconnect")
    public void disconnect(@Payload Long userId) {
        chatService.userDisconnected(userId);
    }

    @MessageMapping("/chat.send")
    public ChatDto.MessageResponse sendMessage(@Payload ChatDto.MessageRequest messageRequest) {
        return chatService.sendMessage(messageRequest);
    }

    @MessageMapping("/chat.read")
    public void readMessage(@Payload ReadMessageRequest request) {
        chatService.markAsRead(request.getReceiverId(), request.getSenderId());
    }
}
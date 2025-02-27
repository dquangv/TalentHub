package org.example.backend.controller.chat;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.chat.ChatDto;
import org.example.backend.dto.chat.ReadMessageRequest;
import org.example.backend.dto.chat.WebRTCDto;
import org.example.backend.entity.child.account.User;
import org.example.backend.exception.NotFoundException;
import org.example.backend.repository.UserRepository;
import org.example.backend.service.chat.ChatService;
import org.example.backend.dto.ResponseObject;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;
    private final UserRepository userRepository;
    private final SimpMessagingTemplate messagingTemplate;

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

    // WebRTC Signaling via REST API (alternative to WebSocket)
    @PostMapping("/call/signal")
    public ResponseObject<WebRTCDto.SignalResponse> sendSignal(@RequestBody WebRTCDto.SignalRequest request) {
        WebRTCDto.SignalResponse response = chatService.handleSignal(request);
        return ResponseObject.<WebRTCDto.SignalResponse>builder()
                .message("Signal processed successfully")
                .status(200)
                .data(response)
                .build();
    }

    // WebSocket Events
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

    // WebRTC Signaling via WebSocket
    @MessageMapping("/chat.signal")
    public WebRTCDto.SignalResponse signal(@Payload WebRTCDto.SignalRequest request) {
        return chatService.handleSignal(request);
    }


    @MessageMapping("/chat.screenShare")
    public void handleScreenShare(@Payload WebRTCDto.ScreenShareRequest request) {
        // Xác thực người dùng và lấy thông tin người gửi
        User sender = userRepository.findById(request.getSenderId())
                .orElseThrow(() -> new NotFoundException("Sender not found with ID: " + request.getSenderId()));

        // Tùy chọn: kiểm tra người nhận có tồn tại không
        userRepository.findById(request.getReceiverId())
                .orElseThrow(() -> new NotFoundException("Receiver not found with ID: " + request.getReceiverId()));

        // Tạo và gửi response đến người nhận
        WebRTCDto.SignalResponse response = new WebRTCDto.SignalResponse(
                sender.getId(),
                sender.getFirstName() + " " + sender.getLastName(),
                sender.getImage(),
                request.getReceiverId(),
                "screen-share", // Loại tín hiệu mới
                null,  // Không cần SDP
                Map.of("isSharing", request.isSharing()),  // Gửi trạng thái chia sẻ màn hình
                LocalDateTime.now().toString()
        );

        messagingTemplate.convertAndSend("/queue/call/" + request.getReceiverId(), response);
    }
}
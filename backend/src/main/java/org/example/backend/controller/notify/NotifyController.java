package org.example.backend.controller.notify;


import lombok.RequiredArgsConstructor;
import org.example.backend.service.impl.notify.NotifyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotifyController {

    private final NotifyService notificationService;

    @PostMapping("/send")
    public ResponseEntity<Void> sendNotification(String message, String url
    ) {
        notificationService.sendNotification(3L, message, url);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<org.example.backend.entity.child.notify.Notification>> getNotifications(@PathVariable Long userId) {
        return ResponseEntity.ok(notificationService.getUserNotifications(userId));
    }

    @PostMapping("/read/{notificationId}")
    public ResponseEntity<Void> markAsRead(@PathVariable Long notificationId) {
        notificationService.markAsRead(notificationId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/read-all/{userId}")
    public ResponseEntity<Void> markAllAsRead(@PathVariable Long userId) {
        notificationService.markAllAsRead(userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/unread-count/{userId}")
    public ResponseEntity<Long> getUnreadCount(@PathVariable Long userId) {
        return ResponseEntity.ok(notificationService.countUnreadNotifications(userId));
    }
}
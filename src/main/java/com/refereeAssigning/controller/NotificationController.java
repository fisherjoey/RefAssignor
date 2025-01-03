package com.refereeAssigning.controller;

import com.refereeAssigning.model.Notification;
import com.refereeAssigning.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // Create a new notification
    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        Notification createdNotification = notificationService.createNotification(notification);
        return ResponseEntity.ok(createdNotification);
    }

    // Get all notifications
    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        List<Notification> notifications = notificationService.getAllNotifications();
        return ResponseEntity.ok(notifications);
    }

    // Get a notification by ID
    @GetMapping("/{id}")
    public ResponseEntity<List<Notification>> getNotificationByUserId(@PathVariable Long id) {
        List<Notification> notifications = notificationService.getNotificationsByUserId(id);
        return ResponseEntity.ok(notifications);
    }

    // Mark a notification as read
    @PutMapping("/{id}/read")
    public ResponseEntity<Notification> markAsRead(@PathVariable Long id) {
        Notification updatedNotification = notificationService.markAsRead(id);
        return ResponseEntity.ok(updatedNotification);
    }

    // Delete a notification by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }

    // Get unread notifications
    @GetMapping("/unread")
    public ResponseEntity<List<Notification>> getUnreadNotifications(@PathVariable Long id) {
        List<Notification> unreadNotifications = notificationService.getUnreadNotificationsByUserId(id);
        return ResponseEntity.ok(unreadNotifications);
    }
}
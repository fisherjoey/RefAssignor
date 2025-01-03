package com.refereeAssigning.service;

import com.refereeAssigning.model.Notification;
import com.refereeAssigning.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    // Get all notifications by user ID
    public List<Notification> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    // Get unread notifications by user ID
    public List<Notification> getUnreadNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserIdAndReadStatus(userId, false);
    }

    // Create a new notification
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    // TODO Mark a notification as read
    public Notification markAsRead(Long notificationId) {
       notificationRepository.markRead(notificationId, true);
       return notificationRepository.findByNotificationId(notificationId);
    }

    public void deleteNotification(Long id) {
        notificationRepository.deleteByNotificationId(id);
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
}
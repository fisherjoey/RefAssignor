package com.refereeAssigning.repository;

import com.refereeAssigning.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // Find notifications by user ID
    List<Notification> findByUserId(Long userId);

    // Find unread notifications for a user
    List<Notification> findByUserIdAndIsReadFalse(Long userId);

    // Find notifications by type (e.g., email, SMS, push)
    List<Notification> findByType(String type);

    // Delete all notifications for a specific user
    void deleteByUserId(Long userId);
}
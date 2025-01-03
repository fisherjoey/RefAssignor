package com.refereeAssigning.repository;

import com.refereeAssigning.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // Find notification by notificationId
    Notification findByNotificationId(long id);

    // Find notifications by user ID
    List<Notification> findByUserId(Long userId);

    // Delete all notifications for a specific user
    void deleteByUserId(Long userId);

    // Find notifications by user ID and read status
    List<Notification> findByUserIdAndReadStatus(Long userId, boolean isRead);

    // Mark notifications as read for a specific user
    @Modifying
    @Transactional
    @Query("UPDATE Notification n SET n.readStatus = :isRead WHERE n.notificationId = :notificationId")
    void markRead(Long notificationId, boolean isRead);

    // Deletes notification using its id
    void deleteByNotificationId(Long id);
}
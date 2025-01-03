package com.refereeAssigning.repository;

import com.refereeAssigning.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // Find notifications by user ID
    List<Notification> findByUserId(Long userId);

    // TODO Find unread notifications for a user



    // Delete all notifications for a specific user
    void deleteByUserId(Long userId);
}
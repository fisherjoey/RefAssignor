package com.refereeAssigning.repository;

import com.refereeAssigning.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    // Find notifications by user ID
    List<Notification> findByUserId(Long userId);



    // Delete all notifications for a specific user
    void deleteByUserId(Long userId);

    List<Notification> findByUserIdAndReadStatus(Long userId, boolean isRead);}
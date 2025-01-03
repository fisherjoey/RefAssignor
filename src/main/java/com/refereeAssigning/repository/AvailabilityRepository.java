package com.refereeAssigning.repository;

import com.refereeAssigning.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

    // Find all availability for a specific referee
    List<Availability> findByRefereeId(Long refereeId);

    // Find availability for a referee within a date range
    List<Availability> findByRefereeIdAndStartTimeBetween(Long refereeId, LocalDateTime startTime, LocalDateTime endTime);

    // Deletes all availability for a referee
    void deleteByRefereeId(Long refereeId);

    // Find all availability overlapping a specific time
    List<Availability> findByStartTimeLessThanEqualAndEndTimeGreaterThanEqual(LocalDateTime endTime, LocalDateTime startTime);
}
package com.refereeAssigning.repository;

import com.refereeAssigning.model.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

    // Find all availability for a specific referee
    List<Availability> findByRefereeId(Long refereeId);

    // Find availability for a referee within a date range
    List<Availability> findByRefereeIdAndStartDateTimeLessThanEqualAndEndDateTimeGreaterThanEqual(
            Long refereeId, LocalTime startDateTime, LocalTime endDateTime
    );
    // Deletes all availability for a referee
    void deleteByRefereeId(Long refereeId);

    // Find all player availability overlapping a specific time
    List<Availability> findByStartDateTimeLessThanEqualAndEndDateTimeGreaterThanEqual(
            LocalTime startDateTime, LocalTime endDateTime
    );

    @Query("SELECT a FROM Availability a WHERE a.refereeId = :refereeId AND a.startDateTime >= :startDateTime AND a.endDateTime <= :endDateTime")
    List<Availability> findByRefereeIdAndDateRange(Long refereeId, LocalDateTime startDateTime, LocalDateTime endDateTime);
}
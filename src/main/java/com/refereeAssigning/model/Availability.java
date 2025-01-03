package com.refereeAssigning.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "availability")
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long availabilityId;

    @Column(nullable = false)
    private Long refereeId; // ID of the referee

    @Column(nullable = false)
    private LocalTime startDateTime; // Start date time of availability

    @Column(nullable = false)
    private LocalTime endDateTime; // End date time of availability

    // Getters and Setters

    public Long getAvailabilityId() {
        return availabilityId;
    }

    public void setAvailabilityId(Long availabilityId) {
        this.availabilityId = availabilityId;
    }

    public Long getRefereeId() {
        return refereeId;
    }

    public void setRefereeId(Long refereeId) {
        this.refereeId = refereeId;
    }

    public LocalTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalTime getEndDataTime() {
        return endDateTime;
    }

    public void setEndDataTime(LocalTime endDataTime) {
        this.endDateTime = endDataTime;
    }
}
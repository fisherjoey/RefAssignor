package com.refereeAssigning.service;

import com.refereeAssigning.model.Availability;
import com.refereeAssigning.repository.AvailabilityRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AvailabilityService {

    private final AvailabilityRepository availabilityRepository;

    public AvailabilityService(AvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }

    // Add availability for a referee
    public Availability createAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    // Get all availabilities for a specific referee
    public List<Availability> getAvailabilitiesByRefereeId(Long userId) {
        return availabilityRepository.findByRefereeId(userId);
    }

    // Delete availability by ID
    public void deleteAvailability(Long id) {
        availabilityRepository.deleteById(id);
    }

    // Check if a specific availability exists
    public boolean availabilityExists(Long id) {
        return availabilityRepository.existsById(id);
    }

    // Get all availabilities between dates
    public List<Availability> getAllAvailabilities() {
        return availabilityRepository.findAll();
    }

    // Get availability using availability ID
    public Availability getAvailabilityById(Long id) {
        return availabilityRepository.findById(id).orElse(null);
    }

    // Update availability record TODO: Test to make sure it replaces with the notification id, rather than generating a new one
    public Availability updateAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    public List<Availability> getAvailabilitiesByRefereeAndDateRange(Long refereeId, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return availabilityRepository.findByRefereeIdAndDateRange(refereeId, startDateTime, endDateTime);
    }
}
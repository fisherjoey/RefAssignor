package com.refereeAssigning.service;

import com.refereeAssigning.model.Availability;
import com.refereeAssigning.repository.AvailabilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvailabilityService {

    private final AvailabilityRepository availabilityRepository;

    public AvailabilityService(AvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }

    // Add availability for a referee
    public Availability addAvailability(Availability availability) {
        return availabilityRepository.save(availability);
    }

    // Get all availabilities for a specific referee
    public List<Availability> getAvailabilitiesByUserId(Long userId) {
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
}
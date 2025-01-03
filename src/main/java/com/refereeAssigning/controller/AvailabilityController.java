package com.refereeAssigning.controller;

import com.refereeAssigning.model.Availability;
import com.refereeAssigning.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/availabilities")
public class AvailabilityController {

    private final AvailabilityService availabilityService;

    @Autowired
    public AvailabilityController(AvailabilityService availabilityService) {
        this.availabilityService = availabilityService;
    }

    // Create a new availability
    @PostMapping
    public ResponseEntity<Availability> createAvailability(@RequestBody Availability availability) {
        Availability createdAvailability = availabilityService.createAvailability(availability);
        return ResponseEntity.ok(createdAvailability);
    }

    // Get all availabilities
    @GetMapping
    public ResponseEntity<List<Availability>> getAllAvailabilities() {
        List<Availability> availabilities = availabilityService.getAllAvailabilities();
        return ResponseEntity.ok(availabilities);
    }

    // Get availability by ID
    @GetMapping("/{id}")
    public ResponseEntity<Availability> getAvailabilityById(@PathVariable Long id) {
        Availability availability = availabilityService.getAvailabilityById(id);
        return ResponseEntity.ok(availability);
    }

    // Update an availability
    @PutMapping("/{id}")
    public ResponseEntity<Availability> updateAvailability(@PathVariable Long id, @RequestBody Availability availability) {
        Availability updatedAvailability = availabilityService.updateAvailability(availability);
        return ResponseEntity.ok(updatedAvailability);
    }

    // Delete an availability by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAvailability(@PathVariable Long id) {
        availabilityService.deleteAvailability(id);
        return ResponseEntity.noContent().build();
    }

    // Get availabilities for a specific referee
    @GetMapping("/referee/{refereeId}")
    public ResponseEntity<List<Availability>> getAvailabilitiesByReferee(@PathVariable Long refereeId) {
        List<Availability> availabilities = availabilityService.getAvailabilitiesByRefereeId(refereeId);
        return ResponseEntity.ok(availabilities);
    }

    // Get availabilities for a referee within a specific date range
    @GetMapping("/referee/{refereeId}/date-range")
    public ResponseEntity<List<Availability>> getAvailabilitiesByRefereeAndDateRange(
            @PathVariable Long refereeId,
            @RequestParam LocalDateTime startDateTime,
            @RequestParam LocalDateTime endDateTime) {
        List<Availability> availabilities = availabilityService.getAvailabilitiesByRefereeAndDateRange(refereeId, startDateTime, endDateTime);
        return ResponseEntity.ok(availabilities);
    }
}
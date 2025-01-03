package com.refereeAssigning.repository;

import com.refereeAssigning.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


//TODO: Create new queries when needed
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    // Find games by home team
    List<Game> findByHomeTeam(String homeTeam);

    // Find games by away team
    List<Game> findByAwayTeam(String awayTeam);

    // Find games where a specific referee is assigned
    List<Game> findByAssignedRefereeId(Long refereeId);

    // Find games by status (e.g., completed, scheduled, etc.)
    List<Game> findByStatus(String status);

    // Custom query to find games by date range
    List<Game> findByGameDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
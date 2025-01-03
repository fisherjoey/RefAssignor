package com.refereeAssigning.repository;

import com.refereeAssigning.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    // Find games by Assigned Referee
    @Query("SELECT g FROM Game g WHERE :refereeId MEMBER OF g.assignedReferees")
    List<Game> findByAssignedRefereeId(Long refereeId);

    List<Game> findByDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);
}
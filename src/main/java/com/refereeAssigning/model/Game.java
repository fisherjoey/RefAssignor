package com.refereeAssigning.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gameId;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private String homeTeam; // Home Team Name

    @Column(nullable = false)
    private String awayTeam; // Away Team Name

    @Column(nullable = false)
    private String league;

    @Column(nullable = false)
    private Double score;

    @ElementCollection
    @CollectionTable(name = "game_referees", joinColumns = @JoinColumn(name = "game_id"))
    @Column(name = "referee_id")
    private List<Long> assignedReferees;

    @Column(nullable = false)
    private Double payDetails;

    // Getters and setters
    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public List<Long> getAssignedReferees() {
        return assignedReferees;
    }

    public void setAssignedReferees(List<Long> assignedReferees) {
        this.assignedReferees = assignedReferees;
    }

    public Double getPayDetails() {
        return payDetails;
    }

    public void setPayDetails(Double payDetails) {
        this.payDetails = payDetails;
    }
}
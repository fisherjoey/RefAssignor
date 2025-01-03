package com.refereeAssigning.service;

import com.refereeAssigning.model.Game;
import com.refereeAssigning.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    // Get all games
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    // Get a game by ID
    public Game getGameById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found with ID: " + id));
    }

    // Create a new game
    public Game createGame(Game game) {
        // Additional validation or business logic can go here
        return gameRepository.save(game);
    }

    // Update an existing game
    public Game updateGame(Long id, Game updatedGame) {
        Game existingGame = gameRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found with ID: " + id));

        // Update fields
        existingGame.setHomeTeam(updatedGame.getHomeTeam());
        existingGame.setAwayTeam(updatedGame.getAwayTeam());
        existingGame.setDateTime(updatedGame.getDateTime());
        existingGame.setAssignedReferees(updatedGame.getAssignedReferees());

        return gameRepository.save(existingGame);
    }

    // Delete a game by ID
    public void deleteGameById(Long id) {
        if (!gameRepository.existsById(id)) {
            throw new RuntimeException("Game not found with ID: " + id);
        }
        gameRepository.deleteById(id);
    }

    // Get games by referee ID
    public List<Game> getGamesByReferee(Long refereeId) {
        return gameRepository.findByAssignedRefereeId(refereeId);
    }

    // Get games by date range
    public List<Game> getGamesByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return gameRepository.findByDateTimeBetween(startDate, endDate);
    }
}
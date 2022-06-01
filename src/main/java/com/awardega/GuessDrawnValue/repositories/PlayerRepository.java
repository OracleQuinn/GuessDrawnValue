package com.awardega.GuessDrawnValue.repositories;

import com.awardega.GuessDrawnValue.entities.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository {

    @Query("SELECT TOP 10 p FROM Players p ORDER BY p.numberOfTries DESC")
    List<Player> players();

    @Query("SELECT p FROM Players WHERE p.id = ?1")
    List<Player> playerById(Long id);
}


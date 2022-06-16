package com.awardega.GuessDrawnValue.services;

import com.awardega.GuessDrawnValue.entities.Player;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

class GameServiceTest {
    @Autowired
    GameService gameService;

    @Test
    void addNewPlayer() {
    }

    @Test
    void getAllPlayers() {
        List<Player> playerArrayList = new ArrayList<>();
        Player player1 = new Player();
        player1.setId("Test1");
        Player player2 = new Player();
        player2.setId("Test2");

        playerArrayList.add(player1);
        playerArrayList.add(player2);
        gameService.addNewPlayer(player1);
        gameService.addNewPlayer(player2);

        assertThat(playerArrayList.get(0).getId()).isEqualTo(gameService.getAllPlayers().get(0).getId());
    }

    @Test
    void getPlayer() {
        String id = "Test1";
        Player player1 = gameService.getPlayer(id);

        assertThat(player1.getId())
                .isEqualTo(id);
    }

    @Test
    void startingGame() {

    }

    @Test
    void best10Players() {
    }

    @Test
    void verifyGuess() {
        Player playerJoe = new Player();
        playerJoe.setId("JoeDoe");
        String result = gameService.verifyGuess(10,5);
        Assert.assertEquals("Too small 🙁 ", result);

        String result1 = gameService.verifyGuess(10,15);
        Assert.assertEquals("Too big 😐 ", result1);

        String result2 = gameService.verifyGuess(10,10);
        Assert.assertEquals("Congratulations! You win!", result2);
    }
}
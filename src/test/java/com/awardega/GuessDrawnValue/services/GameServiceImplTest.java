package com.awardega.GuessDrawnValue.services;

import com.awardega.GuessDrawnValue.entities.Game;
import com.awardega.GuessDrawnValue.entities.Player;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest
@AutoConfigureMockMvc
class GameServiceImplTest {
    @Autowired
    GameServiceImpl gameService;

    @BeforeEach
    void setUp() {
        System.out.println("Set up");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tear down");
    }

    @Test
    void verifyGuess() {
        Player playerJoe = new Player();
        playerJoe.setId("JoeDoe");
        String result = gameService.verifyGuess(playerJoe, 10,5);
        Assert.assertEquals("Too small 🙁 ", result);

        String result1 = gameService.verifyGuess(playerJoe, 10,15);
        Assert.assertEquals("Too big 😐 ", result1);

        String result2 = gameService.verifyGuess(playerJoe, 10,10);
        Assert.assertEquals("Congratulations! You win!", result2);
    }

    @Test
    void getPlayer() {
        Player player = new Player();
        player.setId("JoeDoe");
        gameService.addNewPlayer(player);

        String id = "JoeDoe";
        Player wanted = gameService.getPlayer(id);

        assertThat(wanted.getId())
                .isEqualTo(id);
    }

    @Test
    void startingGame() {
    }

    @Test
    void addNewPlayer() {
    }

    @Test
    void get10BestPlayers() {
        List<Player> listOfBestPlayers = new ArrayList<>();
        Player player1 = new Player();
        player1.setId("1");
        player1.setNumberOfTries(1);
        Player player2 = new Player();
        player1.setId("2");
        player1.setNumberOfTries(2);
        Player player3 = new Player();
        player1.setId("3");
        player1.setNumberOfTries(3);
        Player player4 = new Player();
        player1.setId("4");
        player1.setNumberOfTries(4);
        Player player5 = new Player();
        player1.setId("5");
        player1.setNumberOfTries(5);
        Player player6 = new Player();
        player1.setId("6");
        player1.setNumberOfTries(6);
        Player player7 = new Player();
        player1.setId("7");
        player1.setNumberOfTries(7);
        Player player8 = new Player();
        player1.setId("8");
        player1.setNumberOfTries(8);
        Player player9 = new Player();
        player1.setId("9");
        player1.setNumberOfTries(9);
        Player player10 = new Player();
        player1.setId("10");
        player1.setNumberOfTries(10);


        listOfBestPlayers.add(player1);
        listOfBestPlayers.add(player2);
        listOfBestPlayers.add(player3);
        listOfBestPlayers.add(player4);
        listOfBestPlayers.add(player5);
        listOfBestPlayers.add(player6);
        listOfBestPlayers.add(player7);
        listOfBestPlayers.add(player8);
        listOfBestPlayers.add(player9);
        listOfBestPlayers.add(player10);

        assertThat(listOfBestPlayers)
                .isEqualTo(gameService.get10BestPlayers());

        assertThat(gameService.get10BestPlayers()).hasSize(10);
    }
}
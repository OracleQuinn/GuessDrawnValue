package com.awardega.GuessDrawnValue.services;

import com.awardega.GuessDrawnValue.entities.Game;
import com.awardega.GuessDrawnValue.entities.Player;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.registerCustomDateFormat;

import java.util.ArrayList;
import java.util.List;

class GameServiceTest {
    @Autowired
    GameService gameService;

    @BeforeEach
    void setUp() {
        System.out.println("Set up");
        gameService = new GameService();
    }

    @AfterEach
    void tearDown() {
        System.out.println("Tear down");
    }

    @Test
    void addNewPlayer() {
        List<Player> listOfPlayers = new ArrayList<>();
        Player player = new Player();
        player.setId("Test1");
        listOfPlayers.add(player);

        Player newPlayer = new Player();
        newPlayer.setId("Test1");

        assertThat(newPlayer.getId().equals(listOfPlayers.get(0).getId())).isEqualTo(true);
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
        List<Player> playerList = new ArrayList<>();
        Player player1 = new Player();
        player1.setId("Test1");
        player1.setNumberOfTries(1);
        Player player2 = new Player();
        player2.setId("Test2");
        player2.setNumberOfTries(2);
        Player player3 = new Player();
        player3.setId("Test3");
        player3.setNumberOfTries(3);
        Player player4 = new Player();
        player4.setId("Test4");
        player4.setNumberOfTries(4);
        Player player5 = new Player();
        player5.setId("Test5");
        player5.setNumberOfTries(5);
        Player player6 = new Player();
        player6.setId("Test6");
        player6.setNumberOfTries(6);
        Player player7 = new Player();
        player7.setId("Test7");
        player7.setNumberOfTries(7);
        Player player8 = new Player();
        player8.setId("Test8");
        player8.setNumberOfTries(8);
        Player player9 = new Player();
        player9.setId("Test9");
        player9.setNumberOfTries(9);
        Player player10 = new Player();
        player10.setId("Test10");
        player10.setNumberOfTries(10);

        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        playerList.add(player4);
        playerList.add(player5);
        playerList.add(player6);
        playerList.add(player7);
        playerList.add(player8);
        playerList.add(player9);
        playerList.add(player10);

        gameService.listOfWinners.add(player1);
        gameService.listOfWinners.add(player2);
        gameService.listOfWinners.add(player3);
        gameService.listOfWinners.add(player4);
        gameService.listOfWinners.add(player5);
        gameService.listOfWinners.add(player6);
        gameService.listOfWinners.add(player7);
        gameService.listOfWinners.add(player8);
        gameService.listOfWinners.add(player9);
        gameService.listOfWinners.add(player10);

        assertThat(playerList)
                .isEqualTo(gameService.best10Players());

        assertThat(gameService.best10Players()).hasSize(10);

    }

    @Test
    void verifyGuess() {
        String result = gameService.verifyGuess(10,5);
        Assert.assertEquals("Too small 🙁 ", result);

        String result1 = gameService.verifyGuess(10,15);
        Assert.assertEquals("Too big 😐 ", result1);

        String result2 = gameService.verifyGuess(10,10);
        Assert.assertEquals("Congratulations! You win!", result2);
    }
}
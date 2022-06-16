package com.awardega.GuessDrawnValue.controllers;

import com.awardega.GuessDrawnValue.entities.Player;
import com.awardega.GuessDrawnValue.services.GameService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
class GuessGameControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    GameService gameService;

    @BeforeEach
    public void setUp() {
        Player player1 = new Player();
        player1.setId("JoeDoe");
        Player player2 = new Player();
        player2.setId("AgnieszkaWardega");

        gameService.addNewPlayer(player1);
        gameService.addNewPlayer(player2);
    }

    @Test
    void getPlayerTest() throws Exception {

        this.mockMvc
                .perform(get("/GuessNumberGame/start/JoeDoe"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nick").value("JoeDoe"))
                .andExpect(jsonPath("$.attempt").value(1));
    }

    @Test
    void addNewPlayerTest() throws Exception {

        this.mockMvc
                .perform(post("/GuessNumberGame/start")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(gameService.getPlayer("AgnieszkaWardega"))))
                .andExpect(status().isCreated());

        assertThat(gameService.getPlayer("matmed").getId()).isEqualTo("AgnieszkaWardega");
    }


    @Test
    void startingGameTest() throws Exception {

        this.mockMvc
                .perform(get("/GuessNumberGame/guess/AgnieszkaWardega/89"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"));


    }


    @Test
    void getBest10Test() throws Exception {

        this.mockMvc
                .perform(get("/start/best10"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }


    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
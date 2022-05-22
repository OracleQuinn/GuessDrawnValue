package com.awardega.GuessDrawnValue.controllers;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(StartGameController.class)
class StartGameControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void startGamePage() throws Exception{
        this.mockMvc
                .perform(get("/start"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("start"))
                .andExpect(content().string(containsString("Your id: ")));
    }
}
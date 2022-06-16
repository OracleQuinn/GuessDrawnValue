package com.awardega.GuessDrawnValue.repositories;

import com.awardega.GuessDrawnValue.entities.Player;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.*;

@Data
@RequiredArgsConstructor
@Component
public class PlayerRepository {
    private static final List<Player> playerList = new ArrayList<>();

    public List<Player> getPlayerList(){
        return playerList;
    }
}


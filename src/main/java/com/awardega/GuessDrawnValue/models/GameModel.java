package com.awardega.GuessDrawnValue.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Data
@RequiredArgsConstructor
public class GameModel {
    public  int gameId;
    public String target;
    public boolean finished;

    public  GameModel(String target, boolean finished){
        this.target = target;
        this.finished = finished;
    }

    public  GameModel(int gameId, String target, boolean finished){
        this.target = target;
        this.finished = finished;
        this.gameId = gameId;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GameModel other = (GameModel) obj;
        if (this.gameId != other.gameId) {
            return false;
        }
        if (this.finished != other.finished) {
            return false;
        }
        if (!Objects.equals(this.target, other.target)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "gameId=" + gameId + ", target=" + target + ", finished=" + finished + '}';
    }
}

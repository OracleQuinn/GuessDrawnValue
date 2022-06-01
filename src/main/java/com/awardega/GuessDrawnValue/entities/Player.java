package com.awardega.GuessDrawnValue.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import javax.persistence.*;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "NUMBER_OF_TRIES", unique = false)
    private Integer numberOfTries = 0;

    public Player(String id, Integer numberOfTries){
        this.id = id;
        this.numberOfTries = numberOfTries;
    }

    @Override
    public String toString(){
        return "Player{" +
                "id" + id +
                ", numberOfTries = " + numberOfTries +
                '}';
    }
}

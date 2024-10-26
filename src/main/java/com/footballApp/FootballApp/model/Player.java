package com.footballApp.FootballApp.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class Player extends Person {
    private Position position;
    private Integer nr;

    @Id
    private Long id;

    public Player(Long id, String name, String surname, String email, Integer age,
                  Position position, Integer nr) {
        super(name, surname, email, age);
        this.id = id;
        this.position = position;
        this.nr = nr;

    }
}
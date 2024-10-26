package com.footballApp.FootballApp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.message.AsynchronouslyFormattable;

@Table
@Entity
@NoArgsConstructor
@Setter
@Getter
public class Trainner  extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false,name = "Trainner_ID")
    private Long id;
    private String team;
    private Double salary;


    public Trainner( Long id,String name, String surname, String email, Integer age, String team, Double salary) {
        super(name, surname, email, age);
        this.id = id;
        this.team = team;
        this.salary = salary;
    }


}

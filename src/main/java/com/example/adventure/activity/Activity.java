package com.example.adventure.activity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ACTIVITY")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "HOURLY_RATE")
    private double hourPrice;


    @Column(name = "NAME")
    private String name;

    @Column(name = "MIN_AGE")
    private int minAge;

    @Column(name = "DESC")
    private String description;

    public Activity(double hourPrice, String name, int minAge, String description) {
        this.hourPrice = hourPrice;
        this.name = name;
        this.minAge = minAge;
        this.description = description;
    }

}

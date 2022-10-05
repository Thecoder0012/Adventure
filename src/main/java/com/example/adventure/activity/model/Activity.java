package com.example.adventure.activity.model;

import com.example.adventure.booking.model.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

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


    @ManyToMany(cascade = {
            CascadeType.MERGE
    })
    @JoinTable(name = "activity_booking",
            joinColumns = @JoinColumn(name = "activity_id"),
            inverseJoinColumns = @JoinColumn(name = "booking_id")
    )
    private List<Booking> bookings = new ArrayList<>();


    public Activity(double hourPrice, String name, int minAge, String description) {
        this.hourPrice = hourPrice;
        this.name = name;
        this.minAge = minAge;
        this.description = description;
    }

}

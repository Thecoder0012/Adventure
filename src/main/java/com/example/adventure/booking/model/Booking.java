package com.example.adventure.booking.model;

import com.example.adventure.activity.model.Activity;
import com.example.adventure.customer.model.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "BOOKING")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;


    public Booking(String name) {
        this.name = name;
    }


    @ManyToOne
    Activity activity;

    @ManyToOne
    Customer customer;



    public Booking(String name, Activity activity, Customer customer) {
        this(name);
        this.activity = activity;
        this.customer = customer;
    }



}

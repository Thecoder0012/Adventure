package com.example.adventure.booking.model;

import com.example.adventure.activity.model.Activity;
import com.example.adventure.customer.model.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "BOOKING")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DATE")
    private LocalDate localDate;

    @Column(name = "TIMESTART")
    private LocalTime timeStart;

    @Column(name = "TIMEEND")
    private LocalTime timeEnd;

    @ManyToOne
    Activity activity;

    @ManyToOne
    Customer customer;

    public Booking(LocalDate localDate, LocalTime timeStart, LocalTime timeEnd){
        this.localDate = localDate;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public Booking(LocalDate localDate, LocalTime timeStart, LocalTime timeEnd, Activity activity, Customer customer) {
        this(localDate, timeStart, timeEnd);
        this.activity = activity;
        this.customer = customer;
    }





}

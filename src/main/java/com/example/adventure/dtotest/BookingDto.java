package com.example.adventure.dtotest;

import com.example.adventure.activity.model.Activity;
import com.example.adventure.customer.model.Customer;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Data
public class BookingDto implements Serializable {
    private Long id;
    private LocalDate localDate;
    private LocalTime timeStart;
    private LocalTime timeEnd;
    private Activity activity;
    private Customer customer;
}

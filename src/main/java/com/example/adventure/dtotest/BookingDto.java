package com.example.adventure.dtotest;

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
    private ActivityDto activityDto;
    private CustomerDto customerDto;
}

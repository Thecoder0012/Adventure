package com.example.adventure.dtotest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@Data
public class BookingDto implements Serializable {
    private Long id;
//    @JsonProperty("booking_date")
    private LocalDate localDate;
//    @JsonProperty("booking_time_from")
    private LocalTime timeStart;
//    @JsonProperty("booking_time_to")
    private LocalTime timeEnd;
//    @JsonProperty("activity")
    private ActivityDto activityDto;
//    @JsonProperty("customer")
    private CustomerDto customerDto;
}

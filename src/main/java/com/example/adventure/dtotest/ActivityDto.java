package com.example.adventure.dtotest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class ActivityDto {
    private Long id;
    @JsonProperty("hour-price")
    private double hourPrice;
    private String name;
    @JsonProperty("minimum-age")
    private int minAge;
    private String description;
}

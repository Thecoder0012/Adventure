package com.example.adventure.dtotest;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Data
public class ActivityDto {
    private Long id;
    private double hourPrice;
    private String name;
    private int minAge;
    private String description;
}

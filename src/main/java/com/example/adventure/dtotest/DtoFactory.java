package com.example.adventure.dtotest;

import com.example.adventure.activity.model.Activity;

import java.util.List;
import java.util.stream.Collectors;

public class DtoFactory {


    // For Activity
    public static ActivityDto fromActivity(Activity activity) {
        ActivityDto dto = new ActivityDto();
        dto.setId(activity.getId());
        dto.setHourPrice(activity.getHourPrice());
        dto.setName(activity.getName());
        dto.setMinAge(activity.getMinAge());
        dto.setDescription(activity.getDescription());
        return dto;
    }

    public static List<ActivityDto> fromActivities(List<Activity> activities) {
        return activities.stream().map(obj -> fromActivity(obj))
                .collect(Collectors.toList());
    }
}

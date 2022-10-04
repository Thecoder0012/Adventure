package com.example.adventure.activity.service;

import com.example.adventure.activity.model.Activity;
import com.example.adventure.activity.repository.ActivityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ActivityService {


 private final ActivityRepository repository;

    public List<Activity> getAll() {
        return repository.findAll();

    }

    public Activity saveActivity(Activity activity){
        return repository.save(activity);
    }

    public Activity getActivityById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Activity getActivityByName(String name){
        return repository.findByName(name);
    }

    public String deleteActivity(Long id){
        repository.deleteById(id);
        return "Activity removed" + id;
    }

    public Activity updateActivity(Activity activity){
        Activity existingActivity=repository.findById(activity.getId()).orElse(null);
        existingActivity.setHourPrice(activity.getHourPrice());
        existingActivity.setName(activity.getName());
        existingActivity.setMinAge(activity.getMinAge());
        existingActivity.setDescription(activity.getDescription());
        return repository.save(existingActivity);
    }


}

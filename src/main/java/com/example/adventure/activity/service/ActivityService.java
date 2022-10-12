package com.example.adventure.activity.service;

import com.example.adventure.activity.model.Activity;
import com.example.adventure.activity.repository.ActivityRepository;
import com.example.adventure.dtotest.ActivityDto;
import com.example.adventure.dtotest.DtoFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ActivityService {


 private final ActivityRepository repository;

    public List<Activity> getAll() {
        return repository.findAll();
    }

    public Activity addActivity(Activity activity){
        return repository.save(activity);
    }

    public Activity getActivityById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Activity %d not found.".formatted(id)));
    }

    public Activity getActivityByName(String name){
        return repository.findByName(name.toLowerCase());
    }

    public Optional<Activity> find(Long id){
        return repository.findById(id);
    }

    public Activity deleteActivity(Long id){
        repository.deleteById(id);
        return null;
    }

    public Activity updateActivity(Long id, Activity activity){
        Activity existingActivity = repository.findById(id).orElse(null);
        existingActivity.setHourPrice(activity.getHourPrice());
        existingActivity.setName(activity.getName());
        existingActivity.setMinAge(activity.getMinAge());
        existingActivity.setDescription(activity.getDescription());
        return repository.save(existingActivity);
    }

    public Activity updateAc(Long id, Activity newActivity){
        Activity activity = repository.findById(id).get();
        activity.setHourPrice(newActivity.getHourPrice());
        activity.setName(newActivity.getName());
        activity.setMinAge(newActivity.getMinAge());
        activity.setDescription(newActivity.getDescription());

        return repository.save(activity);
    }

    public Optional<Activity> update(Long id, Activity activity){
        return repository.findById(id)
                .map(oldItem -> {
                    return repository.save(oldItem.updateWith(activity));
                });
    }

    public ActivityDto updateDto(Long id, ActivityDto dto) {
        Optional<Activity> item = update(id, DtoFactory.fromActivityDto(dto));
        return DtoFactory.fromActivity(item.get());
    }



}

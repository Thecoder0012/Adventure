package com.example.adventure.activity.controller;

import com.example.adventure.activity.Activity;
import com.example.adventure.activity.ActivityService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/activity")
public class ActivityController {


    private final ActivityService service;

    @GetMapping("/getAllActivities")
    public List<Activity> getAll() {
        return service.getAll();

    }

    @GetMapping("/activityById/{id}")
    public Activity getActivityById(@PathVariable Long id) {
        return service.getActivityById(id);
    }

    @GetMapping("/activityByName/{name}")
public Activity getActivityByName(@PathVariable String name){
        return service.getActivityByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        return service.deleteActivity(id);
    }


}

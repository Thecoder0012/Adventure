package com.example.adventure.activity.controller;//


import com.example.adventure.activity.service.ActivityService;
import com.example.adventure.activity.model.Activity;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/activity")
public class ActivityController {


    private final ActivityService service;

    @GetMapping
    public List<Activity> getAll() {
        return service.getAll();

    }

    @PostMapping
    public Activity addActivity(@RequestBody Activity activity){
        return service.saveActivity(activity);
    }

    @GetMapping("/{id}")
    public Activity getActivityById(@PathVariable Long id) {
        return service.getActivityById(id);
    }

    @GetMapping("/name/{name}")
    public Activity getActivityByName(@PathVariable String name){
        return service.getActivityByName(name);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        return service.deleteActivity(id);
    }

    @PutMapping("/update")
    public Activity UpdateActivity(@RequestBody Activity activity) {
        return service.updateActivity(activity);
    }




}

package com.example.adventure.activity.controller;//


import com.example.adventure.activity.service.ActivityService;
import com.example.adventure.activity.model.Activity;
import com.example.adventure.dtotest.ActivityDto;
import com.example.adventure.dtotest.DtoFactory;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/api/v1/activity")
public class ActivityController {

    private ModelMapper modelMapper;

    private final ActivityService service;

    @GetMapping
    public ResponseEntity<List<ActivityDto>> findAll() {
        List<Activity> activities = service.getAll();
        List<ActivityDto> activityDtos = new ArrayList<>();
        for (Activity activity : activities){
            ActivityDto activityDtoTest = new ActivityDto();
            BeanUtils.copyProperties(activity, activityDtoTest);
            activityDtos.add((activityDtoTest));
        }

        return ResponseEntity.ok().body(activityDtos);
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

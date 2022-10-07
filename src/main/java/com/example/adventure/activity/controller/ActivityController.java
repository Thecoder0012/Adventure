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

    private final ActivityService service;

    @GetMapping
    public ResponseEntity<List<ActivityDto>> findAll() {
        return ResponseEntity.ok().body(DtoFactory.fromActivities(service.getAll()));
    }

    @PostMapping("/test")
    public Activity addActivity(@RequestBody Activity activity){
        return service.saveActivity(activity);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ActivityDto> getActivityById(@PathVariable Long id) {
        return ResponseEntity.ok().body(DtoFactory.fromActivity(service.getActivityById(id)));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ActivityDto> getActivityByName(@PathVariable String name){
        return ResponseEntity.ok().body(DtoFactory.fromActivity(service.getActivityByName(name)));
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

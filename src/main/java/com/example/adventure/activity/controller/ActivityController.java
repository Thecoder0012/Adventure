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

    //Virker
    @GetMapping
    public ResponseEntity<List<ActivityDto>> findAll() {
        return ResponseEntity.ok().body(DtoFactory.fromActivities(service.getAll()));
    }

    //Virker
    @PostMapping("/test")
    public Activity addActivity(@RequestBody Activity activity) {
        return service.saveActivity(activity);
    }

    //Virker ikke
    @GetMapping("/{id}")
    public ResponseEntity<ActivityDto> getActivityById(@PathVariable Long id) {
        return ResponseEntity.ok().body(DtoFactory.fromActivity(service.getActivityById(id)));
    }

    //Virker ikke
    @GetMapping("/{name}")
    public ResponseEntity<ActivityDto> getActivityByName(@PathVariable String name) {
        return ResponseEntity.ok().body(DtoFactory.fromActivity(service.getActivityByName(name)));
    }

//Virker
    @DeleteMapping("/{id}")
    public ResponseEntity<Activity> delete(@PathVariable("id") Long id) {
        service.find(id).orElseThrow(() -> new RuntimeException("Activity not found.".formatted(id)));

        Activity delete = service.deleteActivity(id);
        return ResponseEntity.ok().body(delete); }

    //Ikke test
    @PutMapping("/update")
    public Activity UpdateActivity(@RequestBody Activity activity) {
        return service.updateActivity(activity);
    }


}

package com.example.adventure.activity.controller;//


import com.example.adventure.activity.service.ActivityService;
import com.example.adventure.activity.model.Activity;
import com.example.adventure.dtotest.ActivityDto;
import com.example.adventure.dtotest.DtoFactory;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/api/v1/activity")
public class ActivityController {

    private final ActivityService activityService;

    /**
     * Fetches all activities and gets returned as ActivityDto's
     * @return ActivityDto list
     * @link <a href="http://localhost:8080/api/v1/activity">...</a>
     */
    @GetMapping
    public ResponseEntity<List<ActivityDto>> findAll() {
        if (activityService.getAll() != null) {
            return ResponseEntity.ok().body(DtoFactory.fromActivities(activityService.getAll()));
        }
        return ResponseEntity.badRequest().build();
    }

    /**
     * Create a new activity returned as an activityDto.
     * @param activity
     * @return ActivityDto list
     * @link <a href="http://localhost:8080/api/v1/activity/">...</a>
     */
    @PostMapping("/add")
    public ResponseEntity<ActivityDto> addActivity(@Valid @RequestBody Activity activity) {
        if (activity != null) {
            return ResponseEntity.ok().body(DtoFactory.fromActivity(activityService.saveActivity(activity)));
        }
        return ResponseEntity.badRequest().build();
    }


    /**
     * Fetch an activity by id
     * @param id
     * @return Activity Dto
     */
    @GetMapping("/id/{id}")
    public ResponseEntity<ActivityDto> getActivityById(@PathVariable(value = "id") Long id) {
        return ResponseEntity.ok().body(DtoFactory.fromActivity(activityService.getActivityById(id)));
    }

    /**
     * Fetch an activity by name
     * @param name
     * @return Activity Dto
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<ActivityDto> getActivityByName(@PathVariable(value = "name") String name) {
        if (name != null) {
            return ResponseEntity.ok().body(DtoFactory.fromActivity(activityService.getActivityByName(name)));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Activity> delete(@PathVariable("id") Long id) {
        if (id != null) {
            activityService.find(id).orElseThrow(() -> new RuntimeException("Not found"));
            return ResponseEntity.ok().body(activityService.deleteActivity(id));
        }
        return ResponseEntity.badRequest().build();
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Activity> updateActivity(@PathVariable(value = "id") Long id, @RequestBody Activity activity) {
        return ResponseEntity.ok().body(activityService.updateAc(id,activity));
    }
}

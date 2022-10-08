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

    //Virker - IK SLET ENDPOINT
    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<ActivityDto> getActivityById(@PathVariable Long id) {
        System.out.println("Teest");
        return ResponseEntity.ok().body(DtoFactory.fromActivity(service.getActivityById(id)));
    }

    //Virker - IK SLET ENDPOINT
    @GetMapping("/get-by-name/{name}")
    public ResponseEntity<ActivityDto> getActivityByName(@PathVariable String name) {
        return ResponseEntity.ok().body(DtoFactory.fromActivity(service.getActivityByName(name)));
    }

  /*  @DeleteMapping("/delete/{id}")
    public ResponseEntity<Activity> delete(@PathVariable("id") Long id) {
        service.find(id).orElseThrow(() -> new RuntimeException("Activity not found.".formatted(id)));

        //Activity delete = service.deleteActivity(id);
        return ResponseEntity.ok().body(delete);
    }*/


    //Virker ikke fordi booking er afhængig af en activity
    //hvis du fjerner activity 1 som en booking er afhængig af så får man fejl

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        System.out.println(service.deleteActivity(id) + "deleeee");
        return service.deleteActivity(id);
    }

    //Ikke testet
    @PutMapping("/update")
    public Activity UpdateActivity(@RequestBody Activity activity) {
        return service.updateActivity(activity);
    }


}

package com.example.adventure;

import com.example.adventure.activity.Activity;
import com.example.adventure.activity.ActivityRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@SpringBootApplication
public class AdventureApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdventureApplication.class, args);
	}

	@Bean
	public CommandLineRunner importData(ActivityRepository activityRepository) {

		return (args) -> {
			log.info("Starting convertion");
			List<Activity> activities = new ArrayList<>();
			activities.add(new Activity(20.0,"Test1", 12, "DescTEST" ));
			activities.add(new Activity(40.0,"Test2", 13, "DescTEST1" ));
			activities.add(new Activity(30.0,"Test3", 14, "DescTEST2" ));
			activities.add(new Activity(10.0,"Test4", 15, "DescTEST3" ));
			activityRepository.saveAll(activities);
			log.info("Activities added");
		};
}
}

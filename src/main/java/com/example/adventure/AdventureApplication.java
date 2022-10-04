package com.example.adventure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import com.example.adventure.Customer.Model.Customer;
import com.example.adventure.Customer.Repository.CustomerRepo;
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

/*    @Bean
    public CommandLineRunner importData(ActivityRepository activityRepository) {

        return (args) -> {
            log.info("Starting convertion");
            List<Activity> activities = new ArrayList<>();
            activities.add(new Activity(20.0, "Test1", 12, "DescTEST"));
            activities.add(new Activity(40.0, "Test2", 13, "DescTEST1"));
            activities.add(new Activity(30.0, "Test3", 14, "DescTEST2"));
            activities.add(new Activity(10.0, "Test4", 15, "DescTEST3"));
            activityRepository.saveAll(activities);
            log.info("Activities added");
        };
    }*/

    @Bean
    public CommandLineRunner importData(CustomerRepo employeeRepository) {
        return (args) -> {

            final List<Customer> employees = new ArrayList<>();
            employees.add(new Customer("Mo", "Stacks", "mo@mo.dk", "222"));
            employees.add(new Customer("Bo", "Bosen", "bo@bo.dk", "222"));
            employees.add(new Customer("Bobo", "Bobosen", "bobo@bobo.dk", "222"));
            employeeRepository.saveAll(employees);

            //log.info("Data import done.");

        };
    }
}

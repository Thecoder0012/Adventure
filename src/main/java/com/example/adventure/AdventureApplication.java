package com.example.adventure;

import com.example.adventure.activity.model.Activity;
import com.example.adventure.activity.repository.ActivityRepository;
import com.example.adventure.booking.model.Booking;
import com.example.adventure.booking.repository.BookingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import com.example.adventure.customer.model.Customer;
import com.example.adventure.customer.repository.CustomerRepo;
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
    public CommandLineRunner importData(CustomerRepo employeeRepository,
                                        ActivityRepository activityRepository,
                                        BookingRepository bookingRepository) {
        return (args) -> {

            final List<Customer> employees = new ArrayList<>();
            employees.add(new Customer("Mo", "Stacks", "mo@mo.dk", "222"));
            employees.add(new Customer("Bo", "Bosen", "bo@bo.dk", "222"));
            employees.add(new Customer("Bobo", "Bobosen", "bobo@bobo.dk", "222"));
            employeeRepository.saveAll(employees);
            log.info("Employees added");

            log.info("Starting convertion");
            List<Activity> activities = new ArrayList<>();
            activities.add(new Activity(20.0, "Test1", 12, "DescTEST"));
            activities.add(new Activity(40.0, "Test2", 13, "DescTEST1"));
            activities.add(new Activity(30.0, "Test3", 14, "DescTEST2"));
            activities.add(new Activity(10.0, "Test4", 15, "DescTEST3"));
            activityRepository.saveAll(activities);
            log.info("Activities added");




           final List<Booking> bookings = new ArrayList<>();
            bookings.add(new Booking("Booking 1"));
            bookings.add(new Booking("Booking 2"));
            bookings.add(new Booking("Booking 3"));
            bookings.add(new Booking("Booking 4"));
            bookings.get(0).setActivity(activities.get(0));
            bookings.get(0).setCustomer(employees.get(2));
            bookings.get(1).setCustomer(employees.get(2));
            bookingRepository.saveAll(bookings);
            log.info("Bookings added");


            log.info("Data import done.");


        };
    }
}

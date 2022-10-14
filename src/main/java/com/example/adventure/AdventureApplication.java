package com.example.adventure;

import com.example.adventure.activity.model.Activity;
import com.example.adventure.activity.repository.ActivityRepository;
import com.example.adventure.activity.service.ActivityService;
import com.example.adventure.booking.model.Booking;
import com.example.adventure.booking.repository.BookingRepository;
import com.example.adventure.booking.service.BookingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import com.example.adventure.customer.model.Customer;
import com.example.adventure.customer.repository.CustomerRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Slf4j
@AllArgsConstructor
@SpringBootApplication
public class AdventureApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdventureApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepo customerRepo,
                                        ActivityRepository activityRepository,
                                        BookingRepository bookingRepository) {
        return (args) -> {

            final List<Customer> employees = new ArrayList<>();
            employees.add(new Customer("Kasper", "Jensen", "test@test.dk", "+4512345678"));
            employees.add(new Customer("Mo", "Stacks", "test@test.dk", "+4512345678"));
            employees.add(new Customer("Lars", "Samuelsen", "test@test.dk", "+4512345678"));
            employees.add(new Customer("Jens", "Petersen", "test@test.dk", "+4512345678"));
            customerRepo.saveAll(employees);
            log.info("Employees added");

            log.info("Starting convertion");
            List<Activity> activities = new ArrayList<>();
            activities.add(new Activity(20.0, "Gocart", 12, "Gokart"));
            activities.add(new Activity(40.0, "Minigolf", 13, "Indendørs minigolf"));
            activities.add(new Activity(30.0, "Paintball", 14, "Paintball"));
            activities.add(new Activity(10.0, "Sumo-Wrestling", 15, "Sumo-wrestling"));
            activityRepository.saveAll(activities);
            log.info("Activities added");


            List<Booking> bookings = new ArrayList<>();
            bookings.add(new Booking(LocalDate.of(2020, 5, 5), LocalTime.of(12,0), LocalTime.of(16, 0),
                    activities.get(0), employees.get(0)));
            bookings.add(new Booking(LocalDate.of(2021, 3, 18), LocalTime.of(15,0), LocalTime.of(2, 0),
                    activities.get(1), employees.get(1)));
            bookings.add(new Booking(LocalDate.of(2021, 3, 18), LocalTime.of(15,0), LocalTime.of(2, 0),
                    activities.get(2), employees.get(2)));
            bookingRepository.saveAll(bookings);

            log.info("Data sent to database");
            log.warn("This is only for testing");

        };
    }
}

package com.example.adventure.admin.controller;

import com.example.adventure.booking.model.Booking;
import com.example.adventure.booking.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/admin")
@CrossOrigin
public class AdminController {

    private final BookingService bookingService;

    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> fetchAll(){
        return ResponseEntity.ok().body(bookingService.getAll());
    }



}


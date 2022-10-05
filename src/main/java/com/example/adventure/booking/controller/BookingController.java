package com.example.adventure.booking.controller;

import com.example.adventure.booking.service.BookingService;
import com.example.adventure.booking.model.Booking;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/booking")
public class BookingController {

    private final BookingService service;

    @GetMapping
    public List<Booking> getAll(){
        return service.getAll();
    }

    @PostMapping
    public Booking addBooking(@RequestBody Booking booking){
        return service.saveBooking(booking);
    }

    @GetMapping("/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return service.getBookingById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteBooking(@PathVariable Long id){
        return service.deleteBooking(id);
    }
    @PutMapping("/update/{id}")
    public Booking updateBooking(@PathVariable("id") Long id, @RequestBody Booking booking){
        return service.updateBooking(id, booking);
    }

}

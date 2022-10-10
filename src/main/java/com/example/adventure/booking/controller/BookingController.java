package com.example.adventure.booking.controller;

import com.example.adventure.activity.model.Activity;
import com.example.adventure.booking.service.BookingService;
import com.example.adventure.booking.model.Booking;
import com.example.adventure.dtotest.ActivityDto;
import com.example.adventure.dtotest.BookingDto;
import com.example.adventure.dtotest.DtoFactory;
import lombok.AllArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api/v1/booking")
public class BookingController {

    private final BookingService service;

    @GetMapping()
    public ResponseEntity<List<BookingDto>> getAll() {
        return ResponseEntity.ok().body(DtoFactory.fromBookings(service.getAll()));
    }

    @PostMapping("/add")
    public Booking addBooking(@RequestBody Booking booking) {
        return service.saveBooking(booking);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<BookingDto> getActivityById(@PathVariable Long id) {
        return ResponseEntity.ok().body(DtoFactory.fromBooking(service.getBookingById(id)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Booking> deleteBooking(@PathVariable("id") Long id) {
        if (id != null) {
            return ResponseEntity.ok().body(service.deleteBooking(id));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookingDto> put(@PathVariable("id") Long id, @Valid @RequestBody BookingDto dto) {
        return ResponseEntity.ok().body(update(id, dto));
    }

    private BookingDto update(Long id, BookingDto dto) {
        Optional<Booking> item = service.update(id, DtoFactory.fromBookingDto(dto));
        if (!item.isPresent()) {
            throw new ResourceNotFoundException("Booking %d not found".formatted(id));
        }
        return DtoFactory.fromBooking(item.get());
    }
}
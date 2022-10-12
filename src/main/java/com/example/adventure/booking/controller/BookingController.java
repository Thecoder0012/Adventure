package com.example.adventure.booking.controller;

import com.example.adventure.activity.service.ActivityService;
import com.example.adventure.booking.service.BookingService;
import com.example.adventure.booking.model.Booking;
import com.example.adventure.customer.service.CustomerService;
import com.example.adventure.dtotest.BookingDto;
import com.example.adventure.dtotest.DtoFactory;
import lombok.AllArgsConstructor;
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

    private final BookingService bookingService;
    private final ActivityService activityService;
    private final CustomerService customerService;


    @GetMapping()
    public ResponseEntity<List<BookingDto>> getAll() {
        return ResponseEntity.ok().body(DtoFactory.fromBookings(bookingService.getAll()));
    }
// comment
    @PostMapping("/add")
    public BookingDto addBooking(@RequestBody Booking booking) {
        activityService.addActivity(booking.getActivity());
        customerService.addCustomer(booking.getCustomer());

        return DtoFactory.fromBooking(bookingService.saveBooking(booking));
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
        Optional<Booking> item = bookingService.update(id, DtoFactory.fromBookingDto(dto));
        return DtoFactory.fromBooking(item.get());
    }
}
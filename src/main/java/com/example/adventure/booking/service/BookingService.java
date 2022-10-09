package com.example.adventure.booking.service;

import com.example.adventure.booking.model.Booking;
import com.example.adventure.booking.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {

    private final BookingRepository repository;

    public List<Booking> getAll(){
        return repository.findAll();
    }

    public Booking saveBooking(Booking booking){
        return repository.save(booking);
    }

    public Booking getBookingById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Booking deleteBooking(Long id){
        repository.deleteById(id);
        return null;
    }

    public Booking updateBooking(Long id, Booking booking){
        Booking bookingRequest = repository.findById(id).orElse(null);
        bookingRequest.setLocalDate(booking.getLocalDate());
        bookingRequest.setTimeStart(booking.getTimeStart());
        bookingRequest.setTimeEnd(booking.getTimeEnd());
        bookingRequest.setActivity(booking.getActivity());
        bookingRequest.setCustomer(booking.getCustomer());
        return repository.save(bookingRequest);
    }



}

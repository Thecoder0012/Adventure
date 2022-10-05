package com.example.adventure.booking;

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

    public String deleteBooking(Long id){
        repository.deleteById(id);
        return "Booking removed - ID : " + id;
    }

    public Booking updateBooking(Long id, Booking booking){
        Booking bookingRequest = repository.findById(id).orElse(null);
        bookingRequest.setName(booking.getName());
        bookingRequest.setActivity(booking.getActivity());
        bookingRequest.setCustomer(booking.getCustomer());
        return repository.save(bookingRequest);
    }



}

package com.example.adventure.dtotest;

import com.example.adventure.activity.model.Activity;
import com.example.adventure.booking.model.Booking;
import com.example.adventure.customer.model.Customer;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class DtoFactory {


    // For Activity
    public static ActivityDto fromActivity(Activity activity) {
        ActivityDto dto = new ActivityDto();
        dto.setId(activity.getId());
        dto.setHourPrice(activity.getHourPrice());
        dto.setName(activity.getName());
        dto.setMinAge(activity.getMinAge());
        dto.setDescription(activity.getDescription());
        return dto;
    }

    public static List<ActivityDto> fromActivities(List<Activity> activities) {
        return activities.stream().map(obj -> fromActivity(obj))
                .collect(Collectors.toList());
    }

    public static BookingDto fromBooking(Booking booking) {
        BookingDto dto = new BookingDto();
        dto.setId(booking.getId());
        dto.setLocalDate(booking.getLocalDate());
        dto.setTimeEnd(booking.getTimeEnd());
        dto.setTimeStart(booking.getTimeStart());
        dto.setCustomer(booking.getCustomer());
        dto.setActivity(booking.getActivity());
        return dto;
    }

    public static List<BookingDto> fromBookings(List<Booking> bookings) {
        return bookings.stream().map(obj -> fromBooking(obj))
                .collect(Collectors.toList());
    }

    }




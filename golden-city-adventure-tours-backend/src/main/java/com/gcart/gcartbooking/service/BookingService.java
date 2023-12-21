package com.gcart.gcartbooking.service;

import com.gcart.gcartbooking.entity.Booking;

import java.util.List;

public interface BookingService {

    Booking saveBooking(Booking booking);

    List<Booking> getAllBookings();

    Booking getBookingById(Long bookingId);

    // Add other service methods as needed
}

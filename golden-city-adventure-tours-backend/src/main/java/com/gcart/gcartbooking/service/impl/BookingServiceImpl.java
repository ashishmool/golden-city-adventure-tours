package com.gcart.gcartbooking.service.impl;

import com.gcart.gcartbooking.entity.Booking;
import com.gcart.gcartbooking.repository.BookingRepo;
import com.gcart.gcartbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepo bookingRepository;

    @Override
    public Booking saveBooking(Booking booking) {
        // Implement save logic
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        // Implement getAll logic
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long bookingId) {
        // Implement getById logic
        return bookingRepository.findById(bookingId).orElse(null);
    }

    // Add other service methods as needed
}

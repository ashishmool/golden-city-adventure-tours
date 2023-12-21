package com.gcart.gcartbooking.controller;

import com.gcart.gcartbooking.entity.Booking;
import com.gcart.gcartbooking.pojo.BookingPojo;
import com.gcart.gcartbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/save")
    public ResponseEntity<Booking> saveBooking(@RequestBody BookingPojo bookingPojo) {
        // Convert BookingPojo to Booking entity
        Booking booking = convertToBookingEntity(bookingPojo);

        // Calculate derived attributes
        // (Note: In a real application, you might want to move this logic to a service or helper class)
        booking.setTotalTourPrice(booking.getTour().getPricePerPerson().multiply(BigDecimal.valueOf(booking.getNumberOfPersons())));
        booking.setTotalBikePrice((booking.getBike() != null) ? booking.getBike().getPricePerDay().multiply(BigDecimal.valueOf(booking.getNoOfDaysBike())) : BigDecimal.ZERO);
        booking.setTotalAmount(booking.getTotalTourPrice().add(booking.getTotalBikePrice()));
        booking.setTripDays(booking.getTour().getEndDate().compareTo(booking.getTour().getStartDate()));

        // Save the booking
        Booking savedBooking = bookingService.saveBooking(booking);

        return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
    }



    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{bookingId}")
    public Booking getBookingById(@PathVariable Long bookingId) {
        return bookingService.getBookingById(bookingId);
    }
    private Booking convertToBookingEntity(BookingPojo bookingPojo) {
        // Implement conversion logic
        // ...
        return null;
    }
    // Add other endpoints for search functionalities and derived attributes as needed
}

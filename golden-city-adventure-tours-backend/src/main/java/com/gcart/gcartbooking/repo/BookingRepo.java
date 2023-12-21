package com.gcart.gcartbooking.repository;

import com.gcart.gcartbooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking, Long> {
    // Add custom query methods if needed
}

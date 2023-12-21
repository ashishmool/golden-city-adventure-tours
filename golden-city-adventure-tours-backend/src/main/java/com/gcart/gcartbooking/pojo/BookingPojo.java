package com.gcart.gcartbooking.pojo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BookingPojo {

    // Fields from Booking entity
    private Long bookingId;
    private Long userId;
    private Long tourId;
    private int numberOfPersons;
    private BigDecimal totalTourPrice;
    private Long bikeId;
    private int noOfDaysBike;
    private BigDecimal totalBikePrice;
    private BigDecimal totalAmount;
    private int tripDays;
    private String paymentStatus;
    private String paymentMode;

    // Add constructor, getters, and setters as needed
}

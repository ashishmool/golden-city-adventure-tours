package com.gcart.gcartbooking.entity;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Long bookingId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "tour_id", nullable = false)
    private Tour tour;

    @Column(name = "number_of_persons")
    private int numberOfPersons;

    @Column(name = "total_tour_price")
    private BigDecimal totalTourPrice;

    @ManyToOne
    @JoinColumn(name = "bike_id")
    private Bike bike;

    @Column(name = "no_of_days_bike")
    private int noOfDaysBike;

    @Column(name = "total_bike_price")
    private BigDecimal totalBikePrice;

    @Column(name = "total_amount")
    private BigDecimal totalAmount;

    @Column(name = "trip_days")
    private int tripDays;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "payment_mode")
    private String paymentMode;

    // Constructor
    public Booking() {
        // Default constructor
    }

    // Additional constructor for creating a booking with necessary details
    public Booking(User user, Tour tour, int numberOfPersons, Bike bike, int noOfDaysBike,
                   String paymentStatus, String paymentMode) {
        this.user = user;
        this.tour = tour;
        this.numberOfPersons = numberOfPersons;
        this.bike = bike;
        this.noOfDaysBike = noOfDaysBike;
        this.paymentStatus = paymentStatus;
        this.paymentMode = paymentMode;

        // Calculate derived attributes
        this.totalTourPrice = tour.getPricePerPerson().multiply(BigDecimal.valueOf(numberOfPersons));
        this.totalBikePrice = (bike != null) ? bike.getPricePerDay().multiply(BigDecimal.valueOf(noOfDaysBike)) : BigDecimal.ZERO;
        this.totalAmount = totalTourPrice.add(totalBikePrice);
        this.tripDays = tour.getEndDate().compareTo(tour.getStartDate());
    }

    // Getters and setters
}

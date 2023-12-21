package com.gcart.gcartbooking.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "bikes")
@Getter
@Setter
public class Bike {

    @Id
    @GeneratedValue(generator = "bikes_seq_gen", strategy = GenerationType.SEQUENCE)
    private Long bikeId;

    @Column(name = "bike_name", nullable = false)
    private String bikeName;

    @Column(name = "bike_model", nullable = false)
    private String bikeModel;

    @Column(name = "year", nullable = false)
    private int year;

    @Column(name = "bike_registration_number", nullable = false)
    private String bikeRegistrationNumber;

    @Column(name = "price_per_day", nullable = false)
    private BigDecimal pricePerDay;

    @Column(name = "bike_photo")
    private String bikePhoto;
}

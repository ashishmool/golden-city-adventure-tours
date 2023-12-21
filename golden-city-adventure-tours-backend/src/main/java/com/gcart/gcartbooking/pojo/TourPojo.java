package com.gcart.gcartbooking.pojo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class TourPojo {

    private Long tourId;
    private String tourName;
    private String difficulty;
    private String location;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal pricePerPerson;
    private int maxPersonNo;
    private String availabilityStatus;
}

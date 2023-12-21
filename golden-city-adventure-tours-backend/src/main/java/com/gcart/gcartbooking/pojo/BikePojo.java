package com.gcart.gcartbooking.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BikePojo {

    private Long bikeId;

    private String bikeName;

    private String bikeModel;

    private int year;

    private String bikeRegistrationNumber;

    private BigDecimal pricePerDay;

    private String bikePhoto;
}

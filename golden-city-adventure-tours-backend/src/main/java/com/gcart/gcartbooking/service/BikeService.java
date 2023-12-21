package com.gcart.gcartbooking.service;

import com.gcart.gcartbooking.entity.Bike;
import com.gcart.gcartbooking.pojo.BikePojo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface BikeService {

    String save(BikePojo bikePojo);

    List<Bike> getAll();

    void deleteById(Long id);

    Optional<Bike> getById(Long id);

    String update(Long id, BikePojo bikePojo);

    List<Bike> search(String bikeModel, int year, String bikeName, String bikeRegistrationNumber, BigDecimal price);
}

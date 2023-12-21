package com.gcart.gcartbooking.service;

import com.gcart.gcartbooking.entity.Tour;
import com.gcart.gcartbooking.pojo.TourPojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TourService {

    String save(TourPojo tourPojo);

    List<Tour> getAll();

    void deleteById(Long id);

    Optional<Tour> getById(Long id);

    String update(Long id, TourPojo tourPojo);

    List<Tour> getByStartDate(LocalDate startDate);

    List<Tour> getByPriceRange(BigDecimal minPrice, BigDecimal maxPrice);

    List<Tour> getByDifficulty(String difficulty);

    List<Tour> getByLocation(String location);

    List<Tour> getByTourName(String tourName);

    List<Tour> search(String difficulty, String location, String tourName, LocalDate startDate, BigDecimal minPrice, BigDecimal maxPrice);
}

package com.gcart.gcartbooking.service.impl;

import com.gcart.gcartbooking.entity.Tour;
import com.gcart.gcartbooking.pojo.TourPojo;
import com.gcart.gcartbooking.repo.TourRepo;
import com.gcart.gcartbooking.service.TourService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService {

    private final TourRepo tourRepo;

    @Override
    public String save(TourPojo tourPojo) {
        Tour tour;

        if (tourPojo.getTourId() != null) {
            tour = tourRepo.findById(tourPojo.getTourId())
                    .orElseThrow(() -> new EntityNotFoundException("Tour not found with ID: " + tourPojo.getTourId()));
        } else {
            tour = new Tour();
        }

        // Set values from TourPojo to Tour entity
        tour.setTourName(tourPojo.getTourName());
        tour.setDifficulty(tourPojo.getDifficulty());
        tour.setLocation(tourPojo.getLocation());
        tour.setDescription(tourPojo.getDescription());
        tour.setStartDate(tourPojo.getStartDate());
        tour.setEndDate(tourPojo.getEndDate());
        tour.setPricePerPerson(tourPojo.getPricePerPerson());
        tour.setMaxPersonNo(tourPojo.getMaxPersonNo());
        tour.setAvailabilityStatus(tourPojo.getAvailabilityStatus());

        tourRepo.save(tour);
        return "Saved Successfully!";
    }

    @Override
    public List<Tour> getAll() {
        return tourRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        tourRepo.deleteById(id);
    }

    @Override
    public Optional<Tour> getById(Long id) {
        return tourRepo.findById(id);
    }

    @Override
    public String update(Long id, TourPojo tourPojo) {
        Tour tour = tourRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tour not found with ID: " + id));

        // Set values from TourPojo to Tour entity for update
        tour.setTourName(tourPojo.getTourName());
        tour.setDifficulty(tourPojo.getDifficulty());
        tour.setLocation(tourPojo.getLocation());
        tour.setDescription(tourPojo.getDescription());
        tour.setStartDate(tourPojo.getStartDate());
        tour.setEndDate(tourPojo.getEndDate());
        tour.setPricePerPerson(tourPojo.getPricePerPerson());
        tour.setMaxPersonNo(tourPojo.getMaxPersonNo());
        tour.setAvailabilityStatus(tourPojo.getAvailabilityStatus());

        tourRepo.save(tour);
        return "Updated Successfully!";
    }

    @Override
    public List<Tour> getByStartDate(LocalDate startDate) {
        return tourRepo.findByStartDate(startDate);
    }

    @Override
    public List<Tour> getByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return tourRepo.findByPricePerPersonBetween(minPrice, maxPrice);
    }

    @Override
    public List<Tour> getByDifficulty(String difficulty) {
        return tourRepo.findByDifficulty(difficulty);
    }

    @Override
    public List<Tour> getByLocation(String location) {
        return tourRepo.findByLocation(location);
    }

    @Override
    public List<Tour> getByTourName(String tourName) {
        return tourRepo.findByTourName(tourName);
    }

    @Override
    public List<Tour> search(String difficulty, String location, String tourName, LocalDate startDate, BigDecimal minPrice, BigDecimal maxPrice) {
        // Implement search logic based on the provided parameters
        // This could include using the tourRepo to query the database
        // and return a list of matching tours.
        // The exact implementation will depend on your specific requirements.
        return tourRepo.search(difficulty, location, tourName, startDate, minPrice, maxPrice);
    }

    // Add other methods for search functionality as needed
}

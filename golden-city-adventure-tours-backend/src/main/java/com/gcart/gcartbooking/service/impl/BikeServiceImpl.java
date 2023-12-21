package com.gcart.gcartbooking.service.impl;

import com.gcart.gcartbooking.entity.Bike;
import com.gcart.gcartbooking.pojo.BikePojo;
import com.gcart.gcartbooking.repo.BikeRepo;
import com.gcart.gcartbooking.service.BikeService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BikeServiceImpl implements BikeService {

    private final BikeRepo bikeRepo;

    @Override
    public String save(BikePojo bikePojo) {
        Bike bike;

        if (bikePojo.getBikeId() != null) {
            bike = bikeRepo.findById(bikePojo.getBikeId())
                    .orElseThrow(() -> new EntityNotFoundException("Bike not found with ID: " + bikePojo.getBikeId()));
        } else {
            bike = new Bike();
        }

        // Set values from BikePojo to Bike entity
        bike.setBikeName(bikePojo.getBikeName());
        bike.setBikeModel(bikePojo.getBikeModel());
        bike.setYear(bikePojo.getYear());
        bike.setBikeRegistrationNumber(bikePojo.getBikeRegistrationNumber());
        bike.setPricePerDay(bikePojo.getPricePerDay());
        bike.setBikePhoto(bikePojo.getBikePhoto());

        bikeRepo.save(bike);
        return "Saved Successfully!";
    }

    @Override
    public List<Bike> getAll() {
        return bikeRepo.findAll();
    }

    @Override
    public void deleteById(Long id) {
        bikeRepo.deleteById(id);
    }

    @Override
    public Optional<Bike> getById(Long id) {
        return bikeRepo.findById(id);
    }

    @Override
    public String update(Long id, BikePojo bikePojo) {
        Bike bike = bikeRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bike not found with ID: " + id));

        // Set values from BikePojo to Bike entity for update
        bike.setBikeName(bikePojo.getBikeName());
        bike.setBikeModel(bikePojo.getBikeModel());
        bike.setYear(bikePojo.getYear());
        bike.setBikeRegistrationNumber(bikePojo.getBikeRegistrationNumber());
        bike.setPricePerDay(bikePojo.getPricePerDay());
        bike.setBikePhoto(bikePojo.getBikePhoto());

        bikeRepo.save(bike);
        return "Updated Successfully!";
    }

    @Override
    public List<Bike> search(String bikeModel, int year, String bikeName, String bikeRegistrationNumber, BigDecimal price) {
        // Implement search logic based on the provided parameters
        // This could include using the bikeRepo to query the database
        // and return a list of matching bikes.
        // The exact implementation will depend on your specific requirements.
        return null;
    }
}

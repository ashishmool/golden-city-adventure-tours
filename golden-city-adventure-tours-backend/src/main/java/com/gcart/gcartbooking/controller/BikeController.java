package com.gcart.gcartbooking.controller;

import com.gcart.gcartbooking.entity.Bike;
import com.gcart.gcartbooking.service.BikeService;
import com.gcart.gcartbooking.pojo.BikePojo;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bikes")
@RequiredArgsConstructor
public class BikeController {

    private final BikeService bikeService;

    @PostMapping(value = "/save")
    public String saveBike(@Valid @RequestBody BikePojo bikePojo) {
        bikeService.save(bikePojo);
        return "Saved Successfully!";
    }

    @GetMapping("/getAll")
    public List<Bike> getAll() {
        return bikeService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<Bike> getById(@PathVariable("id") Long id) {
        return bikeService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        bikeService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public String updateBike(@PathVariable("id") Long id, @Valid @RequestBody BikePojo bikePojo) {
        return bikeService.update(id, bikePojo);
    }

    @GetMapping("/search")
    public List<Bike> searchBike(
            @RequestParam(required = false) String bikeModel,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) String bikeName,
            @RequestParam(required = false) String bikeRegistrationNumber,
            @RequestParam(required = false) BigDecimal price) {
        return bikeService.search(bikeModel, year, bikeName, bikeRegistrationNumber, price);
    }
}

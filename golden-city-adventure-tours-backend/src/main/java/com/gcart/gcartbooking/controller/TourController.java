package com.gcart.gcartbooking.controller;

import com.gcart.gcartbooking.entity.Tour;
import com.gcart.gcartbooking.service.TourService;
import com.gcart.gcartbooking.pojo.TourPojo;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tours")
@RequiredArgsConstructor
public class TourController {

    private final TourService tourService;

    @PostMapping(value = "/save")
    public String saveTour(@Valid @RequestBody TourPojo tourPojo) {
        tourService.save(tourPojo);
        return "Saved Successfully!";
    }

    @GetMapping("/getAll")
    public List<Tour> getAll() {
        return tourService.getAll();
    }

    @GetMapping("/getById/{id}")
    public Optional<Tour> getById(@PathVariable("id") Long id) {
        return tourService.getById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        tourService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public String updateTour(@PathVariable("id") Long id, @Valid @RequestBody TourPojo tourPojo) {
        return tourService.update(id, tourPojo);
    }

    @GetMapping("/getByStartDate/{startDate}")
    public List<Tour> getByStartDate(@PathVariable("startDate") String startDate) {
        return tourService.getByStartDate(LocalDate.parse(startDate));
    }

    @GetMapping("/getByPriceRange/{minPrice}/{maxPrice}")
    public List<Tour> getByPriceRange(@PathVariable("minPrice") BigDecimal minPrice, @PathVariable("maxPrice") BigDecimal maxPrice) {
        return tourService.getByPriceRange(minPrice, maxPrice);
    }

    @GetMapping("/getByDifficulty/{difficulty}")
    public List<Tour> getByDifficulty(@PathVariable("difficulty") String difficulty) {
        return tourService.getByDifficulty(difficulty);
    }

    @GetMapping("/getByLocation/{location}")
    public List<Tour> getByLocation(@PathVariable("location") String location) {
        return tourService.getByLocation(location);
    }

    @GetMapping("/getByTourName/{tourName}")
    public List<Tour> getByTourName(@PathVariable("tourName") String tourName) {
        return tourService.getByTourName(tourName);
    }

    @GetMapping("/search")
    public List<Tour> searchTours(
            @RequestParam(required = false) String difficulty,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String tourName,
            @RequestParam(required = false) String startDate,
            @RequestParam(required = false) BigDecimal minPrice,
            @RequestParam(required = false) BigDecimal maxPrice) {
        return tourService.search(difficulty, location, tourName, startDate != null ? LocalDate.parse(startDate) : null, minPrice, maxPrice);
    }
}

package com.gcart.gcartbooking.repo;

import com.gcart.gcartbooking.entity.Tour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface TourRepo extends JpaRepository<Tour, Long> {

    List<Tour> findByStartDate(LocalDate startDate);

    List<Tour> findByPricePerPersonBetween(BigDecimal minPrice, BigDecimal maxPrice);

    List<Tour> findByDifficulty(String difficulty);

    List<Tour> findByLocation(String location);

    List<Tour> findByTourName(String tourName);

    @Query("SELECT t FROM Tour t WHERE " +
            "(:difficulty IS NULL OR t.difficulty = :difficulty) AND " +
            "(:location IS NULL OR t.location = :location) AND " +
            "(:tourName IS NULL OR t.tourName = :tourName) AND " +
            "(:startDate IS NULL OR t.startDate = :startDate) AND " +
            "(:minPrice IS NULL OR t.pricePerPerson >= :minPrice) AND " +
            "(:maxPrice IS NULL OR t.pricePerPerson <= :maxPrice)")
    List<Tour> search(String difficulty, String location, String tourName, LocalDate startDate, BigDecimal minPrice, BigDecimal maxPrice);
}

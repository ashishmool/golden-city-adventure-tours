package com.gcart.gcartbooking.repo;

import com.gcart.gcartbooking.entity.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepo extends JpaRepository<Bike, Long> {
}

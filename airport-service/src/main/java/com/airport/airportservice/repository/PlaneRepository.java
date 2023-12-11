package com.airport.airportservice.repository;

import com.airport.airportservice.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaneRepository extends JpaRepository<Plane, Long> {
}

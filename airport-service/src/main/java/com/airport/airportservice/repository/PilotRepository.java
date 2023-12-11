package com.airport.airportservice.repository;

import com.airport.airportservice.entity.Pilot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PilotRepository extends JpaRepository<Pilot, Long> {
}

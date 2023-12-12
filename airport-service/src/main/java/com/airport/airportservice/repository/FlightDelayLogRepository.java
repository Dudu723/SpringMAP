package com.airport.airportservice.repository;

import com.airport.airportservice.entity.FlightDelayLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightDelayLogRepository extends JpaRepository<FlightDelayLog, Long> {
}

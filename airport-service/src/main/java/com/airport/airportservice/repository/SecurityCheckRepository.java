package com.airport.airportservice.repository;

import com.airport.airportservice.entity.SecurityCheck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SecurityCheckRepository extends JpaRepository<SecurityCheck, Long> {
}

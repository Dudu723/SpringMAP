package com.airport.airportservice.repository;

import com.airport.airportservice.entity.AirlineCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineCompanyRepository extends JpaRepository<AirlineCompany, Long> {
}

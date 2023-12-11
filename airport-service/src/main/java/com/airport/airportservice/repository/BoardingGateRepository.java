package com.airport.airportservice.repository;

import com.airport.airportservice.entity.BoardingGate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardingGateRepository extends JpaRepository<BoardingGate, Long> {
}

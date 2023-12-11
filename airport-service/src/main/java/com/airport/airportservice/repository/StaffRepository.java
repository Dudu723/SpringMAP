package com.airport.airportservice.repository;

import com.airport.airportservice.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}

package com.airport.airportservice.controller;

import com.airport.airportservice.entity.Flight;
import com.airport.airportservice.repository.FlightRepository;
import org.aspectj.apache.bcel.classfile.Module;

import java.util.List;
import java.util.Optional;

public interface FlightController {
    List<Flight> getAllFlights();
    Flight addFlight(Flight flight);
    Optional<Flight> getFlight(Long id);
    void deleteFlightById(Long id);

}

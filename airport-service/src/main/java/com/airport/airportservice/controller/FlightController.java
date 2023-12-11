package com.airport.airportservice.controller;

import com.airport.airportservice.entity.Flight;
import com.airport.airportservice.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightController(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        return flightRepository.save(flight);
    }

    @GetMapping("/{id}")
    public Optional<Flight> getFlight(@PathVariable Long id) {
        return flightRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFlightById(@PathVariable Long id) {
        flightRepository.deleteById(id);
    }
}

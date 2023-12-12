package com.airport.airportservice.controller;

import com.airport.airportservice.entity.Flight;

import java.util.List;
import java.util.Optional;

public class FlightControllerProxy implements FlightController{

    private final FlightController realFlightController;
    private final String username;

    public FlightControllerProxy(FlightController realFlightController, String username) {
        this.realFlightController = realFlightController;
        this.username = username;
    }

    @Override
    public List<Flight> getAllFlights() {
        return realFlightController.getAllFlights();
    }

    @Override
    public Flight addFlight(Flight flight) {
        return realFlightController.addFlight(flight);
    }

    @Override
    public Optional<Flight> getFlight(Long id) {
        return realFlightController.getFlight(id);
    }

    @Override
    public void deleteFlightById(Long id) {
        if ("admin".equals(username)) {
            realFlightController.deleteFlightById(id);
            System.out.println("Flight deleted successfully!");
        } else {
            System.out.println("Permission denied. Only admin can delete flights.");
        }
    }
}

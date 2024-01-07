package com.airport.airportservice.controller;

import com.airport.airportservice.entity.Passenger;
import com.airport.airportservice.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {
    private final PassengerService passengerService;

    @Autowired
    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping
    public List<Passenger> getAllPassengers(){
        return passengerService.getAllPassengers();
    }

    @PostMapping
    public Passenger addPassanger(@RequestBody Passenger passenger){
        return passengerService.addPassanger(passenger);
    }

    @GetMapping("/{id}")
    public Optional<Passenger> getPassengerById(@PathVariable Long id){
        return passengerService.getPassengerById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePassengerById(@PathVariable Long id){
        passengerService.deletePassengerById(id);
    }
}

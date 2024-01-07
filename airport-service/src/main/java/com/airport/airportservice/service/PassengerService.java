package com.airport.airportservice.service;

import com.airport.airportservice.entity.Passenger;
import com.airport.airportservice.repository.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public List<Passenger> getAllPassengers(){
        return passengerRepository.findAll();
    }

    public Passenger addPassanger(Passenger passenger){
        return passengerRepository.save(passenger);
    }

    public Optional<Passenger> getPassengerById(Long id){
        return passengerRepository.findById(id);
    }

    public void deletePassengerById(Long id){
        passengerRepository.deleteById(id);
    }
}

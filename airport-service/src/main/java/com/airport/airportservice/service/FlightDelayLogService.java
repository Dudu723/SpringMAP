package com.airport.airportservice.service;

import com.airport.airportservice.entity.FlightDelayLog;
import com.airport.airportservice.repository.FlightDelayLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightDelayLogService {
    private final FlightDelayLogRepository flightDelayLogRepository;

    @Autowired
    public FlightDelayLogService(FlightDelayLogRepository flightDelayLogRepository) {
        this.flightDelayLogRepository = flightDelayLogRepository;
    }

    public List<FlightDelayLog> getAllFlightDelays(){
        return flightDelayLogRepository.findAll();
    }

    public FlightDelayLog addFlightDelay(FlightDelayLog flightDelayLog){
        return flightDelayLogRepository.save(flightDelayLog);
    }

    public Optional<FlightDelayLog> getFlightDelayById(Long id){
        return flightDelayLogRepository.findById(id);
    }

    public void deleteFlightDelayLog(Long id){
        flightDelayLogRepository.deleteById(id);
    }
}

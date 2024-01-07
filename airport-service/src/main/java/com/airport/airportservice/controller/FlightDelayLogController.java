package com.airport.airportservice.controller;

import com.airport.airportservice.entity.FlightDelayLog;
import com.airport.airportservice.service.FlightDelayLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/flight delay logs")
public class FlightDelayLogController {
    private final FlightDelayLogService flightDelayLogService;

    @Autowired
    public FlightDelayLogController(FlightDelayLogService flightDelayLogService) {
        this.flightDelayLogService = flightDelayLogService;
    }

    @GetMapping
    public List<FlightDelayLog> getAllFlightDelays(){
        return flightDelayLogService.getAllFlightDelays();
    }

    @PostMapping
    public FlightDelayLog addFlightDelay(@RequestBody FlightDelayLog flightDelayLog){
        return flightDelayLogService.addFlightDelay(flightDelayLog);
    }

    @GetMapping("/{id}")
    public Optional<FlightDelayLog> getFlightDelayById(@PathVariable Long id){
        return flightDelayLogService.getFlightDelayById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteFlightDelayLog(@PathVariable Long id){
        flightDelayLogService.deleteFlightDelayLog(id);
    }

}

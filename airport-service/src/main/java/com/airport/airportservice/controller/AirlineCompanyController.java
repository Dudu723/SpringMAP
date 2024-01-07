package com.airport.airportservice.controller;

import com.airport.airportservice.entity.AirlineCompany;
import com.airport.airportservice.service.AirlineCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/airline companies")
public class AirlineCompanyController {
    private final AirlineCompanyService airlineCompanyService;

    @Autowired
    public AirlineCompanyController(AirlineCompanyService airlineCompanyService){
        this.airlineCompanyService = airlineCompanyService;
    }

    @GetMapping
    public List<AirlineCompany> getAllAirlines(){
        return airlineCompanyService.getAllAirlines();
    }

    @PostMapping
    public AirlineCompany addAirlineCompany(@RequestBody AirlineCompany airlineCompany){
        return airlineCompanyService.addAirlineCompany(airlineCompany);
    }

    @GetMapping("/{id}")
    public Optional<AirlineCompany> getAirlineById(@PathVariable Long id){
        return airlineCompanyService.getAirlineById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAirlineById(@PathVariable Long id){
        airlineCompanyService.deleteAirlineById(id);
    }
}

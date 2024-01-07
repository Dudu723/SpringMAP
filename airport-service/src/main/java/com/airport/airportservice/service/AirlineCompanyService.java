package com.airport.airportservice.service;

import com.airport.airportservice.entity.AirlineCompany;
import com.airport.airportservice.repository.AirlineCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirlineCompanyService {
    private final AirlineCompanyRepository airlineCompanyRepository;

    @Autowired
    public AirlineCompanyService(AirlineCompanyRepository airlineCompanyRepository) {
        this.airlineCompanyRepository = airlineCompanyRepository;
    }

    public List<AirlineCompany> getAllAirlines(){
        return airlineCompanyRepository.findAll();
    }

    public AirlineCompany addAirlineCompany(AirlineCompany airlineCompany){
        return airlineCompanyRepository.save(airlineCompany);
    }

    public Optional<AirlineCompany> getAirlineById(Long id){
        return airlineCompanyRepository.findById(id);
    }

    public void deleteAirlineById(Long id){
        airlineCompanyRepository.deleteById(id);
    }
}


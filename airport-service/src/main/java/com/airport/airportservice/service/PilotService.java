package com.airport.airportservice.service;

import com.airport.airportservice.entity.Flight;
import com.airport.airportservice.entity.Pilot;
import com.airport.airportservice.repository.FlightRepository;
import com.airport.airportservice.repository.PilotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PilotService {
    private final PilotRepository pilotRepository;

    @Autowired
    public PilotService(PilotRepository pilotRepository) {
        this.pilotRepository = pilotRepository;
    }

    public List<Pilot> getAllPilots() {
        return pilotRepository.findAll();
    }

    public Pilot addPilot(Pilot pilot) {
        return pilotRepository.save(pilot);
    }

    public Optional<Pilot> getPilotById(Long id) {
        return pilotRepository.findById(id);
    }

    public void deletePilotById(Long id) {
        pilotRepository.deleteById(id);
    }

}

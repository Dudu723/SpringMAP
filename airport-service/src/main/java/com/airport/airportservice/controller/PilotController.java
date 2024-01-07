package com.airport.airportservice.controller;


import com.airport.airportservice.entity.Pilot;
import com.airport.airportservice.service.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pilots")
public class PilotController {

    private final PilotService pilotService;

    @Autowired
    public PilotController(PilotService pilotService) {
        this.pilotService = pilotService;
    }

    @GetMapping
    public List<Pilot> getAllPilots() {
        return pilotService.getAllPilots();
    }

    @PostMapping
    public Pilot addPilot(@RequestBody Pilot pilot) {
        return pilotService.addPilot(pilot);
    }

    @GetMapping("/{id}")
    public Optional<Pilot> getPilot(@PathVariable Long id) {
        return pilotService.getPilotById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePilotById(@PathVariable Long id) {
        pilotService.deletePilotById(id);
    }

}

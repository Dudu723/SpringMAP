package com.airport.airportservice.controller;

import com.airport.airportservice.entity.Plane;
import com.airport.airportservice.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/planes")
public class PlaneController {

    private final PlaneRepository planeRepository;

    @Autowired
    public PlaneController(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    @GetMapping
    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    @PostMapping
    public Plane addPlane(@RequestBody Plane plane) {
        return planeRepository.save(plane);
    }

    @GetMapping("/{id}")
    public Optional<Plane> getPlane(@PathVariable Long id) {
        return planeRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePlaneById(@PathVariable Long id) {
        planeRepository.deleteById(id);
    }
}

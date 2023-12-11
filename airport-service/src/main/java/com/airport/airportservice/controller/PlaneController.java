package com.airport.airportservice.controller;

import com.airport.airportservice.entity.Plane;
import com.airport.airportservice.repository.PlaneRepository;
import com.airport.airportservice.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/planes")
public class PlaneController {

    private final PlaneService planeService;

    @Autowired
    public PlaneController(PlaneService planeService) {
        this.planeService = planeService;
    }

    @GetMapping
    public List<Plane> getAllPlanes() {
        return planeService.getAllPlanes();
    }

    @PostMapping
    public Plane addPlane(@RequestBody Plane plane) {
        return planeService.addPlane(plane);
    }

    @GetMapping("/{id}")
    public Optional<Plane> getPlane(@PathVariable Long id) {
        return planeService.getPlaneById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePlaneById(@PathVariable Long id) {
        planeService.deletePlaneById(id);
    }
}

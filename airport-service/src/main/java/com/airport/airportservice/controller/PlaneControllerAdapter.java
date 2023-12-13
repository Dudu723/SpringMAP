package com.airport.airportservice.controller;

import com.airport.airportservice.entity.Plane;
import com.airport.airportservice.service.PlaneAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/planes")
public class PlaneControllerAdapter {

    private final PlaneAdapter planeAdapter;

    @Autowired
    public PlaneControllerAdapter(PlaneAdapter planeAdapter) {
        this.planeAdapter = planeAdapter;
    }

    @GetMapping
    public List<Plane> getAllPlanes() {
        return planeAdapter.getAllPlanes();
    }

    @PostMapping
    public Plane addPlane(@RequestBody Plane plane) {
        return planeAdapter.addPlane(plane);
    }

    @GetMapping("/{id}")
    public Optional<Plane> getPlane(@PathVariable Long id) {
        return planeAdapter.getPlaneById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePlaneById(@PathVariable Long id) {
        planeAdapter.deletePlaneById(id);
    }
}

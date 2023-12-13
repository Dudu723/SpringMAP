package com.airport.airportservice.service;

import com.airport.airportservice.entity.Plane;
import com.airport.airportservice.service.PlaneAdapter;
import com.airport.airportservice.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneServiceAdapter implements PlaneAdapter {

    private final PlaneService planeService;

    @Autowired
    public PlaneServiceAdapter(PlaneService planeService) {
        this.planeService = planeService;
    }

    @Override
    public List<Plane> getAllPlanes() {
        return planeService.getAllPlanes();
    }

    @Override
    public Plane addPlane(Plane plane) {
        return planeService.addPlane(plane);
    }

    @Override
    public Optional<Plane> getPlaneById(Long id) {
        return planeService.getPlaneById(id);
    }

    @Override
    public void deletePlaneById(Long id) {
        planeService.deletePlaneById(id);
    }
}

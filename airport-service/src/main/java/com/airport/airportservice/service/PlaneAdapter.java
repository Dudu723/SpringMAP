package com.airport.airportservice.service;

import com.airport.airportservice.entity.Plane;

import java.util.List;
import java.util.Optional;

public interface PlaneAdapter {
    List<Plane> getAllPlanes();
    Plane addPlane(Plane plane);
    Optional<Plane> getPlaneById(Long id);
    void deletePlaneById(Long id);
}

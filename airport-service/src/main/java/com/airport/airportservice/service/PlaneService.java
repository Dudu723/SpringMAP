package com.airport.airportservice.service;

import com.airport.airportservice.entity.Plane;
import com.airport.airportservice.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaneService {

    private final PlaneRepository planeRepository;

    @Autowired
    public PlaneService(PlaneRepository planeRepository) {
        this.planeRepository = planeRepository;
    }

    public List<Plane> getAllPlanes() {
        return planeRepository.findAll();
    }

    public Plane addPlane(Plane plane) {
        return planeRepository.save(plane);
    }

    public Optional<Plane> getPlaneById(Long id) {
        return planeRepository.findById(id);
    }

    public void deletePlaneById(Long id) {
        planeRepository.deleteById(id);
    }
}

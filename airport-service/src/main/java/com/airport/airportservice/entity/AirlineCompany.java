package com.airport.airportservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class AirlineCompany {

    @Id
    private Long id;

    private String name;
    private int fleetSize;


    public AirlineCompany(Long id, String name, int fleetSize) {
        this.id = id;
        this.name = name;
        this.fleetSize = fleetSize;
    }

    public AirlineCompany() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFleetSize() {
        return fleetSize;
    }

    public void setFleetSize(int fleetSize) {
        this.fleetSize = fleetSize;
    }

}

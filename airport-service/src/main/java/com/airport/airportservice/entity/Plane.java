package com.airport.airportservice.entity;

import jakarta.persistence.*;

@Entity
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String manufacturer;
    private String model;

    @OneToOne
    @JoinColumn(name = "pilotId")
    private Pilot pilot;

    public Plane() {
    }

    public Plane(String manufacturer, String model, Pilot pilot) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.pilot = pilot;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public void setPilot(Pilot pilot) {
        this.pilot = pilot;
    }
}
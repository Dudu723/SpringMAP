package com.airport.airportservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class BoardingGate {

    @Id
    private Long id;

    private String status;
    @OneToOne
    @JoinColumn(name = "flightId")
    private Flight flight;

    public BoardingGate(Long id, String status, Flight flight) {
        this.id = id;
        this.status = status;
        this.flight = flight;
    }

    public BoardingGate() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

}

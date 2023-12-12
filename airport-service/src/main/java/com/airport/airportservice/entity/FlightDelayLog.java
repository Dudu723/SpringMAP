package com.airport.airportservice.entity;

import jakarta.persistence.*;

@Entity
public class FlightDelayLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "flightId")
    private Flight flight;
    private String duration;

    public FlightDelayLog(Long id, Flight flight, String duration) {
        this.id = id;
        this.flight = flight;
        this.duration = duration;
    }

    public FlightDelayLog() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }


}

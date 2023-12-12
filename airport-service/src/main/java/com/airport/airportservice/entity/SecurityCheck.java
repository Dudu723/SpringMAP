package com.airport.airportservice.entity;

import jakarta.persistence.*;

@Entity
public class SecurityCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "passengerId")
    private Passenger passenger;
    private String result;

    public SecurityCheck(Long id, Passenger passenger, String result) {
        this.id = id;
        this.passenger = passenger;
        this.result = result;
    }

    public SecurityCheck() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

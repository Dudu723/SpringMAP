package com.airport.airportservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Passenger extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int passportNumber;

    public Passenger() {
    }

    public Passenger(String firstName, String lastName, int age, Long id, int passportNumber) {
        super(firstName, lastName, age);
        this.id = id;
        this.passportNumber = passportNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", passportNumber=" + passportNumber +
                '}';
    }
}

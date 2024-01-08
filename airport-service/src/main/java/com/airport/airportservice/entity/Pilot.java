package com.airport.airportservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pilot extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int yearsOfActivity;

    public Pilot() {
    }

    public Pilot(String firstName, String lastName, int age, Long id, int yearsOfActivity) {
        super(firstName, lastName, age);
        this.id = id;
        this.yearsOfActivity = yearsOfActivity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYearsOfActivity() {
        return yearsOfActivity;
    }

    public void setYearsOfActivity(int yearsOfActivity) {
        this.yearsOfActivity = yearsOfActivity;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "id=" + id +
                ", yearsOfActivity=" + yearsOfActivity +
                '}';
    }
}

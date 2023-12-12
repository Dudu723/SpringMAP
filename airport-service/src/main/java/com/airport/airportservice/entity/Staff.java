package com.airport.airportservice.entity;

import jakarta.persistence.*;

@Entity
public class Staff extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;

    @ManyToOne
    @JoinColumn(name = "airlineId")
    private AirlineCompany airlineCompany;

    public Staff(String firstName, String lastName, int age, Long id, String role, AirlineCompany airlineCompany) {
        super(firstName, lastName, age);
        this.id = id;
        this.role = role;
        this.airlineCompany = airlineCompany;
    }
    public Staff() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public AirlineCompany getAirlineCompany() {
        return airlineCompany;
    }

    public void setAirlineCompany(AirlineCompany airlineCompany) {
        this.airlineCompany = airlineCompany;
    }
}

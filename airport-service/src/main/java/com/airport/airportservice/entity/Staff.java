package com.airport.airportservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Staff extends Person{
    @Id
    private Long id;
    private String role;
    @ManyToOne
    @JoinColumn(name = "airlineId")
    private Staff staff;

    public Staff(String firstName, String lastName, int age, Long id, String role, Staff staff) {
        super(firstName, lastName, age);
        this.id = id;
        this.role = role;
        this.staff = staff;
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

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

}

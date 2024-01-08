package com.airport.airportservice.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double price;

    @ManyToOne
    @JoinColumn(name = "passengerId")
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "flightId")
    private Flight flight;

    public Ticket() {
    }

    public Ticket(double price, Passenger passenger, Flight flight) {
        this.price = price;
        this.passenger = passenger;
        this.flight = flight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(flight, ticket.flight) && Objects.equals(passenger, ticket.passenger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flight, passenger);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", passenger=" + passenger +
                ", flight=" + flight +
                '}';
    }
}
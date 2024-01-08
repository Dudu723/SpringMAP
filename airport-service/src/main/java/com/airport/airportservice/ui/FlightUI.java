package com.airport.airportservice.ui;
import com.airport.airportservice.controller.FlightController;
import com.airport.airportservice.controller.FlightControllerProxy;
import com.airport.airportservice.controller.RealFlightController;
import com.airport.airportservice.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


@Component
public class FlightUI {

    private final FlightController realFlightController;
    private FlightController flightController;

    @Autowired
    public FlightUI(FlightController realFlightController) {
        this.realFlightController = realFlightController;
    }

    public int start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();


        flightController = new FlightControllerProxy(realFlightController, username);


        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllFlights();
                    break;
                case 2:
                    addFlight();
                    break;
                case 3:
                    viewFlightById();
                    break;
                case 4:
                    deleteFlight();
                    break;
                case 5:
                    System.out.println("Returning to the main menu.");
                    return 0;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\nAirport Management System");
        System.out.println("1. View All Flights");
        System.out.println("2. Add a Flight");
        System.out.println("3. View Flight by ID");
        System.out.println("4. Delete a Flight");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void viewAllFlights() {
        List<Flight> flights = flightController.getAllFlights();
        System.out.println("\nAll Flights:");
        for (Flight flight : flights) {
            System.out.println(flight.getId());
            System.out.println(flight);
        }
    }

    private void addFlight() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter departure time: ");
        String departureTime = scanner.nextLine();
        System.out.print("Enter arrival time: ");
        String arrivalTime = scanner.nextLine();

        Flight newFlight = new Flight(null, departureTime, arrivalTime);
        flightController.addFlight(newFlight);
        System.out.println("Flight added successfully!");
    }

    private void viewFlightById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Flight ID: ");
        Long flightId = scanner.nextLong();

        Optional<Flight> flight = flightController.getFlight(flightId);
        if (flight.isPresent()) {
            System.out.println("\nFlight details:\n" + flight.get());
        } else {
            System.out.println("Flight not found with ID: " + flightId);
        }
    }

    private void deleteFlight() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Flight ID to delete: ");
        Long flightId = scanner.nextLong();

        flightController.deleteFlightById(flightId);
    }
}


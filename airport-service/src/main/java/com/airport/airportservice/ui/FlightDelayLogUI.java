package com.airport.airportservice.ui;

import com.airport.airportservice.controller.FlightDelayLogController;
import com.airport.airportservice.entity.Flight;
import com.airport.airportservice.entity.FlightDelayLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class FlightDelayLogUI {

    private final FlightDelayLogController flightDelayLogController;

    @Autowired
    public FlightDelayLogUI(FlightDelayLogController flightDelayLogController) {
        this.flightDelayLogController = flightDelayLogController;
    }

    public int start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllFlightDelays();
                    break;
                case 2:
                    addFlightDelay();
                    break;
                case 3:
                    viewFlightDelayById();
                    break;
                case 4:
                    deleteFlightDelay();
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
        System.out.println("\nFlight Delay Log Management System");
        System.out.println("1. View All Flight Delays");
        System.out.println("2. Add a Flight Delay");
        System.out.println("3. View Flight Delay by ID");
        System.out.println("4. Delete a Flight Delay");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void viewAllFlightDelays() {
        List<FlightDelayLog> flightDelays = flightDelayLogController.getAllFlightDelays();
        System.out.println("\nAll Flight Delays:");
        for (FlightDelayLog flightDelay : flightDelays) {
            System.out.println(flightDelay);
        }
    }

    private void addFlightDelay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Flight ID: ");
        Long flightId = scanner.nextLong();
        System.out.print("Enter Delay Duration: ");
        String duration = scanner.next();

        FlightDelayLog newFlightDelay = new FlightDelayLog(null, new Flight(flightId, null, null), duration);
        flightDelayLogController.addFlightDelay(newFlightDelay);
        System.out.println("Flight Delay added successfully!");
    }

    private void viewFlightDelayById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Flight Delay ID: ");
        Long flightDelayId = scanner.nextLong();

        Optional<FlightDelayLog> flightDelay = flightDelayLogController.getFlightDelayById(flightDelayId);
        if (flightDelay.isPresent()) {
            System.out.println("\nFlight Delay details:\n" + flightDelay.get());
        } else {
            System.out.println("Flight Delay not found with ID: " + flightDelayId);
        }
    }

    private void deleteFlightDelay() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Flight Delay ID to delete: ");
        Long flightDelayId = scanner.nextLong();

        flightDelayLogController.deleteFlightDelayLog(flightDelayId);
    }
}

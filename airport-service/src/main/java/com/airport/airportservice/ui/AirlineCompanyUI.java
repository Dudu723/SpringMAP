package com.airport.airportservice.ui;

import com.airport.airportservice.controller.AirlineCompanyController;
import com.airport.airportservice.entity.AirlineCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;


@Component
public class AirlineCompanyUI {
    private final AirlineCompanyController airlineCompanyController;

    @Autowired
    public AirlineCompanyUI(AirlineCompanyController airlineCompanyController) {
        this.airlineCompanyController = airlineCompanyController;
    }

    public int start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllAirlines();
                    break;
                case 2:
                    addAirline();
                    break;
                case 3:
                    viewAirlineById();
                    break;
                case 4:
                    deleteAirline();
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
        System.out.println("\nAirline Company Management System");
        System.out.println("1. View All Airlines");
        System.out.println("2. Add an Airline");
        System.out.println("3. View Airline by ID");
        System.out.println("4. Delete an Airline");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void viewAllAirlines() {
        List<AirlineCompany> airlines = airlineCompanyController.getAllAirlines();
        System.out.println("\nAll Airlines:");
        for (AirlineCompany airline : airlines) {
            System.out.println(airline.getId());
            System.out.println(airline);
        }
    }

    private void addAirline() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter airline name: ");
        String name = scanner.nextLine();
        System.out.print("Enter fleet size: ");
        int fleetSize = scanner.nextInt();

        AirlineCompany newAirline = new AirlineCompany(null, name, fleetSize);
        airlineCompanyController.addAirlineCompany(newAirline);
        System.out.println("Airline added successfully!");
    }

    private void viewAirlineById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Airline ID: ");
        Long airlineId = scanner.nextLong();

        Optional<AirlineCompany> airline = airlineCompanyController.getAirlineById(airlineId);
        if (airline.isPresent()) {
            System.out.println("\nAirline details:\n" + airline.get());
        } else {
            System.out.println("Airline not found with ID: " + airlineId);
        }
    }

    private void deleteAirline() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Airline ID to delete: ");
        Long airlineId = scanner.nextLong();

        airlineCompanyController.deleteAirlineById(airlineId);
    }
}

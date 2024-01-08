package com.airport.airportservice.ui;

import com.airport.airportservice.controller.PassengerController;
import com.airport.airportservice.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class PassengerUI {

    private final PassengerController passengerController;

    @Autowired
    public PassengerUI(PassengerController passengerController) {
        this.passengerController = passengerController;
    }

    public int start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllPassengers();
                    break;
                case 2:
                    addPassenger();
                    break;
                case 3:
                    viewPassengerById();
                    break;
                case 4:
                    deletePassenger();
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
        System.out.println("\nPassenger Management System");
        System.out.println("1. View All Passengers");
        System.out.println("2. Add a Passenger");
        System.out.println("3. View Passenger by ID");
        System.out.println("4. Delete a Passenger");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void viewAllPassengers() {
        List<Passenger> passengers = passengerController.getAllPassengers();
        System.out.println("\nAll Passengers:");
        for (Passenger passenger : passengers) {
            System.out.println(passenger);
        }
    }

    private void addPassenger() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.print("Enter passport number: ");
        int passportNumber = scanner.nextInt();

        Passenger newPassenger = new Passenger(firstName, lastName, age, null, passportNumber);
        passengerController.addPassanger(newPassenger);
        System.out.println("Passenger added successfully!");
    }

    private void viewPassengerById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Passenger ID: ");
        Long passengerId = scanner.nextLong();

        Optional<Passenger> passenger = passengerController.getPassengerById(passengerId);
        if (passenger.isPresent()) {
            System.out.println("\nPassenger details:\n" + passenger.get());
        } else {
            System.out.println("Passenger not found with ID: " + passengerId);
        }
    }

    private void deletePassenger() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Passenger ID to delete: ");
        Long passengerId = scanner.nextLong();

        passengerController.deletePassengerById(passengerId);
    }
}

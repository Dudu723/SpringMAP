package com.airport.airportservice.ui;

import com.airport.airportservice.controller.PilotController;
import com.airport.airportservice.entity.Pilot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class PilotUI {

    private final PilotController pilotController;

    @Autowired
    public PilotUI(PilotController pilotController) {
        this.pilotController = pilotController;
    }

    public int start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllPilots();
                    break;
                case 2:
                    addPilot();
                    break;
                case 3:
                    viewPilotById();
                    break;
                case 4:
                    deletePilot();
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
        System.out.println("\nPilot Management System");
        System.out.println("1. View All Pilots");
        System.out.println("2. Add a Pilot");
        System.out.println("3. View Pilot by ID");
        System.out.println("4. Delete a Pilot");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void viewAllPilots() {
        List<Pilot> pilots = pilotController.getAllPilots();
        System.out.println("\nAll Pilots:");
        for (Pilot pilot : pilots) {
            System.out.println(pilot);
        }
    }

    private void addPilot() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter pilot's first name: ");
        String firstName = scanner.next();
        System.out.print("Enter pilot's last name: ");
        String lastName = scanner.next();
        System.out.print("Enter pilot's age: ");
        int age = scanner.nextInt();
        System.out.print("Enter years of activity: ");
        int yearsOfActivity = scanner.nextInt();

        Pilot newPilot = new Pilot(firstName, lastName, age, null, yearsOfActivity);
        pilotController.addPilot(newPilot);
        System.out.println("Pilot added successfully!");
    }

    private void viewPilotById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Pilot ID: ");
        Long pilotId = scanner.nextLong();

        Optional<Pilot> pilot = pilotController.getPilot(pilotId);
        if (pilot.isPresent()) {
            System.out.println("\nPilot details:\n" + pilot.get());
        } else {
            System.out.println("Pilot not found with ID: " + pilotId);
        }
    }

    private void deletePilot() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Pilot ID to delete: ");
        Long pilotId = scanner.nextLong();

        pilotController.deletePilotById(pilotId);
    }
}

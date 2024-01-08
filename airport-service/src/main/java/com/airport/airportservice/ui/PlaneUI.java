package com.airport.airportservice.ui;

import com.airport.airportservice.controller.PlaneControllerAdapter;
import com.airport.airportservice.entity.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class PlaneUI {

    private final PlaneControllerAdapter planeController;

    @Autowired
    public PlaneUI(PlaneControllerAdapter planeController) {
        this.planeController = planeController;
    }

    public int start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllPlanes();
                    break;
                case 2:
                    addPlane();
                    break;
                case 3:
                    viewPlaneById();
                    break;
                case 4:
                    deletePlane();
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
        System.out.println("\nPlane Management System");
        System.out.println("1. View All Planes");
        System.out.println("2. Add a Plane");
        System.out.println("3. View Plane by ID");
        System.out.println("4. Delete a Plane");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void viewAllPlanes() {
        List<Plane> planes = planeController.getAllPlanes();
        System.out.println("\nAll Planes:");
        for (Plane plane : planes) {
            System.out.println(plane);
        }
    }

    private void addPlane() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter manufacturer: ");
        String manufacturer = scanner.next();
        System.out.print("Enter model: ");
        String model = scanner.next();

        Plane newPlane = new Plane(manufacturer, model, null);
        planeController.addPlane(newPlane);
        System.out.println("Plane added successfully!");
    }

    private void viewPlaneById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Plane ID: ");
        Long planeId = scanner.nextLong();

        Optional<Plane> plane = planeController.getPlane(planeId);
        if (plane.isPresent()) {
            System.out.println("\nPlane details:\n" + plane.get());
        } else {
            System.out.println("Plane not found with ID: " + planeId);
        }
    }

    private void deletePlane() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Plane ID to delete: ");
        Long planeId = scanner.nextLong();

        planeController.deletePlaneById(planeId);
    }
}

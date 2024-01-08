package com.airport.airportservice.ui;

import com.airport.airportservice.controller.SecurityCheckController;
import com.airport.airportservice.entity.SecurityCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class SecurityCheckUI {

    private final SecurityCheckController securityCheckController;

    @Autowired
    public SecurityCheckUI(SecurityCheckController securityCheckController) {
        this.securityCheckController = securityCheckController;
    }

    public int start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllSecurityChecks();
                    break;
                case 2:
                    addSecurityCheck();
                    break;
                case 3:
                    viewSecurityCheckById();
                    break;
                case 4:
                    deleteSecurityCheck();
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
        System.out.println("\nSecurity Check Management System");
        System.out.println("1. View All Security Checks");
        System.out.println("2. Add a Security Check");
        System.out.println("3. View Security Check by ID");
        System.out.println("4. Delete a Security Check");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void viewAllSecurityChecks() {
        List<SecurityCheck> securityChecks = securityCheckController.getAllSecurityChecks();
        System.out.println("\nAll Security Checks:");
        for (SecurityCheck securityCheck : securityChecks) {
            System.out.println(securityCheck.getId());
            System.out.println(securityCheck);
        }
    }

    private void addSecurityCheck() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter passenger ID: ");
        Long passengerId = scanner.nextLong();
        scanner.nextLine(); // consume the newline
        System.out.print("Enter security check result: ");
        String result = scanner.nextLine();

        SecurityCheck newSecurityCheck = new SecurityCheck(null, null, result);
        securityCheckController.addSecurityCheck(newSecurityCheck);
        System.out.println("Security Check added successfully!");
    }

    private void viewSecurityCheckById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Security Check ID: ");
        Long securityCheckId = scanner.nextLong();

        Optional<SecurityCheck> securityCheck = securityCheckController.getSecurityCheck(securityCheckId);
        if (securityCheck.isPresent()) {
            System.out.println("\nSecurity Check details:\n" + securityCheck.get());
        } else {
            System.out.println("Security Check not found with ID: " + securityCheckId);
        }
    }

    private void deleteSecurityCheck() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Security Check ID to delete: ");
        Long securityCheckId = scanner.nextLong();

        securityCheckController.deleteSecurityCheckById(securityCheckId);
    }
}

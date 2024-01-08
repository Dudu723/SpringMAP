package com.airport.airportservice.ui;

import com.airport.airportservice.controller.StaffController;
import com.airport.airportservice.entity.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class StaffUI {

    private final StaffController staffController;

    @Autowired
    public StaffUI(StaffController staffController) {
        this.staffController = staffController;
    }

    public int start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllStaff();
                    break;
                case 2:
                    addStaff();
                    break;
                case 3:
                    viewStaffById();
                    break;
                case 4:
                    deleteStaff();
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
        System.out.println("\nStaff Management System");
        System.out.println("1. View All Staff");
        System.out.println("2. Add Staff");
        System.out.println("3. View Staff by ID");
        System.out.println("4. Delete Staff");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void viewAllStaff() {
        List<Staff> staffList = staffController.getAllStaff();
        System.out.println("\nAll Staff:");
        for (Staff staff : staffList) {
            System.out.println(staff.getId());
            System.out.println(staff);
        }
    }

    private void addStaff() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // consume the newline
        System.out.print("Enter role: ");
        String role = scanner.nextLine();
        System.out.print("Enter airline ID: ");
        Long airlineId = scanner.nextLong();

        Staff newStaff = new Staff(firstName, lastName, age, null, role, null);
        staffController.addStaff(newStaff);
        System.out.println("Staff added successfully!");
    }

    private void viewStaffById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Staff ID: ");
        Long staffId = scanner.nextLong();

        Optional<Staff> staff = staffController.getStaff(staffId);
        if (staff.isPresent()) {
            System.out.println("\nStaff details:\n" + staff.get());
        } else {
            System.out.println("Staff not found with ID: " + staffId);
        }
    }

    private void deleteStaff() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Staff ID to delete: ");
        Long staffId = scanner.nextLong();

        staffController.deleteStaffById(staffId);
    }
}

package com.airport.airportservice.ui;

import com.airport.airportservice.controller.BoardingGateController;
import com.airport.airportservice.entity.BoardingGate;
import com.airport.airportservice.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class BoardingGateUI {

    private final BoardingGateController boardingGateController;

    @Autowired
    public BoardingGateUI(BoardingGateController boardingGateController) {
        this.boardingGateController = boardingGateController;
    }

    public int start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllBoardingGates();
                    break;
                case 2:
                    addBoardingGate();
                    break;
                case 3:
                    viewBoardingGateById();
                    break;
                case 4:
                    deleteBoardingGate();
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
        System.out.println("\nBoarding Gate Management System");
        System.out.println("1. View All Boarding Gates");
        System.out.println("2. Add a Boarding Gate");
        System.out.println("3. View Boarding Gate by ID");
        System.out.println("4. Delete a Boarding Gate");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void viewAllBoardingGates() {
        List<BoardingGate> boardingGates = boardingGateController.getAllBoardingGates();
        System.out.println("\nAll Boarding Gates:");
        for (BoardingGate boardingGate : boardingGates) {
            System.out.println(boardingGate);
        }
    }

    private void addBoardingGate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter status: ");
        String status = scanner.nextLine();

        // For simplicity, assuming flight details are entered manually
        System.out.print("Enter Flight ID: ");
        Long flightId = scanner.nextLong();
        Flight flight = new Flight(flightId, "10:00", "12:00");

        BoardingGate newBoardingGate = new BoardingGate(null, status, flight);
        boardingGateController.addBoardingGate(newBoardingGate);
        System.out.println("Boarding Gate added successfully!");
    }

    private void viewBoardingGateById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Boarding Gate ID: ");
        Long boardingGateId = scanner.nextLong();

        Optional<BoardingGate> boardingGate = boardingGateController.getBoardingGateById(boardingGateId);
        if (boardingGate.isPresent()) {
            System.out.println("\nBoarding Gate details:\n" + boardingGate.get());
        } else {
            System.out.println("Boarding Gate not found with ID: " + boardingGateId);
        }
    }

    private void deleteBoardingGate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Boarding Gate ID to delete: ");
        Long boardingGateId = scanner.nextLong();

        boardingGateController.deleteBoardingGateById(boardingGateId);
    }
}

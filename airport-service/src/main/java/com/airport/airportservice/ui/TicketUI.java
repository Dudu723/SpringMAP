package com.airport.airportservice.ui;

import com.airport.airportservice.controller.TicketController;
import com.airport.airportservice.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class TicketUI {

    private final TicketController ticketController;

    @Autowired
    public TicketUI(TicketController ticketController) {
        this.ticketController = ticketController;
    }

    public int start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllTickets();
                    break;
                case 2:
                    addTicket();
                    break;
                case 3:
                    viewTicketById();
                    break;
                case 4:
                    deleteTicket();
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
        System.out.println("\nTicket Management System");
        System.out.println("1. View All Tickets");
        System.out.println("2. Add Ticket");
        System.out.println("3. View Ticket by ID");
        System.out.println("4. Delete Ticket");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void viewAllTickets() {
        List<Ticket> ticketList = ticketController.getAllTickets();
        System.out.println("\nAll Tickets:");
        for (Ticket ticket : ticketList) {
            System.out.println(ticket);
        }
    }

    private void addTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ticket price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter passenger ID: ");
        Long passengerId = scanner.nextLong();
        System.out.print("Enter flight ID: ");
        Long flightId = scanner.nextLong();

        Ticket newTicket = new Ticket(price, null, null);
        ticketController.addTicket(newTicket);
        System.out.println("Ticket added successfully!");
    }

    private void viewTicketById() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Ticket ID: ");
        Long ticketId = scanner.nextLong();

        Optional<Ticket> ticket = ticketController.getTicket(ticketId);
        if (ticket.isPresent()) {
            System.out.println("\nTicket details:\n" + ticket.get());
        } else {
            System.out.println("Ticket not found with ID: " + ticketId);
        }
    }

    private void deleteTicket() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Ticket ID to delete: ");
        Long ticketId = scanner.nextLong();

        ticketController.deleteTicketById(ticketId);
    }
}

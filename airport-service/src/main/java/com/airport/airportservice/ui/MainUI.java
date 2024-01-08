package com.airport.airportservice.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Component
public class MainUI {

   public void start(){
       Scanner scanner = new Scanner(System.in);
       
       while(true){
           printMainMenu();
           int choice = scanner.nextInt();
       }
   }

    private void printMainMenu() {
        System.out.println("\nSelect an entity to work on:");
        System.out.println("1. AirlineCompany");
        System.out.println("2. BoardingGate");
        System.out.println("3. Flight");
        System.out.println("4. FlightDelayLog");
        System.out.println("5. Passenger");
        System.out.println("6. Pilot");
        System.out.println("7. Plane");
        System.out.println("8. SecurityCheck");
        System.out.println("9. Staff");
        System.out.println("10. Ticket");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
}

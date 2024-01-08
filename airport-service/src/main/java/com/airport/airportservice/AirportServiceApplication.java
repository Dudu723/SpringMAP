package com.airport.airportservice;

import com.airport.airportservice.ui.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class AirportServiceApplication {

	public static void main(String[] args) {
//		ApplicationContext context = SpringApplication.run(AirportServiceApplication.class, args);
//		FlightUI flightUI = context.getBean(FlightUI.class);
//		flightUI.start();
//		AirlineCompanyUI airlineCompanyUI = context.getBean(AirlineCompanyUI.class);
//		airlineCompanyUI.start();
		runMenu();

	}

	public static void runMenu() {
		ApplicationContext context = SpringApplication.run(AirportServiceApplication.class);

		Scanner scanner = new Scanner(System.in);


		while (true) {
			System.out.println("Choose an option:");
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

			int choice = scanner.nextInt();

			switch (choice) {
				case 1:
					AirlineCompanyUI airlineCompanyUI = context.getBean(AirlineCompanyUI.class);
					airlineCompanyUI.start();
					break;
				case 2:
					BoardingGateUI boardingGateUI = context.getBean(BoardingGateUI.class);
					boardingGateUI.start();
					break;
				case 3:
					FlightUI flightUI = context.getBean(FlightUI.class);
					flightUI.start();
					break;
				case 4:
					FlightDelayLogUI flightDelayLogUI = context.getBean(FlightDelayLogUI.class);
					flightDelayLogUI.start();
					break;
				case 5:
					PassengerUI passengerUI = context.getBean(PassengerUI.class);
					passengerUI.start();
					break;
				case 6:
					PilotUI pilotUI = context.getBean(PilotUI.class);
					pilotUI.start();
					break;
				case 7:
					PlaneUI planeUI = context.getBean(PlaneUI.class);
					planeUI.start();
					break;
				case 8:
					SecurityCheckUI securityCheckUI = context.getBean(SecurityCheckUI.class);
					securityCheckUI.start();
					break;
				case 9:
					StaffUI staffUI = context.getBean(StaffUI.class);
					staffUI.start();
					break;
				case 10:
					TicketUI ticketUI = context.getBean(TicketUI.class);
					ticketUI.start();
					break;
				case 0:
					System.out.println("Exiting...");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice. Please enter a valid option.");
			}
		}
	}

}

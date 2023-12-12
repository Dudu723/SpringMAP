package com.airport.airportservice;

import com.airport.airportservice.ui.FlightUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AirportServiceApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AirportServiceApplication.class, args);
		FlightUI flightUI = context.getBean(FlightUI.class);
		flightUI.start();
	}

}

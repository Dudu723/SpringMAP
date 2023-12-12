package com.airport.airportservice;

import com.airport.airportservice.controller.FlightController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.airport.airportservice.entity.Flight;
import com.airport.airportservice.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;



@SpringBootTest
class AirportServiceApplicationTests {

//	@Autowired
//	private FlightService flightService;
//
//	@Test
//	void testAddAndGetFlight() {
//		Flight newFlight = new Flight(null, "12:00:00", "15:00:00");
//		Flight savedFlight = flightService.addFlight(newFlight);
//
//		Optional<Flight> retrievedFlight = flightService.getFlightById(savedFlight.getId());
//
//		assertTrue(retrievedFlight.isPresent());
//		assertEquals(newFlight.getDepartureTime(), retrievedFlight.get().getDepartureTime());
//		assertEquals(newFlight.getArrivalTime(), retrievedFlight.get().getArrivalTime());
//	}
//
//	@Test
//	void testGetAllFlights() {
//		Flight flight1 = new Flight(null, "12:00:00", "15:00:00");
//		Flight flight2 = new Flight(null, "14:00:00", "17:00:00");
//		flightService.addFlight(flight1);
//		flightService.addFlight(flight2);
//
//		List<Flight> allFlights = flightService.getAllFlights();
//
//		assertEquals(2, allFlights.size());
//	}
//
//	@Test
//	void testDeleteFlight() {
//		Flight newFlight = new Flight(null, "12:00:00", "15:00:00");
//		Flight savedFlight = flightService.addFlight(newFlight);
//
//		flightService.deleteFlightById(savedFlight.getId());
//
//		Optional<Flight> deletedFlight = flightService.getFlightById(savedFlight.getId());
//
//		assertTrue(deletedFlight.isEmpty());
//	}

	@Autowired
	private FlightController flightController;

	@Test
	void testAddAndGetFlight() {
		Flight newFlight = new Flight(null, "12:00:00", "15:00:00");
		Flight savedFlight = flightController.addFlight(newFlight);

		Optional<Flight> retrievedFlight = flightController.getFlight(savedFlight.getId());

		assertTrue(retrievedFlight.isPresent());
		assertEquals(newFlight.getDepartureTime(), retrievedFlight.get().getDepartureTime());
		assertEquals(newFlight.getArrivalTime(), retrievedFlight.get().getArrivalTime());
	}

	@Test
	void testGetAllFlights() {
		Flight flight1 = new Flight(null, "12:00:00", "15:00:00");
		Flight flight2 = new Flight(null, "14:00:00", "17:00:00");
		flightController.addFlight(flight1);
		flightController.addFlight(flight2);

		List<Flight> allFlights = flightController.getAllFlights();

		assertEquals(2, allFlights.size());
	}

	@Test
	void testDeleteFlight() {
		Flight newFlight = new Flight(null, "12:00:00", "15:00:00");
		Flight savedFlight = flightController.addFlight(newFlight);

		flightController.deleteFlightById(savedFlight.getId());

		Optional<Flight> deletedFlight = flightController.getFlight(savedFlight.getId());

		assertTrue(deletedFlight.isEmpty());
	}
}


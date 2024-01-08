package com.airport.airportservice;

import com.airport.airportservice.controller.FlightControllerProxy;
import com.airport.airportservice.controller.RealFlightController;
import com.airport.airportservice.entity.Flight;
import com.airport.airportservice.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class FlightTest {

    @Mock
    private FlightService flightService;

    @InjectMocks
    private RealFlightController flightController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(flightController).build();
    }

    @Test
    public void getAllFlights_ReturnsFlightList() throws Exception {
        List<Flight> expectedFlights = Arrays.asList(
                new Flight(1L, "10:00", "12:00"),
                new Flight(2L, "13:00", "15:00")
        );

        when(flightService.getAllFlights()).thenReturn(expectedFlights);

        List<Flight> actualFlights = flightController.getAllFlights();

        assertEquals(expectedFlights, actualFlights);

        verify(flightService, times(1)).getAllFlights();
    }

    @Test
    public void addFlight_ReturnsAddedFlight() throws Exception {
        Flight newFlight = new Flight(null, "08:00", "10:00");
        Flight savedFlight = new Flight(1L, "08:00", "10:00");

        when(flightService.addFlight(newFlight)).thenReturn(savedFlight);

        Flight returnedFlight = flightController.addFlight(newFlight);

        assertEquals(savedFlight, returnedFlight);

        verify(flightService, times(1)).addFlight(newFlight);
    }

    @Test
    public void getFlightById_ReturnsFlight() throws Exception {
        Long flightId = 1L;
        Flight expectedFlight = new Flight(flightId, "10:00", "12:00");

        when(flightService.getFlightById(flightId)).thenReturn(Optional.of(expectedFlight));

        Optional<Flight> actualFlight = flightController.getFlight(flightId);

        assertTrue(actualFlight.isPresent());
        assertEquals(expectedFlight, actualFlight.get());

        verify(flightService, times(1)).getFlightById(flightId);
    }

    @Test
    public void deleteFlightById_Success() throws Exception {
        Long flightId = 1L;

        flightController.deleteFlightById(flightId);
        verify(flightService, times(1)).deleteFlightById(flightId);
    }

//
//    @Test
//    public void deleteFlightById_AdminAndNotAdmin_PermissionHandling() throws Exception {
//        Long flightId = 1L;
//
//        // Test with non-admin user
//        FlightControllerProxy nonAdminFlightController = new FlightControllerProxy(flightController, "user");
//
//        mockMvc.perform(MockMvcRequestBuilders.delete("/api/flights/{id}", flightId)
//                        .with(request -> {
//                            System.out.println("Request Attributes: " + request.getAttributeNames());
//                            request.setAttribute("flightController", nonAdminFlightController);
//                            return request;
//                        }))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("Permission denied. Only admin can delete flights."));
//
//        verify(flightService, never()).deleteFlightById(flightId);
//
//        // Test with admin user
//        FlightControllerProxy adminFlightController = new FlightControllerProxy(flightController, "admin");
//
//        mockMvc.perform(MockMvcRequestBuilders.delete("/api/flights/{id}", flightId)
//                        .with(request -> {
//                            System.out.println("Request Attributes: " + request.getAttributeNames());
//                            request.setAttribute("flightController", adminFlightController);
//                            return request;
//                        }))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().string("Flight deleted successfully!"));
//
//        verify(flightService, times(1)).deleteFlightById(flightId);
//    }


}

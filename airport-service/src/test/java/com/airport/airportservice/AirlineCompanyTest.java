package com.airport.airportservice;

import com.airport.airportservice.controller.AirlineCompanyController;
import com.airport.airportservice.entity.AirlineCompany;
import com.airport.airportservice.service.AirlineCompanyService;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class AirlineCompanyTest {

    @Mock
    private AirlineCompanyService airlineCompanyService;

    @InjectMocks
    private AirlineCompanyController airlineCompanyController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(airlineCompanyController).build();
    }


    @Test
    public void getAllAirlines_ReturnsAirlineList() {
        List<AirlineCompany> expectedAirlines = Arrays.asList(
                new AirlineCompany(1L, "Airline A", 10),
                new AirlineCompany(2L, "Airline B", 15)
        );

        when(airlineCompanyService.getAllAirlines()).thenReturn(expectedAirlines);

        List<AirlineCompany> actualAirlines = airlineCompanyController.getAllAirlines();

        assertEquals(expectedAirlines, actualAirlines);

        verify(airlineCompanyService, times(1)).getAllAirlines();
    }

    @Test
    public void addAirlineCompany_ReturnsAddedAirlineCompany() {
        AirlineCompany newAirlineCompany = new AirlineCompany(null, "New Airline", 20);
        AirlineCompany savedAirlineCompany = new AirlineCompany(1L, "New Airline", 20);

        when(airlineCompanyService.addAirlineCompany(newAirlineCompany)).thenReturn(savedAirlineCompany);

        AirlineCompany returnedAirlineCompany = airlineCompanyController.addAirlineCompany(newAirlineCompany);

        assertEquals(savedAirlineCompany, returnedAirlineCompany);

        verify(airlineCompanyService, times(1)).addAirlineCompany(newAirlineCompany);
    }
    @Test
    public void getAirlineById_ReturnsAirlineCompany() throws Exception {
        Long airlineCompanyId = 1L;
        AirlineCompany airlineCompany = new AirlineCompany(airlineCompanyId, "Airline A", 10);

        when(airlineCompanyService.getAirlineById(airlineCompanyId)).thenReturn(Optional.of(airlineCompany));

        Optional<AirlineCompany> actualAirline = airlineCompanyController.getAirlineById(airlineCompanyId);

        assertTrue(actualAirline.isPresent());
        assertEquals(airlineCompany, actualAirline.get());

        verify(airlineCompanyService, times(1)).getAirlineById(airlineCompanyId);
    }

    @Test
    public void deleteAirlineById_Success() throws Exception {
        Long airlineCompanyId = 1L;

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/airline companies/{id}", airlineCompanyId))
                .andExpect(MockMvcResultMatchers.status().isOk());

        verify(airlineCompanyService, times(1)).deleteAirlineById(airlineCompanyId);
    }
}


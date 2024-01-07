package com.airport.airportservice.controller;

import com.airport.airportservice.entity.BoardingGate;
import com.airport.airportservice.service.BoardingGateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/boarding gates")
public class BoardingGateController {
    private final BoardingGateService boardingGateService;

    @Autowired
    public BoardingGateController(BoardingGateService boardingGateService){
        this.boardingGateService = boardingGateService;
    }

    @GetMapping
    public List<BoardingGate> getAllBoardingGates(){
        return boardingGateService.getAllBoardingGates();
    }

    @PostMapping
    public BoardingGate addBoardingGate(@RequestBody BoardingGate boardingGate){
        return boardingGateService.addBoardingGate(boardingGate);
    }

    @GetMapping("/{id}")
    public Optional<BoardingGate> getBoardingGateById(@PathVariable Long id){
        return boardingGateService.getBoardingGateById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBoardingGateById(@PathVariable Long id){
        boardingGateService.deleteBoardingGateById(id);
    }
}


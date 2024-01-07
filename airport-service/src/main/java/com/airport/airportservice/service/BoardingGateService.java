package com.airport.airportservice.service;

import com.airport.airportservice.entity.BoardingGate;
import com.airport.airportservice.repository.BoardingGateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardingGateService {
    private final BoardingGateRepository boardingGateRepository;

    @Autowired
    public BoardingGateService(BoardingGateRepository boardingGateRepository) {
        this.boardingGateRepository = boardingGateRepository;
    }

    public List<BoardingGate> getAllBoardingGates(){
        return boardingGateRepository.findAll();
    }

    public BoardingGate addBoardingGate(BoardingGate boardingGate){
        return boardingGateRepository.save(boardingGate);
    }

    public Optional<BoardingGate> getBoardingGateById(Long id){
        return boardingGateRepository.findById(id);
    }

    public void deleteBoardingGateById(Long id){
        boardingGateRepository.deleteById(id);
    }
}

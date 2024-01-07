package com.airport.airportservice.service;

import com.airport.airportservice.entity.SecurityCheck;
import com.airport.airportservice.repository.SecurityCheckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecurityCheckService {
    private final SecurityCheckRepository securityCheckRepository;

    @Autowired
    public SecurityCheckService(SecurityCheckRepository securityCheckRepository) {
        this.securityCheckRepository = securityCheckRepository;
    }

    public List<SecurityCheck> getAllSecurityChecks() {
        return securityCheckRepository.findAll();
    }

    public SecurityCheck addSecurityCheck(SecurityCheck securityCheck) {
        return securityCheckRepository.save(securityCheck);
    }

    public Optional<SecurityCheck> getSecurityCheckById(Long id) {
        return securityCheckRepository.findById(id);
    }

    public void deleteSecurityCheckById(Long id) {
        securityCheckRepository.deleteById(id);
    }
}

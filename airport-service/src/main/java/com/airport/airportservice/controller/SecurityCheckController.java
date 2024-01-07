package com.airport.airportservice.controller;

import com.airport.airportservice.entity.SecurityCheck;
import com.airport.airportservice.service.SecurityCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/security-checks")
public class SecurityCheckController {

    private final SecurityCheckService securityCheckService;

    @Autowired
    public SecurityCheckController(SecurityCheckService securityCheckService) {
        this.securityCheckService = securityCheckService;
    }

    @GetMapping
    public List<SecurityCheck> getAllSecurityChecks() {
        return securityCheckService.getAllSecurityChecks();
    }

    @PostMapping
    public SecurityCheck addSecurityCheck(@RequestBody SecurityCheck securityCheck) {
        return securityCheckService.addSecurityCheck(securityCheck);
    }

    @GetMapping("/{id}")
    public Optional<SecurityCheck> getSecurityCheck(@PathVariable Long id) {
        return securityCheckService.getSecurityCheckById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSecurityCheckById(@PathVariable Long id) {
        securityCheckService.deleteSecurityCheckById(id);
    }
}

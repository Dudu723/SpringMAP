package com.airport.airportservice.controller;

import com.airport.airportservice.entity.Staff;
import com.airport.airportservice.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/staff")
public class StaffController {

    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @PostMapping
    public Staff addStaff(@RequestBody Staff staff) {
        return staffService.addStaff(staff);
    }

    @GetMapping("/{id}")
    public Optional<Staff> getStaff(@PathVariable Long id) {
        return staffService.getStaffById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStaffById(@PathVariable Long id) {
        staffService.deleteStaffById(id);
    }
}

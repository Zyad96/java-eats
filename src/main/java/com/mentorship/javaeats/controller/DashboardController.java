package com.mentorship.javaeats.controller;

import com.mentorship.javaeats.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class DashboardController {

    private final CustomerService customerService;

    public DashboardController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/active")
    public ResponseEntity<Long> countActiveCustomers() {
        return customerService.countActiveCustomers();
    }



}

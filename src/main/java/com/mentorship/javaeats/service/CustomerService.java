package com.mentorship.javaeats.service;

import org.springframework.http.ResponseEntity;

public interface CustomerService {
    public ResponseEntity<String> countAllCustomers();
}

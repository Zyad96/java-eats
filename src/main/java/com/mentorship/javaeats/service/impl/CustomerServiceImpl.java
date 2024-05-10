package com.mentorship.javaeats.service.impl;

import com.mentorship.javaeats.repository.CustomerRepository;
import com.mentorship.javaeats.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseEntity<Long> countActiveCustomers() {
        try {
            Long count = getActiveCustomersCount();
            return ResponseEntity.status(HttpStatus.OK).body(count);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // get active customers count from the database
    private Long getActiveCustomersCount() {
        return customerRepository.countByIsDeletedFalse();
    }
}

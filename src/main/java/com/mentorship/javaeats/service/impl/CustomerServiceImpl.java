package com.mentorship.javaeats.service.impl;

import com.mentorship.javaeats.repository.CustomerRepository;
import com.mentorship.javaeats.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;

    @Autowired
    public  CustomerServiceImpl (CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }
    @Override
    public ResponseEntity<String> countAllCustomers() {
        String count = customerRepository.countAllCustomers().toString();
        if (!count.isEmpty()){
            return ResponseEntity.ok(count);
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There is No Users Yet");
    }
}

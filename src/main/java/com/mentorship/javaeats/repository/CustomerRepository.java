package com.mentorship.javaeats.repository;


import com.mentorship.javaeats.model.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
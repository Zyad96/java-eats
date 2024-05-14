package com.mentorship.javaeats.repository;


import com.mentorship.javaeats.model.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Long countByIsDeletedFalse();
    @Query("Select COUNT(c) from Customer c")
    Long countAllCustomers();
}
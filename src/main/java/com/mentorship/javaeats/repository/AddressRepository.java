package com.mentorship.javaeats.repository;


import com.mentorship.javaeats.model.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
package com.mentorship.javaeats.repository;


import com.mentorship.javaeats.model.Entity.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
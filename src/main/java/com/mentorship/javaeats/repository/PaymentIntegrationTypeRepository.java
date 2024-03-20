package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.PaymentIntegrationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentIntegrationTypeRepository extends JpaRepository<PaymentIntegrationType, Integer> {
}
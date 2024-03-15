package com.mentorproject1.repository;

import com.mentorproject1.entity.PaymentIntegrationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PaymentIntegrationTypeRepository extends JpaRepository<PaymentIntegrationType, Integer>, JpaSpecificationExecutor<PaymentIntegrationType> {
}
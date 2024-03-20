package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.PaymentTypeConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTypeConfigurationRepository extends JpaRepository<PaymentTypeConfiguration, Integer> {
}
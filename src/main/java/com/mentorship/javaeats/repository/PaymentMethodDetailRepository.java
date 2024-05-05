package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.Entity.PaymentMethodDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodDetailRepository extends JpaRepository<PaymentMethodDetail, Long> {
}
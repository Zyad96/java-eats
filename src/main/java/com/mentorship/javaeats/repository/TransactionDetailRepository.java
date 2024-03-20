package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDetailRepository extends JpaRepository<TransactionDetail, Integer> {
}
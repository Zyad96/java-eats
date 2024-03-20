package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionStatusRepository extends JpaRepository<TransactionStatus, Integer> {
}
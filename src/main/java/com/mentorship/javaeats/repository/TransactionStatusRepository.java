package com.mentorship.javaeats.repository;


import com.mentorship.javaeats.model.Entity.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionStatusRepository extends JpaRepository<TransactionStatus, Long> {
}
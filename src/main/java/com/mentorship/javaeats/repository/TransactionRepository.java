package com.mentorship.javaeats.repository;


import com.mentorship.javaeats.model.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
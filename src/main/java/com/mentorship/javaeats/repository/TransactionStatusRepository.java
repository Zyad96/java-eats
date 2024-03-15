package com.mentorproject1.repository;

import com.mentorproject1.entity.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TransactionStatusRepository extends JpaRepository<TransactionStatus, Integer>, JpaSpecificationExecutor<TransactionStatus> {
}
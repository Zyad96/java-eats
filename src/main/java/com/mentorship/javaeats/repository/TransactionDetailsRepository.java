package com.mentorproject1.repository;

import com.mentorproject1.entity.TransactionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Integer>, JpaSpecificationExecutor<TransactionDetails> {
}
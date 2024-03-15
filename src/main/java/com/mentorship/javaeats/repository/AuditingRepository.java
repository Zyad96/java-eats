package com.mentorproject1.repository;

import com.mentorproject1.entity.Auditing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AuditingRepository extends JpaRepository<Auditing, Integer>, JpaSpecificationExecutor<Auditing> {
}
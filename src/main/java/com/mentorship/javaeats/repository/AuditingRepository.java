package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.Auditing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditingRepository extends JpaRepository<Auditing, Integer> {
}
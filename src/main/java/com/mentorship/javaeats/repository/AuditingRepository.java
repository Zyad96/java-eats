package com.mentorship.javaeats.repository;


import com.mentorship.javaeats.model.Entity.Auditing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditingRepository extends JpaRepository<Auditing, Long> {
}
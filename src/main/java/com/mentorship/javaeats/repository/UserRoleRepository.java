package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
}
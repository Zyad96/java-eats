package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
package com.mentorship.javaeats.repository;


import com.mentorship.javaeats.model.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
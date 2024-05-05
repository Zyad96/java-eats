package com.mentorship.javaeats.repository;


import com.mentorship.javaeats.model.Entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeRepository extends JpaRepository<UserType, Long> {
}
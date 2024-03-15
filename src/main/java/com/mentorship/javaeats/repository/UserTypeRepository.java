package com.mentorproject1.repository;

import com.mentorproject1.entity.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserTypeRepository extends JpaRepository<UserType, Integer>, JpaSpecificationExecutor<UserType> {
}
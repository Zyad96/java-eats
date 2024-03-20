package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
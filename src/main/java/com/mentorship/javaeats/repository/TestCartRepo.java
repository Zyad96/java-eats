package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.TestCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestCartRepo extends JpaRepository<Integer, TestCart> {
}

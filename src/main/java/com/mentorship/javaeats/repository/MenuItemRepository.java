package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
    Optional<MenuItem> findByOrderItemsId(int orderItemId);
    Optional<MenuItem> findByMenuId(Integer menuId);

    List<MenuItem> findAllByMenuId(Integer menuId);

}
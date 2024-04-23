package com.mentorship.javaeats.service;

import com.mentorship.javaeats.dto.response.MenuItemResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface MenuService {
    public ResponseEntity<Void> deleteMenu(Integer menuId);
    public List<MenuItemResponse> searchMenuItems(Integer menuId);
}

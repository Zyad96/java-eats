package com.mentorship.javaeats.service;

import com.mentorship.javaeats.model.dto.response.MenuItemResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface MenuService {
    public ResponseEntity<String> deleteMenu(Long menuId, Long userId);
    public ResponseEntity<List<MenuItemResponse>> searchMenuItems(Long menuId);
}

package com.mentorship.javaeats.service.impl;

import com.mentorship.javaeats.dto.response.MenuItemResponse;
import com.mentorship.javaeats.model.Menu;
import com.mentorship.javaeats.model.MenuItem;
import com.mentorship.javaeats.repository.MenuItemRepository;
import com.mentorship.javaeats.repository.MenuRepository;
import com.mentorship.javaeats.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final MenuItemRepository menuItemRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository, MenuItemRepository menuItemRepository) {
        this.menuRepository = menuRepository;
        this.menuItemRepository = menuItemRepository;
    }

    @Override
    public ResponseEntity<Void> deleteMenu(Integer menuId) {
        try {
            deleteMenuInDatabase(menuId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new RuntimeException("Error deleting menu" + e);
        }
    }

    @Override
    public List<MenuItemResponse> searchMenuItems(Integer menuId) {
        try {
            return getMenuItems(menuId);
        } catch (Exception e) {
            throw new RuntimeException("Error searching menu items" + e);
        }
    }

    private List<MenuItemResponse> getMenuItems(Integer menuId) {
        List<MenuItem> menuItems = new ArrayList<>(menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found"))
                .getMenuItems());
        List<MenuItemResponse> menuItemResponses = menuItems.stream()
                .map(menuItem -> {
                    MenuItemResponse menuItemResponse = new MenuItemResponse(menuItem.getId(), menuItem.getName(), menuItem.getDescription(), menuItem.getPrice(), menuItem.getStatus(),
                            menuItem.getStockQuantity());
                    return menuItemResponse;
                })
                .collect(Collectors.toList());
        return menuItemResponses;
    }

    private void deleteMenuInDatabase(Integer menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found"));
        menuRepository.delete(menu);
    }
}

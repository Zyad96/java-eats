package com.mentorship.javaeats.controller;

import com.mentorship.javaeats.model.dto.response.MenuItemResponse;
import com.mentorship.javaeats.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/menus")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @DeleteMapping("/{menuId}/{userId}/delete")
    public ResponseEntity<String> deleteMenu(@PathVariable Long menuId, @PathVariable Long userId){
        return menuService.deleteMenu(menuId, userId);
    }

    @GetMapping("/{menuId}/search")
    public ResponseEntity<List<MenuItemResponse>> searchMenuItems(@PathVariable Long menuId){
        return menuService.searchMenuItems(menuId);
    }
}
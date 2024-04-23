package com.mentorship.javaeats.controller;

import com.mentorship.javaeats.dto.response.MenuItemResponse;
import com.mentorship.javaeats.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @DeleteMapping("/{menuId}/delete")
    public void deleteMenu(@PathVariable Integer menuId){
        menuService.deleteMenu(menuId);
    }

    @GetMapping("/{menuId}/search")
    public List<MenuItemResponse> searchMenuItems(@PathVariable Integer menuId){
        return menuService.searchMenuItems(menuId);
    }
}

package com.mentorship.javaeats.service.impl;

import com.mentorship.javaeats.model.Entity.*;
import com.mentorship.javaeats.model.dto.response.MenuItemResponse;
import com.mentorship.javaeats.repository.*;
import com.mentorship.javaeats.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final MenuItemRepository menuItemRepository;
    private final UserRepository userRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderItemRepository orderItemRepository;
    private final RestaurantRepository restaurantRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public MenuServiceImpl(MenuRepository menuRepository, MenuItemRepository menuItemRepository, UserRepository userRepository, CartItemRepository cartItemRepository, OrderItemRepository orderItemRepository, RestaurantRepository restaurantRepository, IngredientRepository ingredientRepository) {
        this.menuRepository = menuRepository;
        this.menuItemRepository = menuItemRepository;
        this.userRepository = userRepository;
        this.cartItemRepository = cartItemRepository;
        this.orderItemRepository = orderItemRepository;
        this.restaurantRepository = restaurantRepository;
        this.ingredientRepository = ingredientRepository;
    }

//    @Transactional
    @Override
    public ResponseEntity<String> deleteMenu(Long menuId, Long userId) {
        try {
            if(validateUserRole(userId)){
                if(validateMenu(menuId)) {
                    deleteMenuInDatabase(menuId);
                    return ResponseEntity.status(HttpStatus.OK).body("Menu successfully deleted");
                }
                else {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Menu not found");
                }
            }
            else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User not authorized to delete menu");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error deleting menu" + e);
        }
    }

    @Override
    public ResponseEntity<List<MenuItemResponse>> searchMenuItems(Long menuId) {
        try {
            if(validateMenu(menuId)) {
                return ResponseEntity.status(HttpStatus.OK).body(getMenuItems(menuId));
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // check if menu exists
    private boolean validateMenu(Long menuId) {
        return menuRepository.findById(menuId).isPresent();
    }

    // check if user is admin
    private boolean validateUserRole(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"))
                .getRoles()
                .stream()
                .anyMatch(role -> role.getName().equals("Admin"));
    }

    // delete menu from database
    public void deleteMenuInDatabase(Long menuId) {
        Menu menu = menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found"));
        Set<MenuItem> menuItems = menu.getMenuItems();
        updateRestaurantMenu(menu);
        deleteRelatedMenuItems(menuItems);
        menuRepository.delete(menu);
    }

    // remove menu from restaurant
    private void updateRestaurantMenu(Menu menu) {
        restaurantRepository.findByMenu(menu)
                .ifPresent(restaurant -> {
                    restaurant.setMenu(null);
                    restaurantRepository.save(restaurant);
                });
    }

    // delete related menu items
    private void deleteRelatedMenuItems(Set<MenuItem> menuItems) {
        menuItems.forEach(menuItem -> {
            deleteRelatedCartItem(menuItem);
            deleteRelatedIngredients(menuItem);
            deleteRelatedOrderItem(menuItem);
            menuItemRepository.deleteById(menuItem.getId());
        });
    }

    // delete related cart item
    private void deleteRelatedCartItem(MenuItem menuItem) {
        CartItem cartItem = cartItemRepository.findByMenuItem(menuItem)
                .orElseThrow(() -> new RuntimeException("Cart item not found"));
        cartItemRepository.delete(cartItem);
    }

    // delete related ingredients of menu item
    private void deleteRelatedIngredients(MenuItem menuItem) {
        Set<Ingredient> ingredients = menuItem.getIngredients();
        menuItem.getIngredients().clear();
        ingredientRepository.deleteAll(ingredients);
    }

    // delete related order item
    private void deleteRelatedOrderItem(MenuItem menuItem) {
        Set<OrderItem> orderItems = orderItemRepository.findAllByMenuItem(menuItem);
        orderItems.forEach(orderItem -> {
            orderItem.setMenuItem(null);
            orderItemRepository.save(orderItem);
        });
    }

    // get menu items of a menu by menu id and return as list of MenuItemResponse
    private List<MenuItemResponse> getMenuItems(Long menuId) {
        List<MenuItem> menuItems = new ArrayList<>(menuRepository.findById(menuId)
                .orElseThrow(() -> new RuntimeException("Menu not found"))
                .getMenuItems());
        List<MenuItemResponse> menuItemResponseSet = menuItems.stream()
                .map(menuItem -> {
                    MenuItemResponse menuItemResponse = new MenuItemResponse(menuItem.getName(),
                            menuItem.getDescription(), menuItem.getPrice());
                    return menuItemResponse;
                })
                .collect(Collectors.toList());
        return menuItemResponseSet;
    }


}

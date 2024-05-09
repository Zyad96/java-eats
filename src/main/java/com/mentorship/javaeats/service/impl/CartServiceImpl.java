package com.mentorship.javaeats.service.impl;


import com.mentorship.javaeats.model.Entity.Cart;
import com.mentorship.javaeats.model.Entity.CartItem;
import com.mentorship.javaeats.model.dto.request.CartItemRequest;
import com.mentorship.javaeats.model.dto.response.CartItemResponse;
import com.mentorship.javaeats.repository.CartItemRepository;
import com.mentorship.javaeats.repository.CartRepository;
import com.mentorship.javaeats.repository.CustomerRepository;
import com.mentorship.javaeats.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public CartServiceImpl(CartItemRepository cartItemRepository, CartRepository cartRepository, CustomerRepository customerRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public ResponseEntity<String> updateCartItemQuantity(Long cartId, CartItemRequest cartItemRequest) {
        try {
            if (validateCartExist(cartId)) {
                if (validateCartItemId(cartItemRequest)) {
                    CartItem existingCartItem = cartItemRepository.findById(cartItemRequest.getId()).orElseThrow(() -> new IllegalArgumentException("Cart Item not found"));
                    updateItemQuantity(existingCartItem, cartItemRequest);
                    return ResponseEntity.status(HttpStatus.OK).body("Cart item quantity updated successfully");
                } else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cart Item not found in the Cart");
                }
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cart not found");
            }
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<Set<CartItemResponse>> viewCartItems(Long customerId) {
        try {
            if (validateCustomer(customerId)) {
                if (validateCartExist(getCartByCustomerId(customerId).getId())) {
                    Cart cart = getCartByCustomerId(customerId);
                    Set<CartItem> cartItems = cart.getCartItems();
                    Set<CartItemResponse> cartItemResponses = getCartItemResponses(cartItems);
                    return ResponseEntity.status(HttpStatus.OK).body(cartItemResponses);
                } else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
                }
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<String> clearAllCartItems(Long cartId) {
        try {
            if (validateCartExist(cartId)) {
                Cart cart = getCart(cartId);
                Set<CartItem> cartItems = cart.getCartItems();
                deleteCartItems(cartItems, cart);
                return ResponseEntity.status(HttpStatus.OK).body("Cart items cleared successfully");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cart not found");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while clearing cart items");
        }
    }

    @Override
    public String addToCart(Long menuItemId, Long userId) {
        return null;
    }

    // validate if cart exists
    private boolean validateCartExist(Long cartId) {
        return cartRepository.existsById(cartId);
    }

    // validate cart item request info
    private boolean validateCartItemId(CartItemRequest cartItemRequest) {
        CartItem cartItem = cartItemRepository.findById(cartItemRequest.getId()).orElseThrow(() -> new IllegalArgumentException("Cart Item not found"));
        return validateCartItemInfo(cartItem, cartItemRequest);
    }

    // validate cart item info
    private boolean validateCartItemInfo(CartItem cartItem, CartItemRequest cartItemRequest) {
        return cartItem != null &&
                        cartItem.getMenuItem().getId().equals(cartItemRequest.getMenuItemId()) &&
                        cartItem.getUnitPrice().equals(cartItemRequest.getUnitPrice());
    }

    // update cart item quantity
    private void updateItemQuantity(CartItem existingCartItem, CartItemRequest cartItemRequest) {
        if (existingCartItem != null) {
            existingCartItem.setQuantity(cartItemRequest.getQuantity());
            existingCartItem.setUnitPrice(cartItemRequest.getUnitPrice());
            cartItemRepository.save(existingCartItem);
        } else {
            throw new IllegalArgumentException("Cart Item not found in the Cart");
        }
    }

    // validate customer existence
    private boolean validateCustomer(Long customerId) {
        return customerRepository.existsById(customerId);
    }

    // get cart by customer id
    private Cart getCartByCustomerId(Long customerId) {
        return cartRepository.findById(customerRepository.findById(customerId).get().getCart().getId()).orElseThrow(() -> new IllegalArgumentException("Cart not found"));
    }

    // get cart item responses
    private static Set<CartItemResponse> getCartItemResponses(Set<CartItem> cartItems) {
        Set<CartItemResponse> cartItemResponses = cartItems.stream().map(cartItem -> {
            CartItemResponse cartItemResponse = new CartItemResponse();
            cartItemResponse.setItemName(cartItem.getMenuItem().getName());
            cartItemResponse.setItemDescription(cartItem.getMenuItem().getDescription());
            cartItemResponse.setQuantity(cartItem.getQuantity());
            cartItemResponse.setUnitPrice(cartItem.getUnitPrice());
            cartItemResponse.setTotalPrice(cartItem.getTotalPrice());
            return cartItemResponse;
        }).collect(Collectors.toSet());
        return cartItemResponses;
    }

    // delete cart items from cart
    private void deleteCartItems(Set<CartItem> cartItems, Cart cart) {
        cartItemRepository.deleteAll(cartItems);
        cart.getCartItems().clear();
        cartRepository.save(cart);
    }

    // get cart by id
    private Cart getCart(Long cartId) {
        return cartRepository.findById(cartId).orElseThrow(() -> new IllegalArgumentException("Cart not found"));
    }
}
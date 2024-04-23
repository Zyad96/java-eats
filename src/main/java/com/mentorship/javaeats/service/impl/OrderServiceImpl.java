package com.mentorship.javaeats.service.impl;

import com.mentorship.javaeats.model.*;
import com.mentorship.javaeats.repository.*;
import com.mentorship.javaeats.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;
    private final MenuItemRepository menuItemRepository;
    private final OrderItemRepository orderItemRepository;
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
    private final EmailServiceImpl emailService;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, MenuItemRepository menuItemRepository, OrderItemRepository orderItemRepository, EmailServiceImpl emailService, UserRepository userRepository, CustomerRepository customerRepository, CartItemRepository cartItemRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.menuItemRepository = menuItemRepository;
        this.orderItemRepository = orderItemRepository;
        this.emailService = emailService;
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public void placeOrder(Integer customerId, Integer cartId, Set<CartItem> cartItems) {
        try {
            if (validateUserSelectedItems(cartItems)) {
                if (checkInventory(cartItems)) {
                    Order order = createOrder(customerId, cartItems);
                    saveOrderItems(order);
                    updateInventory(cartItems);
                    notifyUser(getUserEmail(customerId), "Order Placed Successfully!", "Order placed successfully\n" + "Thank you for your order!");
                    clearCart(cartId);
                } else {
                    notifyUser(getUserEmail(customerId), "Order Failed!", "Order failed due to insufficient inventory\n" + "Please try again later.");
                }
            } else {
                notifyUser(getUserEmail(customerId), "Order Failed!", "Order failed due to invalid menu items\n" + "Please try again.");
            }
        } catch (Exception e) {
            notifyUser(getUserEmail(customerId), "Order Failed!", "Order failed due to an unexpected error:" + e);
        }
    }

    // Validate user selected items
    private boolean validateUserSelectedItems(Set<CartItem> cartItems) {
        for (CartItem item : cartItems) {
            MenuItem menuItem = getMenuItem(item.getId());
            if (menuItem == null) {
                return false;
            }
        }
        return true;
    }

    // check the inventory to see if the items are available
    private boolean checkInventory(Set<CartItem> cartItems) {
        for (CartItem item : cartItems) {
            MenuItem menuItem = getMenuItem(item.getId());
            if (menuItem.getStockQuantity() < item.getQuantity()) {
                return false;
            }
        }
        return true;
    }

    // create the order and save it to the database
    private Order createOrder(Integer customerId, Set<CartItem> cartItems) {
        Set<OrderItem> orderItems = new LinkedHashSet<>();
        for (CartItem item : cartItems) {
            orderItems.add(new OrderItem(item.getId(), item.getQuantity(), item.getUnitPrice(), "Pending"));
        }
        Order order = new Order(customerId, orderItems, 1, calculateSubtotal(cartItems), calculateTax(cartItems), calculateTotal(cartItems));
        return orderRepository.save(order);
    }

    // save the order items to the database
    private void saveOrderItems(Order order) {
        Set<OrderItem> orderItems = order.getOrderItems();
        orderItemRepository.saveAll(orderItems);
    }

    // update the inventory after the order is placed
    private void updateInventory(Set<CartItem> cartItems) {
        for (CartItem item : cartItems) {
            MenuItem menuItem = getMenuItem(item.getId());
            menuItem.setStockQuantity(menuItem.getStockQuantity() - item.getQuantity());
            if (menuItem.getStockQuantity() == 0) {
                menuItem.setStatus("Not Available");
            }
            menuItemRepository.save(menuItem);
        }
    }

    // clear the cart after the order is placed
    private void clearCart(Integer cartId) {
        Cart cart = cartRepository.findById(cartId).get();
        // clear the cart items
        cart.getCartItems().clear();
        cartRepository.save(cart);
        // remove all the cart items
        cartItemRepository.deleteAll(cart.getCartItems());
    }

    // Notify user by email
    private void notifyUser(String userEmail, String subject, String message) {
        emailService.sendEmail(userEmail, subject, message);
    }

    // get the menu item by order item id
    private MenuItem getMenuItem(int orderItemId) {
        // correct
        return menuItemRepository.findByOrderItemsId(orderItemId).orElseThrow(() -> new RuntimeException("Menu item not found"));
    }

    // get the user email by customer id
    private String getUserEmail(Integer customerId) {
        // correct
        return userRepository.findByCustomerId(customerId).orElseThrow(() -> new RuntimeException("User not found")).getEmail();
    }

    private BigDecimal calculateSubtotal(Set<CartItem> cartItems) {
        BigDecimal subtotal = new BigDecimal(0);
        for (CartItem item : cartItems) {
            subtotal = subtotal.add(item.getUnitPrice().multiply(new BigDecimal(item.getQuantity())));
        }
        return subtotal;
    }

    private BigDecimal calculateTax(Set<CartItem> cartItems) {
        return calculateSubtotal(cartItems).multiply(new BigDecimal(0.06));
    }

    private BigDecimal calculateTotal(Set<CartItem> cartItems) {
        return calculateSubtotal(cartItems).add(calculateTax(cartItems));
    }

}

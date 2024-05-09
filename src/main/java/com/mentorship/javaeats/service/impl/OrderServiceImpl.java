package com.mentorship.javaeats.service.impl;

import com.mentorship.javaeats.model.Entity.*;
import com.mentorship.javaeats.model.dto.response.MenuItemResponse;
import com.mentorship.javaeats.model.dto.response.OrderSummaryResponse;
import com.mentorship.javaeats.repository.*;
import com.mentorship.javaeats.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {


    private final OrderRepository orderRepository;
    private final MenuItemRepository menuItemRepository;
    private final OrderItemRepository orderItemRepository;
    private final CustomerRepository customerRepository;
    private final EmailServiceImpl emailService;
    private final CartItemRepository cartItemRepository;
    private final CartRepository cartRepository;
    private final OrderTrackingRepository orderTrackingRepository;
    private final OrderStatusRepository orderStatusRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, MenuItemRepository menuItemRepository, OrderItemRepository orderItemRepository,
                            EmailServiceImpl emailService, CustomerRepository customerRepository, CartItemRepository cartItemRepository,
                            CartRepository cartRepository, OrderTrackingRepository orderTrackingRepository, OrderStatusRepository orderStatusRepository) {
        this.orderRepository = orderRepository;
        this.menuItemRepository = menuItemRepository;
        this.orderItemRepository = orderItemRepository;
        this.emailService = emailService;
        this.customerRepository = customerRepository;
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.orderTrackingRepository = orderTrackingRepository;
        this.orderStatusRepository = orderStatusRepository;
    }

    // TODO: implement payment simulation
    @Transactional
    @Override
    public ResponseEntity<String> placeOrder(Long customerId, Long cartId, Set<CartItem> cartItems) {
        try {
            if(checkCartIsLocked(cartId)) {
                if (validateUserSelectedItems(cartItems)) {
                    if (checkInventory(cartItems)) {
                        lockCart(cartId);
                        Order order = createOrder(customerId, cartItems);
                        saveOrderItems(order);
                        updateInventory(cartItems);
                        notifyUser(getUserEmail(customerId), "Order Placed Successfully!", "Order placed successfully\n" + "Thank you for your order!");
                        clearCart(cartId);
                        releaseCart(cartId);
                        return ResponseEntity.status(HttpStatus.OK).body("Order Placed Successfully!");
                    } else {
                        notifyUser(getUserEmail(customerId), "Order Failed!", "Order failed due to insufficient inventory\n" + "Please try again later.");
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order failed due to insufficient inventory");
                    }
                } else {
                    notifyUser(getUserEmail(customerId), "Order Failed!", "Order failed due to invalid menu items\n" + "Please try again.");
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order failed due to invalid menu items");

                }
            }else{
                notifyUser(getUserEmail(customerId), "Order Failed!", "Order failed due to an unexpected error\n" + "Please try again later.");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order failed due to an unexpected error (Cart is LOCKED)");
            }
        } catch (Exception e) {
            notifyUser(getUserEmail(customerId), "Order Failed!", "Order failed due to an unexpected error\n" + "Please try again later.");
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<OrderSummaryResponse> viewOrderSummary(Long customerId, Long orderId) {
        try {
            if(validateOrder(orderId)) {
                Order order = orderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Order not found"));
                Set<MenuItemResponse> menuItemResponseSet = getMenuItemResponses(order.getOrderItems());
                OrderSummaryResponse orderSummaryResponse = new OrderSummaryResponse(menuItemResponseSet, order.getTotal() , order.getOrderDate(), order.getOrderStatus().getName());
                return ResponseEntity.status(HttpStatus.OK).body(orderSummaryResponse);
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    // check if the cart is locked
    private boolean checkCartIsLocked(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        return cart.getStatus().equals("UNLOCKED");
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

    // lock the cart before placing the order
    private void lockCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.setStatus("LOCKED");
        cartRepository.save(cart);
    }

    // create the order
    private Order createOrder(Long customerId, Set<CartItem> cartItems) {
        OrderStatus orderStatus = orderStatusRepository.getOrderStatusByName("Placed");
        OrderTracking orderTracking = orderTrackingRepository.getOrderTrackingByCurrentLocation("Warehouse");
        Order order = new Order(calculateSubtotal(cartItems), calculateTax(cartItems), calculateTotal(cartItems),
                orderStatus, orderTracking);
        order = orderRepository.save(order);
        assignOrderItemsToOrder(cartItems, order);
        assignOrderToCustomer(customerId, order);
        return order;
    }

    // assign the order items to the order
    public void assignOrderItemsToOrder(Set<CartItem> cartItems, Order order) {
        Set<OrderItem> orderItems = new LinkedHashSet<>();
        for (CartItem item : cartItems) {
            MenuItem menuItem = getMenuItem(item.getId());
            OrderItem orderItem = new OrderItem(item.getQuantity(), item.getUnitPrice(), menuItem);
            orderItems.add(orderItem);
            orderItemRepository.save(orderItem);
        }
        order.setOrderItems(orderItems);
        orderRepository.save(order);
        saveOrderItems(order);
    }

    // assign the order to the customer
    private void assignOrderToCustomer(Long customerId, Order order) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        customer.getOrders().add(order);
        customerRepository.save(customer);
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
                menuItem.setIsVisible(false);
            }
            menuItemRepository.save(menuItem);
        }
    }

    // Notify user by email
    private void notifyUser(String userEmail, String subject, String message) {
        emailService.sendEmail(userEmail, subject, message);
    }

    // clear the cart after the order is placed
    private void clearCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        cartItemRepository.deleteAll(cart.getCartItems());
        cart.getCartItems().clear();
        cartRepository.save(cart);
    }

    // release the cart after the order is placed
    private void releaseCart(Long cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.setStatus("UNLOCKED");
        cartRepository.save(cart);
    }

    // validate the order
    private boolean validateOrder(Long orderId) {
        return orderRepository.findById(orderId).isPresent();
    }

    // get the menu item responses
    private Set<MenuItemResponse> getMenuItemResponses(Set<OrderItem> orderItems) {
        Set<MenuItemResponse> menuItemResponseSet = new LinkedHashSet<>();
        for (OrderItem item : orderItems){
            MenuItem menuItem = menuItemRepository.findById(item.getId()).orElseThrow(() -> new RuntimeException("MenuItem not found"));
            MenuItemResponse menuItemResponse = new MenuItemResponse(menuItem.getName(),
                    menuItem.getDescription(), menuItem.getPrice());
            menuItemResponseSet.add(menuItemResponse);
        }
        return menuItemResponseSet;
    }

    // get the menu item by order item id
    private MenuItem getMenuItem(Long orderItemId) {
        return menuItemRepository.findById(orderItemId).orElseThrow(() -> new RuntimeException("Menu item not found"));
    }

    // get the user email by customer id
    private String getUserEmail(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        return customer.getUser().getEmail();
    }

    // calculate the subtotal
    private BigDecimal calculateSubtotal(Set<CartItem> cartItems) {
        BigDecimal subtotal = new BigDecimal(0);
        for (CartItem item : cartItems) {
            subtotal = subtotal.add(item.getUnitPrice().multiply(new BigDecimal(item.getQuantity())));
        }
        return subtotal;
    }

    // calculate the tax
    private BigDecimal calculateTax(Set<CartItem> cartItems) {
        return calculateSubtotal(cartItems).multiply(new BigDecimal("0.06"));
    }

    // calculate the total
    private BigDecimal calculateTotal(Set<CartItem> cartItems) {
        return calculateSubtotal(cartItems).add(calculateTax(cartItems));
    }

}

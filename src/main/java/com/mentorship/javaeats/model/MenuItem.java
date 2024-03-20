package com.mentorship.javaeats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "menu_item")
public class MenuItem implements Serializable {
    private static final long serialVersionUID = -6693068862351378435L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_item_id", nullable = false)
    private Integer menu_item_id;

    @Column(name = "menu_id", nullable = false)
    private Integer menu_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_on", nullable = false)
    private Instant created_on;

    @Column(name = "updated_on", nullable = false)
    private Instant updated_on;

    @OneToMany(mappedBy = "menu_item_id")
    private Set<CartItem> cartItems = new LinkedHashSet<>();

    @OneToMany(mappedBy = "menu_item_id")
    private Set<MenuItemIngredient> menuItemIngredients = new LinkedHashSet<>();

    @OneToMany(mappedBy = "menu_item_id")
    private Set<OrderItem> orderItems = new LinkedHashSet<>();

    public Integer getMenu_item_id() {
        return menu_item_id;
    }

    public void setMenu_item_id(Integer menu_item_id) {
        this.menu_item_id = menu_item_id;
    }

    public Integer getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Instant getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Instant created_on) {
        this.created_on = created_on;
    }

    public Instant getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(Instant updated_on) {
        this.updated_on = updated_on;
    }

    public Set<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public Set<MenuItemIngredient> getMenuItemIngredients() {
        return menuItemIngredients;
    }

    public void setMenuItemIngredients(Set<MenuItemIngredient> menuItemIngredients) {
        this.menuItemIngredients = menuItemIngredients;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

}
package com.mentorship.javaeats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "cart_item")
public class CartItem implements Serializable {
    private static final long serialVersionUID = 7760796674048817633L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_item_id", nullable = false)
    private Integer cart_item_id;

    @Column(name = "cart_id", nullable = false)
    private Integer cart_id;

    @Column(name = "menu_item_id", nullable = false)
    private Integer menu_item_id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "created_on", nullable = false)
    private Instant created_on;

    @Column(name = "updated_on", nullable = false)
    private Instant updated_on;

    public Integer getCart_item_id() {
        return cart_item_id;
    }

    public void setCart_item_id(Integer cart_item_id) {
        this.cart_item_id = cart_item_id;
    }

    public Integer getCart_id() {
        return cart_id;
    }

    public void setCart_id(Integer cart_id) {
        this.cart_id = cart_id;
    }

    public Integer getMenu_item_id() {
        return menu_item_id;
    }

    public void setMenu_item_id(Integer menu_item_id) {
        this.menu_item_id = menu_item_id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

}
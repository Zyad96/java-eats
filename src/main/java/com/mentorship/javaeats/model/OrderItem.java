package com.mentorship.javaeats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = -2430065943374712760L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id", nullable = false)
    private Integer order_item_id;

    @Column(name = "order_id", nullable = false)
    private Integer order_id;

    @Column(name = "menu_item_id", nullable = false)
    private Integer menu_item_id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_on", nullable = false)
    private Instant created_on;

    @Column(name = "updated_on", nullable = false)
    private Instant updated_on;

    public Integer getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(Integer order_item_id) {
        this.order_item_id = order_item_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
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

}
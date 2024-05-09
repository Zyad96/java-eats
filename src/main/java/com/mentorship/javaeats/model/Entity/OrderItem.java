package com.mentorship.javaeats.model.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
@Data
@NoArgsConstructor
@Entity
@Table(name = "order_item", schema = "javaeat_lites")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = -2430065943374712760L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id", nullable = false)
    private Long id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @PrePersist
    protected void onCreate() {
        createdOn = Instant.now();
    }

    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;

    public OrderItem(Integer quantity, BigDecimal price, MenuItem menuItem) {
        this.quantity = quantity;
        this.price = price;
        this.menuItem = menuItem;
    }
}
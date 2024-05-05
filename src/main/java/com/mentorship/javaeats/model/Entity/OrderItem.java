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

    @OneToOne
    @JoinColumn(name = "order_item_id")
    @MapsId
    private MenuItem menuItem;

    public OrderItem(Long id, Integer quantity, BigDecimal price) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }
}
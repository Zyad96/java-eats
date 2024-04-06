package com.mentorship.javaeats.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

@Data
@Entity
@Table(name = "cart", schema = "javaeat_lites")
public class Cart implements Serializable {
    private static final long serialVersionUID = 1089589191180862750L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id", nullable = false)
    private Integer id;

    @Column(name = "subtotal", nullable = false)
    private BigDecimal subtotal;

    @Column(name = "tax", nullable = false)
    private BigDecimal tax;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @Column(name = "updated_on", nullable = false)
    private Instant updatedOn;

    @PrePersist
    protected void onCreate() {
        createdOn = Instant.now();
        updatedOn = Instant.now();
    }

    @OneToMany
    @JoinColumn(name = "cart_items_id")
    private Set<CartItem> cartItems;

    public CartItem getCartItem(int cartItemId){
        for(CartItem item : cartItems){
            if (item.getId() == cartItemId){
                return item;
            }
        }
        return null;
    }
}
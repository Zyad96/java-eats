package com.mentorship.javaeats.model.Entity;

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
    private Long id;

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


    @PrePersist
    @PreUpdate
    protected void onCreate() {
        createdOn = Instant.now();
        this.tax = this.subtotal.multiply(BigDecimal.valueOf(0.14));
        this.total = this.subtotal.add(this.tax);
    }

    @OneToMany
    @JoinColumn(name="cart_id")
    private Set<CartItem> cartItems;

}
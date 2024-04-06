package com.mentorship.javaeats.model;

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
    private Integer id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

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

}
package com.mentorship.javaeats.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"order\"", schema = "javaeat_lites")
public class Order implements Serializable {
    private static final long serialVersionUID = 5237255932579833792L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Integer id;

    @Column(name = "order_date", nullable = false)
    private Instant orderDate;

    @Column(name = "subtotal", nullable = false)
    private BigDecimal subtotal;

    @Column(name = "tax", nullable = false)
    private BigDecimal tax;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @Column(name = "updated_on", nullable = false)
    private Instant updatedOn;

    public Order(Integer customerId, Set<OrderItem> orderItems, int i, BigDecimal subtotal, BigDecimal tax, BigDecimal total) {
        this.id = customerId;
        this.orderItems = orderItems;
        this.subtotal = subtotal;
        this.tax = tax;
        this.total = total;
    }

    @PrePersist
    protected void onCreate() {
        createdOn = Instant.now();
        updatedOn = Instant.now();
        orderDate = LocalDate.now().atStartOfDay().toInstant(ZoneOffset.UTC);
    }

    @OneToMany
    @JoinColumn(name = "order_id")
    private Set<OrderItem> orderItems;

    @OneToMany
    @JoinColumn(name = "order_id")
    private Set<OrderTracking> orderTrackings;

    @OneToMany
    @JoinColumn(name = "order_id")
    private Set<Transaction> transactions;

}
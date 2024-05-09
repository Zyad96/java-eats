package com.mentorship.javaeats.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;
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
    private Long id;

    @Column(name = "order_date", nullable = false)
    private Instant orderDate;

    @Column(name = "subtotal", nullable = false)
    private BigDecimal subtotal;

    @Column(name = "tax", nullable = false)
    @Formula("subtotal * 0.14")
    private BigDecimal tax;

    @Column(name = "total", nullable = false)
    @Formula("subtotal + tax")
    private BigDecimal total;

    public Order(BigDecimal subtotal, BigDecimal tax, BigDecimal total, OrderStatus orderStatus ,OrderTracking orderTracking){
        this.subtotal = subtotal;
        this.tax = tax;
        this.total = total;
        this.orderStatus = orderStatus;
        this.orderTracking = orderTracking;
    }

    @PrePersist
    @PreUpdate
    protected void onCreate() {
        orderDate = Instant.now();
        if(orderTracking != null) {
            orderTracking.setEstimatedDeliveryTime(generateEstimatedDeliveryTime());
        }
    }

    @OneToMany
    @JoinColumn(name = "order_id")
    private Set<OrderItem> orderItems;

    @OneToOne
    @JoinColumn(name = "order_tracking_id")
    private OrderTracking orderTracking;

    @OneToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    @OneToOne
    @JoinColumn(name = "order_status_id")
    private OrderStatus orderStatus;

    private Duration generateEstimatedDeliveryTime() {
        Random random = new Random();
        int randomMinutes = random.nextInt(31) + 30;
        return Duration.ofMinutes(randomMinutes);
    }
}
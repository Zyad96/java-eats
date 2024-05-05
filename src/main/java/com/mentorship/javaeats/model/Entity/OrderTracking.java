package com.mentorship.javaeats.model.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Duration;

@Data
@Entity
@Table(name = "order_tracking", schema = "javaeat_lites")
public class OrderTracking implements Serializable {
    private static final long serialVersionUID = 667587576458909021L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_tracking_id", nullable = false)
    private Long id;

    @Column(name = "current_location", nullable = false)
    private String currentLocation;

    @Column(name = "estimated_delivery_time", nullable = false)
    private Duration estimatedDeliveryTime;
}
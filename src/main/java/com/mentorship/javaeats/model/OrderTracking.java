package com.mentorship.javaeats.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@Table(name = "order_tracking", schema = "javaeat_lites")
public class OrderTracking implements Serializable {
    private static final long serialVersionUID = 667587576458909021L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_tracking_id", nullable = false)
    private Integer id;

    @Column(name = "current_location", nullable = false)
    private String currentLocation;

    @Column(name = "estimated_delivery_time", nullable = false)
    private Instant estimatedDeliveryTime;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @Column(name = "updated_on", nullable = false)
    private Instant updatedOn;

}
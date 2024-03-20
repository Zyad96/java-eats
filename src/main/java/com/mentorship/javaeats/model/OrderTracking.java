package com.mentorship.javaeats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "order_tracking")
public class OrderTracking implements Serializable {
    private static final long serialVersionUID = 667587576458909021L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_tracking_id", nullable = false)
    private Integer order_tracking_id;

    @Column(name = "order_id", nullable = false)
    private Integer order_id;

    @Column(name = "current_location", nullable = false)
    private String current_location;

    @Column(name = "estimated_delivery_time", nullable = false)
    private Instant estimated_delivery_time;

    @Column(name = "created_on", nullable = false)
    private Instant created_on;

    @Column(name = "updated_on", nullable = false)
    private Instant updated_on;

    public Integer getOrder_tracking_id() {
        return order_tracking_id;
    }

    public void setOrder_tracking_id(Integer order_tracking_id) {
        this.order_tracking_id = order_tracking_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public String getCurrent_location() {
        return current_location;
    }

    public void setCurrent_location(String current_location) {
        this.current_location = current_location;
    }

    public Instant getEstimated_delivery_time() {
        return estimated_delivery_time;
    }

    public void setEstimated_delivery_time(Instant estimated_delivery_time) {
        this.estimated_delivery_time = estimated_delivery_time;
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
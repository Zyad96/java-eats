package com.mentorship.javaeats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "restaurant_details")
public class RestaurantDetail implements Serializable {
    private static final long serialVersionUID = -8515585211479392563L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_details_id", nullable = false)
    private Integer restaurant_details_id;

    @Column(name = "restaurant_id", nullable = false)
    private Integer restaurant_id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "created_on", nullable = false)
    private Instant created_on;

    @Column(name = "updated_on", nullable = false)
    private Instant updated_on;

    public Integer getRestaurant_details_id() {
        return restaurant_details_id;
    }

    public void setRestaurant_details_id(Integer restaurant_details_id) {
        this.restaurant_details_id = restaurant_details_id;
    }

    public Integer getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Integer restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
package com.mentorship.javaeats.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@Data
@Entity
@Table(name = "restaurant_details", schema = "javaeat_lites")
public class RestaurantDetail implements Serializable {
    private static final long serialVersionUID = -8515585211479392563L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_details_id", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @Column(name = "updated_on", nullable = false)
    private Instant updatedOn;

    @PrePersist
    protected void onCreate() {
        createdOn = Instant.now();
        updatedOn = Instant.now();
    }

    public RestaurantDetail(String description) {
        this.description = description;
    }

}
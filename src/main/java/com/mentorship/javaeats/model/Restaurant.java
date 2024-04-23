package com.mentorship.javaeats.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@NoArgsConstructor
@Data
@Entity
@Table(name = "restaurant", schema = "javaeat_lites")
public class Restaurant implements Serializable {
    private static final long serialVersionUID = -8307263283547156031L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

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
    @JoinColumn(name = "restaurant_id")
    private Set<Menu> menus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_id")
    private RestaurantDetail restaurantDetails;

    public Restaurant(String name, String status) {
        this.name = name;
        this.status = status;
    }
}
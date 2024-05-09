package com.mentorship.javaeats.model.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@NoArgsConstructor
@Data
@Entity
@Table(name = "restaurant", schema = "javaeat_lites")
public class Restaurant implements Serializable {
    private static final long serialVersionUID = -8307263283547156031L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "status", nullable = false, columnDefinition = "varchar(255) default 'opened'")
    private String status;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @Column(name = "deleted_on", nullable = true)
    private Instant deletedOn;

    @PrePersist
    protected void onCreate() {
        createdOn = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        if(isDeleted) {
            deletedOn = Instant.now();
        }
    }

    @OneToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_detail_id")
    private RestaurantDetail restaurantDetail;

    public Restaurant(String name, String status) {
        this.name = name;
        this.status = status;
        this.isDeleted = false;
    }
}
package com.mentorship.javaeats.model.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Data
@Entity
@Table(name = "customer", schema = "javaeat_lites")
public class Customer implements Serializable {
    private static final long serialVersionUID = -8242597705528208474L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Long id;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @Column(name = "deleted_on", nullable = false)
    private Instant deletedOn;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "boolean default false")
    private Boolean isDeleted;

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

    @OneToMany
    @JoinColumn(name = "customer_id")
    private Set<Address> addresses;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToMany
    @JoinColumn(name = "customer_id")
    private Set<Order> orders;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "customer_id")
    private Set<PaymentMethod> paymentMethods;
}
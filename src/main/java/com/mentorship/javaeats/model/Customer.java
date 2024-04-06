package com.mentorship.javaeats.model;

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
    private Integer id;

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
    @JoinColumn(name = "address_id")
    private Set<Address> addresses;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToMany
    @JoinColumn(name = "order_id")
    private Set<Order> orders;

    @OneToOne
    @JoinColumn(name = "preferred_payment_setting_id")
    private PreferredPaymentSetting preferredPaymentSetting;
}
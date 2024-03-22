package com.mentorship.javaeats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "customer", schema = "javaeat_lites")
public class Customer implements Serializable {
    private static final long serialVersionUID = -8242597705528208474L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Integer id;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @Column(name = "updated_on", nullable = false)
    private Instant updatedOn;

    @OneToMany(mappedBy = "customerId")
    private Set<Address> addresses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customerId")
    private Set<Cart> carts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customerId")
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customerId")
    private Set<PreferredPaymentSetting> preferredPaymentSettings = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Instant getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Instant updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<PreferredPaymentSetting> getPreferredPaymentSettings() {
        return preferredPaymentSettings;
    }

    public void setPreferredPaymentSettings(Set<PreferredPaymentSetting> preferredPaymentSettings) {
        this.preferredPaymentSettings = preferredPaymentSettings;
    }

}
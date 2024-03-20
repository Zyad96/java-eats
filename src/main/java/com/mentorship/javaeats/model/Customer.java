package com.mentorship.javaeats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = -8242597705528208474L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Integer customer_id;

    @Column(name = "user_id", nullable = false)
    private Integer user_id;

    @Column(name = "created_on", nullable = false)
    private Instant created_on;

    @Column(name = "updated_on", nullable = false)
    private Instant updated_on;

    @OneToMany(mappedBy = "customer_id")
    private Set<Address> addresses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customer_id")
    private Set<Cart> carts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customer_id")
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customer_id")
    private Set<PreferredPaymentSetting> preferredPaymentSettings = new LinkedHashSet<>();

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
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
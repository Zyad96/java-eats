package com.mentorproject1.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Customer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "user_id", nullable = false)
    private int userId;
    @Basic
    @Column(name = "created_on", nullable = false)
    private Timestamp createdOn;
    @Basic
    @Column(name = "updated_on", nullable = false)
    private Timestamp updatedOn;
    @PrePersist
    public void prePersist() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        this.createdOn = now;
        this.updatedOn = now;
    }
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<Address> addressesById;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<Cart> cartsById;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User userByUserId;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<Order> ordersById;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<PreferredPaymentSetting> preferredPaymentSettingsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id && userId == customer.userId && Objects.equals(createdOn, customer.createdOn) && Objects.equals(updatedOn, customer.updatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, createdOn, updatedOn);
    }

    public Collection<Address> getAddressesById() {
        return addressesById;
    }

    public void setAddressesById(Collection<Address> addressesById) {
        this.addressesById = addressesById;
    }

    public Collection<Cart> getCartsById() {
        return cartsById;
    }

    public void setCartsById(Collection<Cart> cartsById) {
        this.cartsById = cartsById;
    }

    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    public Collection<Order> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<Order> ordersById) {
        this.ordersById = ordersById;
    }

    public Collection<PreferredPaymentSetting> getPreferredPaymentSettingsById() {
        return preferredPaymentSettingsById;
    }

    public void setPreferredPaymentSettingsById(Collection<PreferredPaymentSetting> preferredPaymentSettingsById) {
        this.preferredPaymentSettingsById = preferredPaymentSettingsById;
    }
}

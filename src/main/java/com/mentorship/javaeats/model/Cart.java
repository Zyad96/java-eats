package com.mentorproject1.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Cart {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "customer_id", nullable = false)
    private int customerId;
    @Basic
    @Column(name = "subtotal", nullable = false, precision = 0)
    private BigInteger subtotal;
    @Basic
    @Column(name = "tax", nullable = false, precision = 0)
    private BigInteger tax;
    @Basic
    @Column(name = "total", nullable = false, precision = 0)
    private BigInteger total;
    @Basic
    @Column(name = "status", nullable = false, length = 255)
    private String status;
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
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customerByCustomerId;
    @OneToMany(mappedBy = "cartByCartId")
    private Collection<CartItem> cartItemsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public BigInteger getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigInteger subtotal) {
        this.subtotal = subtotal;
    }

    public BigInteger getTax() {
        return tax;
    }

    public void setTax(BigInteger tax) {
        this.tax = tax;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        Cart cart = (Cart) o;
        return id == cart.id && customerId == cart.customerId && Objects.equals(subtotal, cart.subtotal) && Objects.equals(tax, cart.tax) && Objects.equals(total, cart.total) && Objects.equals(status, cart.status) && Objects.equals(createdOn, cart.createdOn) && Objects.equals(updatedOn, cart.updatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, subtotal, tax, total, status, createdOn, updatedOn);
    }

    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    public Collection<CartItem> getCartItemsById() {
        return cartItemsById;
    }

    public void setCartItemsById(Collection<CartItem> cartItemsById) {
        this.cartItemsById = cartItemsById;
    }
}

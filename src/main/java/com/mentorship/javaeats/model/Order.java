package com.mentorship.javaeats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "\"order\"")
public class Order implements Serializable {
    private static final long serialVersionUID = 5237255932579833792L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private Integer order_id;

    @Column(name = "customer_id", nullable = false)
    private Integer customer_id;

    @Column(name = "order_date", nullable = false)
    private Instant order_date;

    @Column(name = "subtotal", nullable = false)
    private BigDecimal subtotal;

    @Column(name = "tax", nullable = false)
    private BigDecimal tax;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    @Column(name = "order_status_id", nullable = false)
    private Integer order_status_id;

    @Column(name = "created_on", nullable = false)
    private Instant created_on;

    @Column(name = "updated_on", nullable = false)
    private Instant updated_on;

    @OneToMany(mappedBy = "order_id")
    private Set<OrderItem> orderItems = new LinkedHashSet<>();

    @OneToMany(mappedBy = "order_id")
    private Set<OrderTracking> orderTrackings = new LinkedHashSet<>();

    @OneToMany(mappedBy = "order_id")
    private Set<Transaction> transactions = new LinkedHashSet<>();

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Instant getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Instant order_date) {
        this.order_date = order_date;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Integer getOrder_status_id() {
        return order_status_id;
    }

    public void setOrder_status_id(Integer order_status_id) {
        this.order_status_id = order_status_id;
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

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Set<OrderTracking> getOrderTrackings() {
        return orderTrackings;
    }

    public void setOrderTrackings(Set<OrderTracking> orderTrackings) {
        this.orderTrackings = orderTrackings;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

}
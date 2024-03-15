package com.mentorproject1.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Order {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "customer_id", nullable = false)
    private int customerId;
    @Basic
    @Column(name = "order_date", nullable = false)
    private Timestamp orderDate;
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
    @Column(name = "order_status_id", nullable = false)
    private int orderStatusId;
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
    @ManyToOne
    @JoinColumn(name = "order_status_id", referencedColumnName = "id", nullable = false)
    private OrderStatus orderStatusByOrderStatusId;
    @OneToMany(mappedBy = "orderByOrderId")
    private Collection<OrderItem> orderItemsById;
    @OneToMany(mappedBy = "orderByOrderId")
    private Collection<OrderTracking> orderTrackingsById;
    @OneToMany(mappedBy = "orderByOrderId")
    private Collection<Transaction> transactionsById;

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

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
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

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
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
        Order order = (Order) o;
        return id == order.id && customerId == order.customerId && orderStatusId == order.orderStatusId && Objects.equals(orderDate, order.orderDate) && Objects.equals(subtotal, order.subtotal) && Objects.equals(tax, order.tax) && Objects.equals(total, order.total) && Objects.equals(createdOn, order.createdOn) && Objects.equals(updatedOn, order.updatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, orderDate, subtotal, tax, total, orderStatusId, createdOn, updatedOn);
    }

    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    public OrderStatus getOrderStatusByOrderStatusId() {
        return orderStatusByOrderStatusId;
    }

    public void setOrderStatusByOrderStatusId(OrderStatus orderStatusByOrderStatusId) {
        this.orderStatusByOrderStatusId = orderStatusByOrderStatusId;
    }

    public Collection<OrderItem> getOrderItemsById() {
        return orderItemsById;
    }

    public void setOrderItemsById(Collection<OrderItem> orderItemsById) {
        this.orderItemsById = orderItemsById;
    }

    public Collection<OrderTracking> getOrderTrackingsById() {
        return orderTrackingsById;
    }

    public void setOrderTrackingsById(Collection<OrderTracking> orderTrackingsById) {
        this.orderTrackingsById = orderTrackingsById;
    }

    public Collection<Transaction> getTransactionsById() {
        return transactionsById;
    }

    public void setTransactionsById(Collection<Transaction> transactionsById) {
        this.transactionsById = transactionsById;
    }
}

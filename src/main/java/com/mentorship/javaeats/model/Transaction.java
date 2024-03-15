package com.mentorproject1.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Transaction {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "order_id", nullable = false)
    private int orderId;
    @Basic
    @Column(name = "amount", nullable = false, precision = 0)
    private BigInteger amount;
    @Basic
    @Column(name = "transaction_status_id", nullable = false)
    private int transactionStatusId;
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
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    private Order orderByOrderId;
    @ManyToOne
    @JoinColumn(name = "transaction_status_id", referencedColumnName = "id", nullable = false)
    private TransactionStatus transactionStatusByTransactionStatusId;
    @OneToMany(mappedBy = "transactionByTransactionId")
    private Collection<TransactionDetails> transactionDetailsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public int getTransactionStatusId() {
        return transactionStatusId;
    }

    public void setTransactionStatusId(int transactionStatusId) {
        this.transactionStatusId = transactionStatusId;
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
        Transaction that = (Transaction) o;
        return id == that.id && orderId == that.orderId && transactionStatusId == that.transactionStatusId && Objects.equals(amount, that.amount) && Objects.equals(createdOn, that.createdOn) && Objects.equals(updatedOn, that.updatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, amount, transactionStatusId, createdOn, updatedOn);
    }

    public Order getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(Order orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }

    public TransactionStatus getTransactionStatusByTransactionStatusId() {
        return transactionStatusByTransactionStatusId;
    }

    public void setTransactionStatusByTransactionStatusId(TransactionStatus transactionStatusByTransactionStatusId) {
        this.transactionStatusByTransactionStatusId = transactionStatusByTransactionStatusId;
    }

    public Collection<TransactionDetails> getTransactionDetailsById() {
        return transactionDetailsById;
    }

    public void setTransactionDetailsById(Collection<TransactionDetails> transactionDetailsById) {
        this.transactionDetailsById = transactionDetailsById;
    }
}

package com.mentorproject1.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "transaction_details", schema = "public", catalog = "javaeat_lites")
public class TransactionDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "transaction_id", nullable = false)
    private int transactionId;
    @Basic
    @Column(name = "details", nullable = false, length = -1)
    private String details;
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
    @JoinColumn(name = "transaction_id", referencedColumnName = "id", nullable = false)
    private Transaction transactionByTransactionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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
        TransactionDetails that = (TransactionDetails) o;
        return id == that.id && transactionId == that.transactionId && Objects.equals(details, that.details) && Objects.equals(createdOn, that.createdOn) && Objects.equals(updatedOn, that.updatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionId, details, createdOn, updatedOn);
    }

    public Transaction getTransactionByTransactionId() {
        return transactionByTransactionId;
    }

    public void setTransactionByTransactionId(Transaction transactionByTransactionId) {
        this.transactionByTransactionId = transactionByTransactionId;
    }
}

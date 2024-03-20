package com.mentorship.javaeats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {
    private static final long serialVersionUID = 6316379937204703865L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", nullable = false)
    private Integer transaction_id;

    @Column(name = "order_id", nullable = false)
    private Integer order_id;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "transaction_status_id", nullable = false)
    private Integer transaction_status_id;

    @Column(name = "created_on", nullable = false)
    private Instant created_on;

    @Column(name = "updated_on", nullable = false)
    private Instant updated_on;

    @OneToMany(mappedBy = "transaction_id")
    private Set<TransactionDetail> transactionDetails = new LinkedHashSet<>();

    public Integer getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getTransaction_status_id() {
        return transaction_status_id;
    }

    public void setTransaction_status_id(Integer transaction_status_id) {
        this.transaction_status_id = transaction_status_id;
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

    public Set<TransactionDetail> getTransactionDetails() {
        return transactionDetails;
    }

    public void setTransactionDetails(Set<TransactionDetail> transactionDetails) {
        this.transactionDetails = transactionDetails;
    }

}
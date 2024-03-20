package com.mentorship.javaeats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "transaction_status")
public class TransactionStatus implements Serializable {
    private static final long serialVersionUID = 1254762601757586750L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_status_id", nullable = false)
    private Integer transaction_status_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "created_on", nullable = false)
    private Instant created_on;

    @Column(name = "updated_on", nullable = false)
    private Instant updated_on;

    @OneToMany(mappedBy = "transaction_status_id")
    private Set<Transaction> transactions = new LinkedHashSet<>();

    public Integer getTransaction_status_id() {
        return transaction_status_id;
    }

    public void setTransaction_status_id(Integer transaction_status_id) {
        this.transaction_status_id = transaction_status_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }

}
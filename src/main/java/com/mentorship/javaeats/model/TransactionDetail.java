package com.mentorship.javaeats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "transaction_details")
public class TransactionDetail implements Serializable {
    private static final long serialVersionUID = 6413867185386133420L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_details_id", nullable = false)
    private Integer transaction_details_id;

    @Column(name = "transaction_id", nullable = false)
    private Integer transaction_id;

    @Column(name = "details", nullable = false)
    private String details;

    @Column(name = "created_on", nullable = false)
    private Instant created_on;

    @Column(name = "updated_on", nullable = false)
    private Instant updated_on;

    public Integer getTransaction_details_id() {
        return transaction_details_id;
    }

    public void setTransaction_details_id(Integer transaction_details_id) {
        this.transaction_details_id = transaction_details_id;
    }

    public Integer getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(Integer transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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

}
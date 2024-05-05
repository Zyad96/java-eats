package com.mentorship.javaeats.model.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@Table(name = "transaction", schema = "javaeat_lites")
public class Transaction implements Serializable {
    private static final long serialVersionUID = 6316379937204703865L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id", nullable = false)
    private Long id;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @PrePersist
    protected void onCreate() {
        createdOn = Instant.now();
    }

    @OneToOne
    @JoinColumn(name = "transaction_details_id")
    private TransactionDetail transactionDetail;

    @OneToOne
    @JoinColumn(name = "transaction_status_id")
    private TransactionStatus transactionStatus;
}
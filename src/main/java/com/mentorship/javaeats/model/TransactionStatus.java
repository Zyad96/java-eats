package com.mentorship.javaeats.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Data
@Entity
@Table(name = "transaction_status", schema = "javaeat_lites")
public class TransactionStatus implements Serializable {
    private static final long serialVersionUID = 1254762601757586750L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_status_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @Column(name = "updated_on", nullable = false)
    private Instant updatedOn;

    @OneToMany
    @JoinColumn(name = "transaction_id")
    private Set<Transaction> transactions;

}
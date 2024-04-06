package com.mentorship.javaeats.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@Table(name = "transaction_details", schema = "javaeat_lites")
public class TransactionDetail implements Serializable {
    private static final long serialVersionUID = 6413867185386133420L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_details_id", nullable = false)
    private Integer id;

    @Column(name = "details", nullable = false)
    private String details;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @Column(name = "updated_on", nullable = false)
    private Instant updatedOn;

}
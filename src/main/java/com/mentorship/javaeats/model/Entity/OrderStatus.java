package com.mentorship.javaeats.model.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@Table(name = "order_status", schema = "javaeat_lites")
public class OrderStatus implements Serializable {
    private static final long serialVersionUID = 44758455531601541L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_status_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @PrePersist
    protected void onCreate() {
        createdOn = Instant.now();
    }

}
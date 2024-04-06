package com.mentorship.javaeats.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Data
@Entity
@Table(name = "order_status", schema = "javaeat_lites")
public class OrderStatus implements Serializable {
    private static final long serialVersionUID = 44758455531601541L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_status_id", nullable = false)
    private Integer id;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @Column(name = "updated_on", nullable = false)
    private Instant updatedOn;

    @OneToMany
    @JoinColumn(name = "order_id")
    private Set<Order> orders;

}
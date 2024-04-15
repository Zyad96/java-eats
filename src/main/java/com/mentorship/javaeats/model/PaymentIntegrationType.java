package com.mentorship.javaeats.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Data
@Entity
@Table(name = "payment_integration_type", schema = "javaeat_lites")
public class PaymentIntegrationType implements Serializable {
    private static final long serialVersionUID = -2501207728000428225L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_integration_type_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @Column(name = "updated_on", nullable = false)
    private Instant updatedOn;

    @OneToMany
    @JoinColumn(name = "payment_integration_type_id")
    private Set<PaymentTypeConfiguration> paymentTypeConfigurations;

}
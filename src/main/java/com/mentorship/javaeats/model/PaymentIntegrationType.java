package com.mentorship.javaeats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "payment_integration_type")
public class PaymentIntegrationType implements Serializable {
    private static final long serialVersionUID = -2501207728000428225L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_integration_type_id", nullable = false)
    private Integer payment_integration_type_id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "created_on", nullable = false)
    private Instant created_on;

    @Column(name = "updated_on", nullable = false)
    private Instant updated_on;

    @OneToMany(mappedBy = "payment_integration_type_id")
    private Set<PaymentTypeConfiguration> paymentTypeConfigurations = new LinkedHashSet<>();

    public Integer getPayment_integration_type_id() {
        return payment_integration_type_id;
    }

    public void setPayment_integration_type_id(Integer payment_integration_type_id) {
        this.payment_integration_type_id = payment_integration_type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Set<PaymentTypeConfiguration> getPaymentTypeConfigurations() {
        return paymentTypeConfigurations;
    }

    public void setPaymentTypeConfigurations(Set<PaymentTypeConfiguration> paymentTypeConfigurations) {
        this.paymentTypeConfigurations = paymentTypeConfigurations;
    }

}
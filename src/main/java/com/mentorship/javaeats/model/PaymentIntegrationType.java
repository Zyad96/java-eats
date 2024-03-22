package com.mentorship.javaeats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

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

    @OneToMany(mappedBy = "paymentIntegrationTypeId")
    private Set<PaymentTypeConfiguration> paymentTypeConfigurations = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Instant getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Instant updatedOn) {
        this.updatedOn = updatedOn;
    }

    public Set<PaymentTypeConfiguration> getPaymentTypeConfigurations() {
        return paymentTypeConfigurations;
    }

    public void setPaymentTypeConfigurations(Set<PaymentTypeConfiguration> paymentTypeConfigurations) {
        this.paymentTypeConfigurations = paymentTypeConfigurations;
    }

}
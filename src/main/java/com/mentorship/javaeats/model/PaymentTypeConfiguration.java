package com.mentorship.javaeats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "payment_type_configuration", schema = "javaeat_lites")
public class PaymentTypeConfiguration implements Serializable {
    private static final long serialVersionUID = -4385468626596680933L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_type_configuration_id", nullable = false)
    private Integer id;

    @Column(name = "payment_integration_type_id", nullable = false)
    private Integer paymentIntegrationTypeId;

    @Column(name = "configuration_details", nullable = false)
    private String configurationDetails;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @Column(name = "updated_on", nullable = false)
    private Instant updatedOn;

    @OneToMany(mappedBy = "paymentTypeConfigId")
    private Set<PreferredPaymentSetting> preferredPaymentSettings = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaymentIntegrationTypeId() {
        return paymentIntegrationTypeId;
    }

    public void setPaymentIntegrationTypeId(Integer paymentIntegrationTypeId) {
        this.paymentIntegrationTypeId = paymentIntegrationTypeId;
    }

    public String getConfigurationDetails() {
        return configurationDetails;
    }

    public void setConfigurationDetails(String configurationDetails) {
        this.configurationDetails = configurationDetails;
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

    public Set<PreferredPaymentSetting> getPreferredPaymentSettings() {
        return preferredPaymentSettings;
    }

    public void setPreferredPaymentSettings(Set<PreferredPaymentSetting> preferredPaymentSettings) {
        this.preferredPaymentSettings = preferredPaymentSettings;
    }

}
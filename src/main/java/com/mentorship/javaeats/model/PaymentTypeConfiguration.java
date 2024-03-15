package com.mentorproject1.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "payment_type_configuration", schema = "public", catalog = "javaeat_lites")
public class PaymentTypeConfiguration {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "payment_integration_type_id", nullable = false)
    private int paymentIntegrationTypeId;
    @Basic
    @Column(name = "configuration_details", nullable = false, length = -1)
    private String configurationDetails;
    @Basic
    @Column(name = "created_on", nullable = false)
    private Timestamp createdOn;
    @Basic
    @Column(name = "updated_on", nullable = false)
    private Timestamp updatedOn;
    @PrePersist
    public void prePersist() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        this.createdOn = now;
        this.updatedOn = now;
    }
    @ManyToOne
    @JoinColumn(name = "payment_integration_type_id", referencedColumnName = "id", nullable = false)
    private PaymentIntegrationType paymentIntegrationTypeByPaymentIntegrationTypeId;
    @OneToMany(mappedBy = "paymentTypeConfigurationByPaymentTypeConfigId")
    private Collection<PreferredPaymentSetting> preferredPaymentSettingsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaymentIntegrationTypeId() {
        return paymentIntegrationTypeId;
    }

    public void setPaymentIntegrationTypeId(int paymentIntegrationTypeId) {
        this.paymentIntegrationTypeId = paymentIntegrationTypeId;
    }

    public String getConfigurationDetails() {
        return configurationDetails;
    }

    public void setConfigurationDetails(String configurationDetails) {
        this.configurationDetails = configurationDetails;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentTypeConfiguration that = (PaymentTypeConfiguration) o;
        return id == that.id && paymentIntegrationTypeId == that.paymentIntegrationTypeId && Objects.equals(configurationDetails, that.configurationDetails) && Objects.equals(createdOn, that.createdOn) && Objects.equals(updatedOn, that.updatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentIntegrationTypeId, configurationDetails, createdOn, updatedOn);
    }

    public PaymentIntegrationType getPaymentIntegrationTypeByPaymentIntegrationTypeId() {
        return paymentIntegrationTypeByPaymentIntegrationTypeId;
    }

    public void setPaymentIntegrationTypeByPaymentIntegrationTypeId(PaymentIntegrationType paymentIntegrationTypeByPaymentIntegrationTypeId) {
        this.paymentIntegrationTypeByPaymentIntegrationTypeId = paymentIntegrationTypeByPaymentIntegrationTypeId;
    }

    public Collection<PreferredPaymentSetting> getPreferredPaymentSettingsById() {
        return preferredPaymentSettingsById;
    }

    public void setPreferredPaymentSettingsById(Collection<PreferredPaymentSetting> preferredPaymentSettingsById) {
        this.preferredPaymentSettingsById = preferredPaymentSettingsById;
    }
}

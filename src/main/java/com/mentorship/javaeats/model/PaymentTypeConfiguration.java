package com.mentorship.javaeats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "payment_type_configuration")
public class PaymentTypeConfiguration implements Serializable {
    private static final long serialVersionUID = -4385468626596680933L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_type_configuration_id", nullable = false)
    private Integer payment_type_configuration_id;

    @Column(name = "payment_integration_type_id", nullable = false)
    private Integer payment_integration_type_id;

    @Column(name = "configuration_details", nullable = false)
    private String configuration_details;

    @Column(name = "created_on", nullable = false)
    private Instant created_on;

    @Column(name = "updated_on", nullable = false)
    private Instant updated_on;

    @OneToMany(mappedBy = "payment_type_config_id")
    private Set<PreferredPaymentSetting> preferredPaymentSettings = new LinkedHashSet<>();

    public Integer getPayment_type_configuration_id() {
        return payment_type_configuration_id;
    }

    public void setPayment_type_configuration_id(Integer payment_type_configuration_id) {
        this.payment_type_configuration_id = payment_type_configuration_id;
    }

    public Integer getPayment_integration_type_id() {
        return payment_integration_type_id;
    }

    public void setPayment_integration_type_id(Integer payment_integration_type_id) {
        this.payment_integration_type_id = payment_integration_type_id;
    }

    public String getConfiguration_details() {
        return configuration_details;
    }

    public void setConfiguration_details(String configuration_details) {
        this.configuration_details = configuration_details;
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

    public Set<PreferredPaymentSetting> getPreferredPaymentSettings() {
        return preferredPaymentSettings;
    }

    public void setPreferredPaymentSettings(Set<PreferredPaymentSetting> preferredPaymentSettings) {
        this.preferredPaymentSettings = preferredPaymentSettings;
    }

}
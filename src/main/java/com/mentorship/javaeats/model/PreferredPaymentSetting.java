package com.mentorship.javaeats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "preferred_payment_setting")
public class PreferredPaymentSetting implements Serializable {
    private static final long serialVersionUID = -6478348039126767157L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preferred_payment_setting_id", nullable = false)
    private Integer preferred_payment_setting_id;

    @Column(name = "customer_id", nullable = false)
    private Integer customer_id;

    @Column(name = "payment_type_config_id", nullable = false)
    private Integer payment_type_config_id;

    @Column(name = "created_on", nullable = false)
    private Instant created_on;

    @Column(name = "updated_on", nullable = false)
    private Instant updated_on;

    public Integer getPreferred_payment_setting_id() {
        return preferred_payment_setting_id;
    }

    public void setPreferred_payment_setting_id(Integer preferred_payment_setting_id) {
        this.preferred_payment_setting_id = preferred_payment_setting_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getPayment_type_config_id() {
        return payment_type_config_id;
    }

    public void setPayment_type_config_id(Integer payment_type_config_id) {
        this.payment_type_config_id = payment_type_config_id;
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

}
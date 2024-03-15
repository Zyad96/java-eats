package com.mentorproject1.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "preferred_payment_setting", schema = "public", catalog = "javaeat_lites")
public class PreferredPaymentSetting {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "customer_id", nullable = false)
    private int customerId;
    @Basic
    @Column(name = "payment_type_config_id", nullable = false)
    private int paymentTypeConfigId;
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
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private Customer customerByCustomerId;
    @ManyToOne
    @JoinColumn(name = "payment_type_config_id", referencedColumnName = "id", nullable = false)
    private PaymentTypeConfiguration paymentTypeConfigurationByPaymentTypeConfigId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPaymentTypeConfigId() {
        return paymentTypeConfigId;
    }

    public void setPaymentTypeConfigId(int paymentTypeConfigId) {
        this.paymentTypeConfigId = paymentTypeConfigId;
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
        PreferredPaymentSetting that = (PreferredPaymentSetting) o;
        return id == that.id && customerId == that.customerId && paymentTypeConfigId == that.paymentTypeConfigId && Objects.equals(createdOn, that.createdOn) && Objects.equals(updatedOn, that.updatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, paymentTypeConfigId, createdOn, updatedOn);
    }

    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    public PaymentTypeConfiguration getPaymentTypeConfigurationByPaymentTypeConfigId() {
        return paymentTypeConfigurationByPaymentTypeConfigId;
    }

    public void setPaymentTypeConfigurationByPaymentTypeConfigId(PaymentTypeConfiguration paymentTypeConfigurationByPaymentTypeConfigId) {
        this.paymentTypeConfigurationByPaymentTypeConfigId = paymentTypeConfigurationByPaymentTypeConfigId;
    }
}

package com.mentorship.javaeats.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Data
@Entity
@Table(name = "payment_type_configuration", schema = "javaeat_lites")
public class PaymentTypeConfiguration implements Serializable {
    private static final long serialVersionUID = -4385468626596680933L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_type_configuration_id", nullable = false)
    private Integer id;

    @Column(name = "configuration_details", nullable = false)
    private String configurationDetails;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @Column(name = "updated_on", nullable = false)
    private Instant updatedOn;

    @OneToMany
    @JoinColumn(name = "payment_type_configuration_id")
    private Set<PreferredPaymentSetting> preferredPaymentSettings;

}
package com.mentorship.javaeats.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@Table(name = "preferred_payment_setting", schema = "javaeat_lites")
public class PreferredPaymentSetting implements Serializable {
    private static final long serialVersionUID = -6478348039126767157L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preferred_payment_setting_id", nullable = false)
    private Integer id;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @Column(name = "updated_on", nullable = false)
    private Instant updatedOn;

}
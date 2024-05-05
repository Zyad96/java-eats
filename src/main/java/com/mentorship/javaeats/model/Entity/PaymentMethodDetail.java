package com.mentorship.javaeats.model.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
public class PaymentMethodDetail implements Serializable {
    private static final long serialVersionUID = -8202597715528208474L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_method_detail_id", nullable = false)
    private Long id;

    @Column(name = "expire_date", nullable = false)
    private String expireDate;

    @Column(name = "cvv", nullable = false)
    private String cvv;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "card_holder_name", nullable = false)
    private String cardHolderName;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @PrePersist
    protected void onCreate() {
        createdOn = Instant.now();
    }
}

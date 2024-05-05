package com.mentorship.javaeats.model.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
public class PaymentMethod implements Serializable {
    private static final long serialVersionUID = -8242597715528208474L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_method_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @PrePersist
    protected void onCreate() {
        createdOn = Instant.now();
        if(checkPaymentMethodType()){
            paymentMethodDetail = new PaymentMethodDetail();
        }
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method_detail_id")
    private PaymentMethodDetail paymentMethodDetail;


    public boolean checkPaymentMethodType(){
        if(this.name.equalsIgnoreCase("card")){
            return true;
        }
        return false;
    }
}

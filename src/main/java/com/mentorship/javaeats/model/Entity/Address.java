package com.mentorship.javaeats.model.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@Table(name = "address", schema = "javaeat_lites")
public class Address implements Serializable {
    private static final long serialVersionUID = 5877626381862314210L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    private Long id;

    @Column(name = "address_line1", nullable = false)
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @PrePersist
    protected void onCreate() {
        createdOn = Instant.now();
    }
}
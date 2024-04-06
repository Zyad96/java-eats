package com.mentorship.javaeats.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Data
@Entity
@Table(name = "\"user\"", schema = "javaeat_lites")
public class User implements Serializable {
    private static final long serialVersionUID = -4255995890103524333L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @Column(name = "updated_on", nullable = false)
    private Instant updatedOn;

    @OneToMany
    @JoinColumn(name = "auditing_id")
    private Set<Auditing> auditings;

    @OneToMany
    @JoinColumn(name = "customer_id")
    private Set<Customer> customers;

    @ManyToMany
    @JoinColumn(name = "role_id")
    private Set<Role> roles;

    @OneToOne
    @JoinColumn(name = "user_type_id")
    private UserType userType;
}
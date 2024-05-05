package com.mentorship.javaeats.model.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Data
@Getter
@Setter
@Entity
@Table(name = "user", schema = "javaeat_lites")
public class User implements Serializable {
    private static final long serialVersionUID = -4255995890103524333L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "is_active", nullable = false, columnDefinition = "boolean default true")
    private Boolean isActive;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @Column(name = "deleted_on", nullable = false)
    private Instant deletedOn;

    @PrePersist
    protected void onCreate() {
        createdOn = Instant.now();
    }

    @PreUpdate
    protected void onUpdate() {
        if(!isActive) {
            deletedOn = Instant.now();
        }
    }

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "role_id")
    )
    private Set<Role> roles;

    @OneToOne
    @JoinColumn(name = "user_type_id")
    private UserType userType;
}
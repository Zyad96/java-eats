package com.mentorship.javaeats.model.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
@Data
@Entity
@Table(name = "user_type", schema = "javaeat_lites")
public class UserType implements Serializable {
    private static final long serialVersionUID = 4615377170527086966L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_type_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @PrePersist
    protected void onCreate() {
        createdOn = Instant.now();
    }
}
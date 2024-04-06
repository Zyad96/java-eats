package com.mentorship.javaeats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "role", schema = "javaeat_lites")
public class Role implements Serializable {
    private static final long serialVersionUID = -6939625005545070489L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @Column(name = "updated_on", nullable = false)
    private Instant updatedOn;

}
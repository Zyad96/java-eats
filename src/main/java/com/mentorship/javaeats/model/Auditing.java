package com.mentorship.javaeats.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@Entity
@Table(name = "auditing", schema = "javaeat_lites")
public class Auditing implements Serializable {
    private static final long serialVersionUID = 7295089491328365936L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auditing_id", nullable = false)
    private Integer id;

    @Column(name = "action", nullable = false)
    private String action;

    @Column(name = "\"timestamp\"")
    private Instant timestamp;

/*
 TODO [JPA Buddy] create field to map the 'details' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "details", columnDefinition = "jsonb(0, 0) not null")
    private Object details;
*/
}
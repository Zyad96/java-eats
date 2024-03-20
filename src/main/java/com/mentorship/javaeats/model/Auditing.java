package com.mentorship.javaeats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "auditing")
public class Auditing implements Serializable {
    private static final long serialVersionUID = 7295089491328365936L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auditing_id", nullable = false)
    private Integer auditing_id;

    @Column(name = "user_id", nullable = false)
    private Integer user_id;

    @Column(name = "action", nullable = false)
    private String action;

    @Column(name = "\"timestamp\"")
    private Instant timestamp;

    public Integer getAuditing_id() {
        return auditing_id;
    }

    public void setAuditing_id(Integer auditing_id) {
        this.auditing_id = auditing_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

/*
 TODO [JPA Buddy] create field to map the 'details' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @Column(name = "details", columnDefinition = "jsonb(0, 0) not null")
    private Object details;
*/
}
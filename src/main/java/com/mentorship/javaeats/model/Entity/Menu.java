package com.mentorship.javaeats.model.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Set;

@Data
@Entity
@Table(name = "menu", schema = "javaeat_lites")
public class Menu implements Serializable {
    private static final long serialVersionUID = 992474905033827332L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "is_visible", nullable = false)
    private Boolean isVisible;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "menu_id")
    private Set<MenuItem> menuItems;

    @PrePersist
    protected void onCreate() {
        createdOn = Instant.now();
    }

}
package com.mentorship.javaeats.model.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ingredient", schema = "javaeat_lites")
public class Ingredient implements Serializable {
    private static final long serialVersionUID = 1107477722230800809L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

}
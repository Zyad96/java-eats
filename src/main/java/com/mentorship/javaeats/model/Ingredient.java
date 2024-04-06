package com.mentorship.javaeats.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@Table(name = "ingredient", schema = "javaeat_lites")
public class Ingredient implements Serializable {
    private static final long serialVersionUID = 1107477722230800809L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "allergens")
    private String allergens;

    @Column(name = "unit")
    private String unit;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "stock_quantity", nullable = false)
    private Integer stockQuantity;

    @Column(name = "storage_instructions")
    private String storageInstructions;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @Column(name = "updated_on", nullable = false)
    private Instant updatedOn;

}
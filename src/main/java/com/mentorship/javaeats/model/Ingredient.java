package com.mentorship.javaeats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "ingredient")
public class Ingredient implements Serializable {
    private static final long serialVersionUID = 1107477722230800809L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id", nullable = false)
    private Integer ingredient_id;

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
    private Integer stock_quantity;

    @Column(name = "storage_instructions")
    private String storage_instructions;

    @Column(name = "created_on", nullable = false)
    private Instant created_on;

    @Column(name = "updated_on", nullable = false)
    private Instant updated_on;

    @OneToMany(mappedBy = "ingredient_id")
    private Set<MenuItemIngredient> menuItemIngredients = new LinkedHashSet<>();

    public Integer getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Integer ingredient_id) {
        this.ingredient_id = ingredient_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Integer getStock_quantity() {
        return stock_quantity;
    }

    public void setStock_quantity(Integer stock_quantity) {
        this.stock_quantity = stock_quantity;
    }

    public String getStorage_instructions() {
        return storage_instructions;
    }

    public void setStorage_instructions(String storage_instructions) {
        this.storage_instructions = storage_instructions;
    }

    public Instant getCreated_on() {
        return created_on;
    }

    public void setCreated_on(Instant created_on) {
        this.created_on = created_on;
    }

    public Instant getUpdated_on() {
        return updated_on;
    }

    public void setUpdated_on(Instant updated_on) {
        this.updated_on = updated_on;
    }

    public Set<MenuItemIngredient> getMenuItemIngredients() {
        return menuItemIngredients;
    }

    public void setMenuItemIngredients(Set<MenuItemIngredient> menuItemIngredients) {
        this.menuItemIngredients = menuItemIngredients;
    }

}
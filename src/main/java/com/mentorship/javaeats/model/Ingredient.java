package com.mentorproject1.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Ingredient {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "allergens", nullable = true, length = -1)
    private String allergens;
    @Basic
    @Column(name = "unit", nullable = true, length = 255)
    private String unit;
    @Basic
    @Column(name = "cost", nullable = true, precision = 0)
    private BigInteger cost;
    @Basic
    @Column(name = "stock_quantity", nullable = false)
    private int stockQuantity;
    @Basic
    @Column(name = "storage_instructions", nullable = true, length = -1)
    private String storageInstructions;
    @Basic
    @Column(name = "created_on", nullable = false)
    private Timestamp createdOn;
    @Basic
    @Column(name = "updated_on", nullable = false)
    private Timestamp updatedOn;
    @PrePersist
    public void prePersist() {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        this.createdOn = now;
        this.updatedOn = now;
    }
    @OneToMany(mappedBy = "ingredientByIngredientId")
    private Collection<MenuItemIngredient> menuItemIngredientsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public BigInteger getCost() {
        return cost;
    }

    public void setCost(BigInteger cost) {
        this.cost = cost;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getStorageInstructions() {
        return storageInstructions;
    }

    public void setStorageInstructions(String storageInstructions) {
        this.storageInstructions = storageInstructions;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return id == that.id && stockQuantity == that.stockQuantity && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(allergens, that.allergens) && Objects.equals(unit, that.unit) && Objects.equals(cost, that.cost) && Objects.equals(storageInstructions, that.storageInstructions) && Objects.equals(createdOn, that.createdOn) && Objects.equals(updatedOn, that.updatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, allergens, unit, cost, stockQuantity, storageInstructions, createdOn, updatedOn);
    }

    public Collection<MenuItemIngredient> getMenuItemIngredientsById() {
        return menuItemIngredientsById;
    }

    public void setMenuItemIngredientsById(Collection<MenuItemIngredient> menuItemIngredientsById) {
        this.menuItemIngredientsById = menuItemIngredientsById;
    }
}

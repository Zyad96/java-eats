package com.mentorship.javaeats.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.persistence.JoinTable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "menu_item", schema = "javaeat_lites")
public class MenuItem implements Serializable {
    private static final long serialVersionUID = -6693068862351378435L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_item_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "stock_quantity")
    private Integer stockQuantity;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @Column(name = "updated_on", nullable = false)
    private Instant updatedOn;

@ManyToMany
    @JoinTable(
            name = "menu_item_ingredients",
            joinColumns = @JoinColumn(name = "menu_item_id",referencedColumnName = "menu_item_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id",referencedColumnName = "ingredient_id"))
    @ToString.Exclude
    private Set<Ingredient> ingredients;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_item_id")
    @ToString.Exclude
    private Set<OrderItem> orderItems;

    public Ingredient getIngredient(int ingredientId) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getId() == ingredientId) {
                return ingredient;
            }
        }
        return null;
    }

}
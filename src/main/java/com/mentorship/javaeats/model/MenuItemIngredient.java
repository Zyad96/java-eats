package com.mentorship.javaeats.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Table(name = "menu_item_ingredient")
public class MenuItemIngredient implements Serializable {
    private static final long serialVersionUID = -438203614380434834L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_item_ingredient_id", nullable = false)
    private Integer menu_item_ingredient_id;

    @Column(name = "menu_item_id", nullable = false)
    private Integer menu_item_id;

    @Column(name = "ingredient_id", nullable = false)
    private Integer ingredient_id;

    @Column(name = "created_on", nullable = false)
    private Instant created_on;

    @Column(name = "updated_on", nullable = false)
    private Instant updated_on;

    public Integer getMenu_item_ingredient_id() {
        return menu_item_ingredient_id;
    }

    public void setMenu_item_ingredient_id(Integer menu_item_ingredient_id) {
        this.menu_item_ingredient_id = menu_item_ingredient_id;
    }

    public Integer getMenu_item_id() {
        return menu_item_id;
    }

    public void setMenu_item_id(Integer menu_item_id) {
        this.menu_item_id = menu_item_id;
    }

    public Integer getIngredient_id() {
        return ingredient_id;
    }

    public void setIngredient_id(Integer ingredient_id) {
        this.ingredient_id = ingredient_id;
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

}
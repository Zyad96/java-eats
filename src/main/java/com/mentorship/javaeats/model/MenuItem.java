package com.mentorship.javaeats.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_item_id")
    @ToString.Exclude
    private Set<CartItem> cartItems;

    @ManyToMany
    @JoinColumn(name = "ingredient_id")
    @ToString.Exclude
    private Set<Ingredient> ingredients;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_item_id")
    @ToString.Exclude
    private Set<OrderItem> orderItems;

}
package com.mentorproject1.entity;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "menu_item", schema = "public", catalog = "javaeat_lites")
public class MenuItem {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "menu_id", nullable = false)
    private int menuId;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @Basic
    @Column(name = "description", nullable = true, length = -1)
    private String description;
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private BigInteger price;
    @Basic
    @Column(name = "status", nullable = false, length = 255)
    private String status;
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
    @OneToMany(mappedBy = "menuItemByMenuItemId")
    private Collection<CartItem> cartItemsById;
    @ManyToOne
    @JoinColumn(name = "menu_id", referencedColumnName = "id", nullable = false)
    private Menu menuByMenuId;
    @OneToMany(mappedBy = "menuItemByMenuItemId")
    private Collection<MenuItemIngredient> menuItemIngredientsById;
    @OneToMany(mappedBy = "menuItemByMenuItemId")
    private Collection<OrderItem> orderItemsById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
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

    public BigInteger getPrice() {
        return price;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        MenuItem menuItem = (MenuItem) o;
        return id == menuItem.id && menuId == menuItem.menuId && Objects.equals(name, menuItem.name) && Objects.equals(description, menuItem.description) && Objects.equals(price, menuItem.price) && Objects.equals(status, menuItem.status) && Objects.equals(createdOn, menuItem.createdOn) && Objects.equals(updatedOn, menuItem.updatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, menuId, name, description, price, status, createdOn, updatedOn);
    }

    public Collection<CartItem> getCartItemsById() {
        return cartItemsById;
    }

    public void setCartItemsById(Collection<CartItem> cartItemsById) {
        this.cartItemsById = cartItemsById;
    }

    public Menu getMenuByMenuId() {
        return menuByMenuId;
    }

    public void setMenuByMenuId(Menu menuByMenuId) {
        this.menuByMenuId = menuByMenuId;
    }

    public Collection<MenuItemIngredient> getMenuItemIngredientsById() {
        return menuItemIngredientsById;
    }

    public void setMenuItemIngredientsById(Collection<MenuItemIngredient> menuItemIngredientsById) {
        this.menuItemIngredientsById = menuItemIngredientsById;
    }

    public Collection<OrderItem> getOrderItemsById() {
        return orderItemsById;
    }

    public void setOrderItemsById(Collection<OrderItem> orderItemsById) {
        this.orderItemsById = orderItemsById;
    }
}

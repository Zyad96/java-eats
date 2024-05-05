package com.mentorship.javaeats.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cart_item", schema = "javaeat_lites")
public class CartItem implements Serializable {
    private static final long serialVersionUID = -8836255250946841875L;
    @Id
    @Column(name = "cart_item_id", nullable = false)
    private Long id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "unit_price", nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "total_price", nullable = false)
    @Formula("quantity * unit_price")
    private BigDecimal totalPrice;

    @Column(name = "created_on", nullable = false)
    private Instant createdOn;

    @PrePersist
    protected void onCreate() {
        createdOn = Instant.now();
    }

    @OneToOne
    @JoinColumn(name="cart_item_id")
    @ToString.Exclude
    @MapsId
    private MenuItem menuItem;
}
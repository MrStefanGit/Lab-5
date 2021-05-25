package com.example.lab5.lab5.domains;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="cart")
@Getter
@Setter
@ToString
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "created_date")
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    public Cart(Long userId, Product product, int quantity) {
        this.userId = userId;
        this.product = product;
        this.quantity = quantity;
        this.createdDate = new Date();
    }

    public Cart() {

    }
}

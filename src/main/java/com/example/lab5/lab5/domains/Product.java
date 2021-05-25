package com.example.lab5.lab5.domains;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="product")
@Getter
@Setter
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;

    public Product(String name1, String type1, String description1, double v) {
        this.description = description1;
        this.name = name1;
        this.price = v;
        this.type = type1;
    }

    public Product() {

    }
    public String getName() {return this.name;}
}

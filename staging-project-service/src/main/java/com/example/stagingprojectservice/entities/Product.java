package com.example.stagingprojectservice.entities;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @Column(name="product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;

    @Column(name="technology")
    private String technology;

    @Column(name="size")
    private String size;

    @Column(name="inventory")
    private int inventory;

    @Column(name="price")
    private float price;
}

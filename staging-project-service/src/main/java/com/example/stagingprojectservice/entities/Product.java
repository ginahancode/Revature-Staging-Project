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

    @Column(name="gender")
    private String gender;

    @Column(name="inventory")
    private int inventory;

    @Column(name="price")
    private double price;

    @Column(name="image")
    private String image;

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Product(String name, String type, String technology, String size, String gender, int inventory, double price, String image) {
        this.name = name;
        this.type = type;
        this.technology = technology;
        this.size = size;
        this.gender = gender;
        this.inventory = inventory;
        this.price = price;
        this.image = image;
    }

    public Product() {

    }
}

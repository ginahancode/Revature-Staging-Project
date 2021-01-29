package com.example.stagingprojectservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="orders_products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderProduct {
    @Id
    @Column(name="orders_products_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ordersProductsID;

    @Column(name="order_id")
    private int orderID;

    @Column(name="product_id")
    private int productID;

    @Column(name="quantity")
    private int quantity;
}

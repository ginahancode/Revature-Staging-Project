package com.example.stagingprojectservice.entities;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {


    @Id
    @Column(name="order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderID;

    @Column(name="customer_id")
    private int customerID;

    public Order(int customerID) {
        this.customerID = customerID;
    }

}

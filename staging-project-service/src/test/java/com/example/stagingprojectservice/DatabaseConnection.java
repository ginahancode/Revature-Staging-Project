package com.example.stagingprojectservice;

import com.example.stagingprojectservice.entities.Order;
import com.example.stagingprojectservice.entities.Product;
import com.example.stagingprojectservice.entities.User;
import com.example.stagingprojectservice.repositories.OrderRepo;
import com.example.stagingprojectservice.repositories.ProductRepo;
import com.example.stagingprojectservice.repositories.UserRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class DatabaseConnection {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ProductRepo productRepo;

//    @Test
//    public void testDatabaseConnection() {
//        Product p1 = new Product("Angular Shirt", "Shirt", "Angular", "XL", 100, 10.99);
////        SessionFactory factory = productRepo.getFactory();
////        Session session = factory.openSession();
//        productRepo.save(p1);

//
//    }

}

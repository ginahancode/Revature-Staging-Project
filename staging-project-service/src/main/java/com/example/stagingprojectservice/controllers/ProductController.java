package com.example.stagingprojectservice.controllers;

import com.example.stagingprojectservice.entities.Product;
import com.example.stagingprojectservice.repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.TEXT_PLAIN;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

//    @Autowired
//    public ProductController(ProductRepo productRepo) {
//        this.productRepo = productRepo;
//    }

    @GetMapping("/products")
    @ResponseBody
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}

package com.example.stagingprojectservice.controllers;

import com.example.stagingprojectservice.entities.Product;
import com.example.stagingprojectservice.repositories.ProductRepo;
import com.example.stagingprojectservice.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") int productId)
            throws ResourceNotFoundException {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this ID: " + productId));
        return ResponseEntity.ok().body(product);
    }

    // Need to test with UI
    // Declare HTTP method as "post" in front end
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
        return productRepo.save(product);
    }

    // Need to test with UI
    // Declare HTTP method as "put" in front end
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") int productId,
                                                   @RequestBody Product productDetails) throws ResourceNotFoundException {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this ID: " + productId));

        product.setName(productDetails.getName());
        product.setType(productDetails.getType());
        product.setTechnology(productDetails.getTechnology());
        product.setSize(productDetails.getSize());
        product.setGender(productDetails.getGender());
        product.setInventory(productDetails.getInventory());
        product.setPrice(productDetails.getPrice());
        product.setImage(productDetails.getImage());

        final Product updatedProduct = productRepo.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    // Need to test with UI
    // Declare HTTP method as "delete" in front end
    @DeleteMapping("/products/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") int productId)
            throws ResourceNotFoundException {
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this ID: " + productId));

        productRepo.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

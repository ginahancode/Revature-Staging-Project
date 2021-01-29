package com.example.stagingprojectservice.controllers;

import com.example.stagingprojectservice.entities.Order;
import com.example.stagingprojectservice.exceptions.ResourceNotFoundException;
import com.example.stagingprojectservice.repositories.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class OrderController {

    @Autowired
    private OrderRepo orderRepo;

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getEmployeeById(@PathVariable(value = "id") int orderId)
            throws ResourceNotFoundException {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for this ID: " + orderId));
        return ResponseEntity.ok().body(order);
    }

    // Need to test with UI
    // Declare HTTP method as "post" in front end
    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        return orderRepo.save(order);
    }

    // Need to test with UI
    // Declare HTTP method as "put" in front end
    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") int orderId,
                                                 @RequestBody Order orderDetails) throws ResourceNotFoundException {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for this ID: " + orderId));

        order.setOrderID(orderDetails.getOrderID());
        order.setCustomerID(orderDetails.getCustomerID());

        final Order updatedOrder = orderRepo.save(order);
        return ResponseEntity.ok(updatedOrder);
    }

    // Need to test with UI
    // Declare HTTP method as "delete" in front end
    @DeleteMapping("/orders/{id}")
    public Map<String, Boolean> deleteOrder(@PathVariable(value = "id") int orderId)
            throws ResourceNotFoundException {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for this ID: " + orderId));

        orderRepo.delete(order);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

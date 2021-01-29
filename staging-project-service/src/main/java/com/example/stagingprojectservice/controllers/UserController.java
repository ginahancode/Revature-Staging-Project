package com.example.stagingprojectservice.controllers;

import com.example.stagingprojectservice.entities.Product;
import com.example.stagingprojectservice.entities.User;
import com.example.stagingprojectservice.exceptions.ResourceNotFoundException;
import com.example.stagingprojectservice.repositories.UserRepo;
import com.example.stagingprojectservice.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") int userId)
            throws ResourceNotFoundException {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this ID: " + userId));
        return ResponseEntity.ok().body(user);
    }

    // Need to test with UI
    // Declare HTTP method as "post" in front end
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepo.save(user);
    }

    // Need to test with UI
    // Declare HTTP method as "put" in front end
    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") int userId,
                                                 @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this ID: " + userId));

        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());
        user.setEmail(userDetails.getEmail());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setAddress(user.getAddress());
        user.setCity(user.getCity());
        user.setState(user.getState());
        user.setZipcode(user.getZipcode());

        final User updatedUser = userRepo.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    // Need to test with UI
    // Declare HTTP method as "delete" in front end
    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") int userId)
            throws ResourceNotFoundException {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this ID: " + userId));

        userRepo.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}

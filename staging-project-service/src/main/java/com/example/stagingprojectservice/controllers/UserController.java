package com.example.stagingprojectservice.controllers;

import com.example.stagingprojectservice.entities.User;
import com.example.stagingprojectservice.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/v1")
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

}

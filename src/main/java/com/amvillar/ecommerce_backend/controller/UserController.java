package com.amvillar.ecommerce_backend.controller;

import com.amvillar.ecommerce_backend.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.amvillar.ecommerce_backend.service.UserService;

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        boolean isRegistered = userService.registerUser(user);

        if (isRegistered) {
            // Return http code 201
            return new ResponseEntity<>("User registered with success", HttpStatus.CREATED)
        } else {
            // Return code 409
            return new ResponseEntity<>("This mail already exists", HttpStatus.CONFLICT);
        }
    }
}

package com.amvillar.ecommerce_backend.service;

import com.amvillar.ecommerce_backend.model.User;
import com.amvillar.ecommerce_backend.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Inyección de dependencias por constructor
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public boolean registerUser(User user) {
        boolean mailExists = userRepository.existsByEmail(user.getEmail());

        // Register user if mail doesn't exist
        if (!mailExists) {
            String securePassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(securePassword);

            userRepository.save(user);
            return true;
        } else {
            return false;
        }
    }
}
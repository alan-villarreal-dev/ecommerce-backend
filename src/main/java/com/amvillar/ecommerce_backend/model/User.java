package com.amvillar.ecommerce_backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // 1. Tells spring: "Hey this is a database"
@Table(name = "users") // 2. Table "users"
@Data // 3. Lombok: With this we dont need to create getters, setters and override toString method
@NoArgsConstructor // 4. JPA needs an empty constructor
@AllArgsConstructor // 5. Creates a constructor with all the arguments
public class User {

    @Id // Marks the field as primary key (Primary Key)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long id;

    private String username;

    private String name;

    @Column(unique = true) // Doesn't allow to have 2 users with the same email
    private String email;

    private String address;

    private String phone;

    private String password;
}
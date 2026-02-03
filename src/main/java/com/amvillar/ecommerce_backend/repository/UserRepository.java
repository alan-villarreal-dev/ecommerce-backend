package com.amvillar.ecommerce_backend.repository;

import com.amvillar.ecommerce_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    // Extending JpaRepository we have automatically methods like:
    // .save() -> Save
    // .findAll() -> Find All
    // .findById() -> Find by ID
    // .delete() -> Delete
}
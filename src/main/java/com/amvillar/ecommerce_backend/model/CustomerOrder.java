package com.amvillar.ecommerce_backend.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity // 1. Tells spring: "Hey this is a database"
@Table(name = "customer_order") // 2. Table "customer_order"
@Data // 3. Lombok: With this we dont need to create getters, setters and override toString method
@NoArgsConstructor // 4. JPA needs an empty constructor
@AllArgsConstructor //
public class CustomerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

}

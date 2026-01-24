package com.amvillar.ecommerce_backend;

import com.amvillar.ecommerce_backend.model.User;
import com.amvillar.ecommerce_backend.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest // 1. Configuración especial para probar solo repositorios JPA
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 2. Usa la DB real (Docker), no una en memoria
@Rollback(false) // 3. (Opcional) Deja los datos en la DB para que puedas verlos después. Por defecto los borra al terminar el test.
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateUser() {
        // A. ARRANGE (Preparar)
        User user = new User();
        user.setUsername("juanperez");
        user.setName("Juan Perez");
        user.setEmail("juan@example.com");
        user.setPassword("password123"); // En el futuro esto irá encriptado

        // B. ACT (Actuar)
        User savedUser = userRepository.save(user);

        // C. ASSERT (Verificar)
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);

        System.out.println("Usuario guardado con ID: " + savedUser.getId());
    }
}
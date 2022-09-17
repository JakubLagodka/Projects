package pl.lagodka.shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import pl.lagodka.shop.model.dao.Role;
import pl.lagodka.shop.model.dao.User;
import pl.lagodka.shop.model.dto.LoginDto;
import pl.lagodka.shop.repository.UserRepository;

import javax.transaction.Transactional;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class LoginControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Test
    void shouldLogin() throws Exception {
        User user = userRepository.save(User.builder()
                .firstName("John")
                .lastName("John")
                .login("john")
                .mail("john@gmail.com")
                .password(passwordEncoder.encode("pass"))
                        .roles(Collections.singletonList(new Role(null, "Role_USER")))
                .build());

        mockMvc.perform(post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new LoginDto(user.getLogin(), "pass"))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists());

    }

    @Test
    void shouldNotLogin() throws Exception {
        User user = userRepository.save(User.builder()
                .firstName("John")
                .lastName("John")
                .login("john")
                .mail("john@gmail.com")
                .password(passwordEncoder.encode("pass"))
                .roles(Collections.singletonList(new Role(null, "Role_USER")))
                .build());

        mockMvc.perform(post("/api/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsBytes(new LoginDto(user.getLogin(), "password"))))
                .andExpect(status().isUnauthorized())
                .andExpect(jsonPath("$").doesNotExist());

    }
}

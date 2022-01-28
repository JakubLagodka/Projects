package pl.lagodka.shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import pl.lagodka.shop.model.dao.Basket;
import pl.lagodka.shop.model.dao.Product;
import pl.lagodka.shop.model.dao.User;
import pl.lagodka.shop.model.dto.BasketDto;
import pl.lagodka.shop.repository.BasketRepository;
import pl.lagodka.shop.repository.ProductRepository;
import pl.lagodka.shop.repository.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.yml")
@Transactional
public class BasketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @WithMockUser(username = "john")
    void shouldGetBasket() throws Exception {

        Product product = productRepository.save(Product.builder()
                .name("pen")
                .price(9.99)
                .available(true)
                .quantity(10)
                .createdBy("user")
                .createdDate(LocalDateTime.of(2022, 1, 5, 12, 40, 50))
                .imageUrl("http:://https://m")
                .lastModifiedBy("jan")
                .lastModifiedDate(LocalDateTime.of(2022, 1, 15, 12, 40, 50))
                .build());

        User user = userRepository.save(User.builder()
                .firstName("John")
                .lastName("John")
                .login("john")
                .mail("john@gmail.com")
                .password("pass")
                .build());
                basketRepository.save(Basket.builder()
                .product(product)
                .quantity(10)
                .user(user)
                .build());
//        basketRepository.save(Basket.builder()
//                .product(Product.builder()
//                        .name("pen")
//                        .price(9.99)
//                        .available(true)
//                        .quantity(10)
//                        .createdBy("user")
//                        .createdDate(LocalDateTime.of(2022, 1, 5, 12, 40, 50))
//                        .imageUrl("http:://https://m")
//                        .lastModifiedBy("jan")
//                        .lastModifiedDate(LocalDateTime.of(2022, 1, 15, 12, 40, 50))
//                        .build())
//                .quantity(10)
//                .user(User.builder()
//                        .firstName("John")
//                        .lastName("John")
//                        .login("john")
//                        .mail("john@gmail.com")
//                        .password("pass")
//                        .build())
//                .build());


        mockMvc.perform(get("/api/basket")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "john")
    void shouldAddProductToBasket() throws Exception {

        Product product = productRepository.save(Product.builder()
                .name("pen")
                .price(9.99)
                .available(true)
                .quantity(10)
                .createdBy("user")
                .createdDate(LocalDateTime.of(2022, 1, 5, 12, 40, 50))
                .imageUrl("http:://https://m")
                .lastModifiedBy("jan")
                .lastModifiedDate(LocalDateTime.of(2022, 1, 15, 12, 40, 50))
                .build());

        User user = userRepository.save(User.builder()
                .firstName("John")
                .lastName("John")
                .login("john")
                .mail("john@gmail.com")
                .password("pass")
                .build());
        basketRepository.save(Basket.builder()
                .product(product)
                .quantity(10)
                .user(user)
                .build());

        mockMvc.perform(post("/api/basket")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(BasketDto.builder()
                                .productId(product.getId())
                                .quantity(0)
                                .build())))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "john")
    void shouldClearBasket() throws Exception {

        Product product = productRepository.save(Product.builder()
                .name("pen")
                .price(9.99)
                .available(true)
                .quantity(10)
                .createdBy("user")
                .createdDate(LocalDateTime.of(2022, 1, 5, 12, 40, 50))
                .imageUrl("http:://https://m")
                .lastModifiedBy("jan")
                .lastModifiedDate(LocalDateTime.of(2022, 1, 15, 12, 40, 50))
                .build());

        User user = userRepository.save(User.builder()
                .firstName("John")
                .lastName("John")
                .login("john")
                .mail("john@gmail.com")
                .password("pass")
                .build());
        basketRepository.save(Basket.builder()
                .product(product)
                .quantity(10)
                .user(user)
                .build());

        mockMvc.perform(delete("/api/basket")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "john")
    void shouldDeleteProductByProductId() throws Exception {

        Product product = productRepository.save(Product.builder()
                .name("pen")
                .price(9.99)
                .available(true)
                .quantity(10)
                .createdBy("user")
                .createdDate(LocalDateTime.of(2022, 1, 5, 12, 40, 50))
                .imageUrl("http:://https://m")
                .lastModifiedBy("jan")
                .lastModifiedDate(LocalDateTime.of(2022, 1, 15, 12, 40, 50))
                .build());

        User user = userRepository.save(User.builder()
                .firstName("John")
                .lastName("John")
                .login("john")
                .mail("john@gmail.com")
                .password("pass")
                .build());
        basketRepository.save(Basket.builder()
                .product(product)
                .quantity(10)
                .user(user)
                .build());

        Product save = productRepository.save(Product.builder()
                .name("pen")
                .price(9.99)
                .available(true)
                .quantity(10)
                .createdBy("user")
                .createdDate(LocalDateTime.of(2022, 1, 5, 12, 40, 50))
                .imageUrl("http:://https://m")
                .lastModifiedBy("jan")
                .lastModifiedDate(LocalDateTime.of(2022, 1, 15, 12, 40, 50))
                .build());
        mockMvc.perform(delete("/api/basket/" + save.getId())
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk());
    }
}

package pl.lagodka.shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import pl.lagodka.shop.model.OrderStatus;
import pl.lagodka.shop.model.dao.*;
import pl.lagodka.shop.model.dto.OrderDto;
import pl.lagodka.shop.repository.*;

import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldSaveOrder() throws Exception {
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


        OrderDetails orderDetails = orderDetailsRepository.save(OrderDetails.builder()
                .user(user)
                .date(LocalDateTime.now())
                .orderNumber("order")
                .status(OrderStatus.CREATED)
                .build());


        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(OrderDto.builder()
                                .quantity(10.0)
                                .orderDetails(orderDetails)
                                .product(product)
                                .build())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());

    }


    @Test
    void shouldNotGetOrderWhenUserIsUnauthorized() throws Exception {
        mockMvc.perform(get("/api/orders/1"))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }


    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldGetOrder() throws Exception {
        Order save = orderRepository.save(Order.builder()
                .quantity(10.0)
                .build());
        mockMvc.perform(get("/api/orders/" + save.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldNotGetOrderWhenOrderDoesNotExist() throws Exception {
        mockMvc.perform(get("/api/orders/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldGetOrderPage() throws Exception {

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


        OrderDetails orderDetails = orderDetailsRepository.save(OrderDetails.builder()
                .user(user)
                .date(LocalDateTime.now())
                .orderNumber("order")
                .status(OrderStatus.CREATED)
                .build());

        orderRepository.save(Order.builder()
                .quantity(10.0)
                .orderDetails(orderDetails)
                .product(product)
                .build());
        mockMvc.perform(get("/api/orders/")
                        .queryParam("page", "0")
                        .queryParam("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(1))
                .andExpect(jsonPath("$.content[*].id").exists());
    }


    @Test
    void shouldNotUpdateOrderWhenUserIsUnauthorized() throws Exception {
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


        OrderDetails orderDetails = orderDetailsRepository.save(OrderDetails.builder()
                .user(user)
                .date(LocalDateTime.now())
                .orderNumber("order")
                .status(OrderStatus.CREATED)
                .build());

        Order order = orderRepository.save(Order.builder()
                .quantity(10.0)
                .orderDetails(orderDetails)
                .product(product)
                .build());
        mockMvc.perform(put("/api/orders/" + order.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(OrderDto.builder()
                                .quantity(10.0)
                                .build())))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldUpdateOrder() throws Exception {
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


        OrderDetails orderDetails = orderDetailsRepository.save(OrderDetails.builder()
                .user(user)
                .date(LocalDateTime.now())
                .orderNumber("order")
                .status(OrderStatus.CREATED)
                .build());

        Order order = orderRepository.save(Order.builder()
                .quantity(10.0)
                .orderDetails(orderDetails)
                .product(product)
                .build());
        mockMvc.perform(put("/api/orders/" + order.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(OrderDto.builder()
                                .quantity(10.0)
                                .orderDetails(orderDetails)
                                .product(product)
                                .build())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldNotUpdateOrderWhenOrderDoesNotExist() throws Exception {
        mockMvc.perform(put("/api/orders/1"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldDeleteOrder() throws Exception {
        Order save = orderRepository.save(Order.builder()
                .quantity(10.0)
                .build());
        mockMvc.perform(delete("/api/orders/" + save.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void shouldNotDeleteOrderWhenUserIsUnauthorized() throws Exception {
        Order save = orderRepository.save(Order.builder()
                .quantity(10.0)
                .build());
        mockMvc.perform(delete("/api/orders/" + save.getId()))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldNotDeleteOrderWhenOrderDoesNotExist() throws Exception {
        mockMvc.perform(delete("/api/orders/1"))
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$").doesNotExist());
    }
}

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
import pl.lagodka.shop.model.dao.Product;
import pl.lagodka.shop.model.dto.BasketDto;
import pl.lagodka.shop.model.dto.UserDto;
import pl.lagodka.shop.repository.ProductRepository;

import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
public class BasketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @WithMockUser(username = "john")
    void shouldGetBasket() throws Exception {
        mockMvc.perform(get("/api/basket")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "john")
    void shouldAddProductToBasket() throws Exception {
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

        mockMvc.perform(post("/api/basket")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(BasketDto.builder()
                                .productId(1L)
                                .quantity(10)
                                .build())))
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "john")
    void shouldClearBasket() throws Exception {
        mockMvc.perform(delete("/api/basket")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "john")
    void shouldDeleteProductByProductId() throws Exception {
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
                .andExpect(status().isNotFound());
    }
}

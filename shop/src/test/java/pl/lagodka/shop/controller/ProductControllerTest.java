package pl.lagodka.shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import pl.lagodka.shop.model.dao.Product;
import pl.lagodka.shop.model.dto.ProductDto;
import pl.lagodka.shop.repository.ProductRepository;

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
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProductRepository productRepository;

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldSaveProduct() throws Exception {
        MockMultipartFile file = new MockMultipartFile("image", "file.png", MediaType.IMAGE_PNG_VALUE,
                new byte[0]);
        MockMultipartFile productDto = new MockMultipartFile("productDto", "", MediaType.APPLICATION_JSON_VALUE,
                objectMapper.writeValueAsBytes(ProductDto.builder()
                        .name("pen")
                        .price(9.99)
                        .available(true)
                        .quantity(10)
                        .build()));

        mockMvc.perform(multipart("/api/products")
                        .file(file)
                        .file(productDto)
                        .with(processor -> {
                            processor.setMethod(HttpMethod.POST.name());
                            return processor;
                        }))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("pen"))
                .andExpect(jsonPath("$.price").value(9.99))
                .andExpect(jsonPath("$.available").value(true))
                .andExpect(jsonPath("$.quantity").value(10))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.createdDate").exists())
                .andExpect(jsonPath("$.createdBy").value("user"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldNotSaveProductWhenIncorrectFileExtension() throws Exception {
        MockMultipartFile file = new MockMultipartFile("image", "file.txt", MediaType.IMAGE_PNG_VALUE,
                new byte[0]);

        MockMultipartFile productDto = new MockMultipartFile("productDto", "", MediaType.APPLICATION_JSON_VALUE,
                objectMapper.writeValueAsBytes(ProductDto.builder()
                        .name("pen")
                        .price(9.99)
                        .available(true)
                        .quantity(10)
                        .build()));

        mockMvc.perform(multipart("/api/products")
                        .file(file)
                        .file(productDto)
                        .with(processor -> {
                            processor.setMethod(HttpMethod.POST.name());
                            return processor;
                        }))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser
    void shouldNotSaveProductWhenUserIsUnauthorized() throws Exception {
        MockMultipartFile file = new MockMultipartFile("image", "file.png", MediaType.IMAGE_PNG_VALUE,
                new byte[0]);
        MockMultipartFile productDto = new MockMultipartFile("productDto", "", MediaType.APPLICATION_JSON_VALUE,
                objectMapper.writeValueAsBytes(ProductDto.builder()
                        .name("pen")
                        .price(9.99)
                        .available(true)
                        .quantity(10)
                        .build()));

        mockMvc.perform(multipart("/api/products")
                        .file(file)
                        .file(productDto)
                        .with(processor -> {
                            processor.setMethod(HttpMethod.POST.name());
                            return processor;
                        }))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldUpdateProduct() throws Exception {
        MockMultipartFile file = new MockMultipartFile("image", "file.png", MediaType.IMAGE_PNG_VALUE,
                new byte[0]);
        MockMultipartFile productDto = new MockMultipartFile("productDto", "", MediaType.APPLICATION_JSON_VALUE,
                objectMapper.writeValueAsBytes(ProductDto.builder()
                        .name("pen")
                        .price(9.99)
                        .available(true)
                        .quantity(10)
                        .build()));

        Product save = productRepository.save(Product.builder()
                .name("pen")
                .price(9.99)
                .available(true)
                .quantity(10)
                .build());

        mockMvc.perform(multipart("/api/products/" +save.getId())
                        .file(file)
                        .file(productDto)
                        .with(processor -> {
                            processor.setMethod(HttpMethod.PUT.name());
                            return processor;
                        }))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("pen"))
                .andExpect(jsonPath("$.price").value(9.99))
                .andExpect(jsonPath("$.available").value(true))
                .andExpect(jsonPath("$.quantity").value(10))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.createdDate").exists())
                .andExpect(jsonPath("$.createdBy").value("user"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldNotUpdateProductWhenIncorrectFileExtension() throws Exception {
        MockMultipartFile file = new MockMultipartFile("image", "file.txt", MediaType.IMAGE_PNG_VALUE,
                new byte[0]);

        MockMultipartFile productDto = new MockMultipartFile("productDto", "", MediaType.APPLICATION_JSON_VALUE,
                objectMapper.writeValueAsBytes(ProductDto.builder()
                        .name("pen")
                        .price(9.99)
                        .available(true)
                        .quantity(10)
                        .build()));

        Product save = productRepository.save(Product.builder()
                .name("pen")
                .price(9.99)
                .available(true)
                .quantity(10)
                .build());

        mockMvc.perform(multipart("/api/products/" +save.getId())
                        .file(file)
                        .file(productDto)
                        .with(processor -> {
                            processor.setMethod(HttpMethod.PUT.name());
                            return processor;
                        }))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser
    void shouldNotUpdateProductWhenUserIsUnauthorized() throws Exception {
        MockMultipartFile file = new MockMultipartFile("image", "file.png", MediaType.IMAGE_PNG_VALUE,
                new byte[0]);
        MockMultipartFile productDto = new MockMultipartFile("productDto", "", MediaType.APPLICATION_JSON_VALUE,
                objectMapper.writeValueAsBytes(ProductDto.builder()
                        .name("pen")
                        .price(9.99)
                        .available(true)
                        .quantity(10)
                        .build()));
        Product save = productRepository.save(Product.builder()
                .name("pen")
                .price(9.99)
                .available(true)
                .quantity(10)
                .build());

        mockMvc.perform(multipart("/api/products/" +save.getId())
                        .file(file)
                        .file(productDto)
                        .with(processor -> {
                            processor.setMethod(HttpMethod.PUT.name());
                            return processor;
                        }))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void shouldGetProductByGivenId() throws Exception {
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

        mockMvc.perform(get("/api/products/" + save.getId())
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("pen"))
                .andExpect(jsonPath("$.price").value(9.99))
                .andExpect(jsonPath("$.quantity").value(10))
                .andExpect(jsonPath("$.available").value(true));
    }

    @Test
    void shouldNotGetProductWhenProductDoesNotExist() throws Exception {

        mockMvc.perform(get("/api/products/1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void shouldGetProductPage() throws Exception {
        productRepository.save(Product.builder()
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

        mockMvc.perform(get("/api/products/")
                        .queryParam("page", "0")
                        .queryParam("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(1))
                .andExpect(jsonPath("$.content[*].id").exists())
                .andExpect(jsonPath("$.content[*].price", containsInAnyOrder(9.99)))
                .andExpect(jsonPath("$.content[*].available", containsInAnyOrder(true)))
                .andExpect(jsonPath("$.content[*].quantity", containsInAnyOrder(10.0)))
                .andExpect(jsonPath("$.content[*].name", containsInAnyOrder("pen")))
                .andExpect(jsonPath("$.content[*].createdBy", containsInAnyOrder("user")))
                .andExpect(jsonPath("$.content[*].lastModifiedDate").exists())
                .andExpect(jsonPath("$.content[*].lastModifiedBy", containsInAnyOrder("jan")))
                .andExpect(jsonPath("$.content[*].revisionType").doesNotExist())
                .andExpect(jsonPath("$.content[*].revisionNumber").doesNotExist());
    }


    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldDeleteProduct() throws Exception {
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
        mockMvc.perform(delete("/api/products/" + save.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(username = "john")
    void shouldNotDeleteProductWhenUserIsNotAdmin() throws Exception {
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
        mockMvc.perform(delete("/api/products/" + save.getId()))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldNotDeleteProductWhenProductDoesNotExist() throws Exception {
        mockMvc.perform(delete("/api/products/1"))
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$").doesNotExist());
    }
}

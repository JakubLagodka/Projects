package pl.lagodka.shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class BasketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
//nie zauważyłem, że jest preautorize
//    @Test
//    void shouldGetBasket() throws Exception {
//        mockMvc.perform(get("/api/basket")
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void shouldAddProductToBasket() throws Exception {
//        mockMvc.perform(post("/api/basket")
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void shouldClearBasket() throws Exception {
//        mockMvc.perform(delete("/api/basket")
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void shouldDeleteProductByProductId() throws Exception {
//        mockMvc.perform(delete("/api/basket/1")
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isOk());
//    }
}

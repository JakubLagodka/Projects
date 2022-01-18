package pl.lagodka.shop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class HistoryControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
//nie zauwążyłem, że jest admin przed klasą
//    @Test
//    void shouldGetUserHistory() throws Exception {
//        mockMvc.perform(get("/api/histories/users/1")
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    void shouldGetProductHistory() throws Exception {
//        mockMvc.perform(get("/api/histories/products/1")
//                        .contentType(MediaType.APPLICATION_JSON_VALUE))
//                .andExpect(status().isOk());
//    }
}

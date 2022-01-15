package pl.lagodka.shop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import pl.lagodka.shop.model.dao.User;
import pl.lagodka.shop.model.dto.UserDto;
import pl.lagodka.shop.repository.UserRepository;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.yml")
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private UserRepository userRepository;

    @Test
    void shouldSaveUser() throws Exception {
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(UserDto.builder()
                                .firstName("Jan")
                                .lastName("Kowalski")
                                .login("jan")
                                .mail("jan@gmail.com")
                                .password("password")
                                .confirmPassword("password")
                                .build())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.login").value("jan"))
                .andExpect(jsonPath("$.mail").value("jan@gmail.com"))
                .andExpect(jsonPath("$.firstName").value("Jan"))
                .andExpect(jsonPath("$.lastName").value("Kowalski"))
                .andExpect(jsonPath("$.createdDate").exists())
                .andExpect(jsonPath("$.createdBy").value("anonymousUser"))
                .andExpect(jsonPath("$.lastModifiedDate").exists())
                .andExpect(jsonPath("$.lastModifiedBy").value("anonymousUser"))
                .andExpect(jsonPath("$.revisionType").doesNotExist())
                .andExpect(jsonPath("$.revisionNumber").doesNotExist());
    }

    @Test
    void shouldNotSaveUserWhenAlreadyExists() throws Exception {
        userRepository.save(User.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .login("jan")
                .mail("jan@gmail.com")
                .password("password")
                .build());
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(UserDto.builder()
                        .firstName("Jan")
                        .lastName("Kowalski")
                        .login("jan")
                        .mail("jan@gmail.com")
                        .password("password")
                        .confirmPassword("password")
                        .build())))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void shouldNotSaveUserWhenUncorrectedData() throws Exception {
        mockMvc.perform(post("/api/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(UserDto.builder()
                        .password("password")
                        .confirmPassword("password")
                        .mail("")
                        .firstName("")
                        .lastName("")
                        .login("")
                        .build())))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[*].fieldName",containsInAnyOrder("login","lastName","mail","firstName")))
                .andExpect(jsonPath("$[*].message",containsInAnyOrder("must not be blank","must not be blank","must not be blank","must not be blank")));

    }
}

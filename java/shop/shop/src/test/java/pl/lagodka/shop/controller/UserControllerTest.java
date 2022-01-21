package pl.lagodka.shop.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import pl.lagodka.shop.model.dao.User;
import pl.lagodka.shop.model.dto.UserDto;
import pl.lagodka.shop.repository.UserRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.yml")
@Transactional
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
                .andExpect(jsonPath("$.password").doesNotExist())
                .andExpect(jsonPath("$.confirmPassword").doesNotExist())
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
                .createdBy("user")
                .createdDate(LocalDateTime.of(2022, 1, 5, 12, 40, 50))
                .lastModifiedBy("user")
                .lastModifiedDate(LocalDateTime.of(2022, 1, 15, 12, 40, 50))
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
                .andExpect(jsonPath("$[*].fieldName", containsInAnyOrder("login", "lastName", "mail", "firstName")))
                .andExpect(jsonPath("$[*].message", containsInAnyOrder("must not be blank", "must not be blank", "must not be blank", "must not be blank")));

    }

    @Test
    void shouldNotSaveUserWhenNotValidPassword() throws Exception {
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(UserDto.builder()
                                .password("password")
                                .confirmPassword("pass")
                                .mail("jan@gmail.com")
                                .firstName("Jan")
                                .lastName("Nowak")
                                .login("jak")
                                .build())))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$[*].fieldName", containsInAnyOrder("login", "lastName", "mail", "firstName")))
                .andExpect(jsonPath("$[*].message", containsInAnyOrder("must not be blank", "must not be blank", "must not be blank", "must not be blank")));

    }

    @Test
    void shouldNotGetUserWhenUserIsUnauthorized() throws Exception {
        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void shouldNotGetUserWhenUserHasNotAccess() throws Exception {
        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }

    //dopisac!
    @Test
    @WithMockUser(username = "john")
    void shouldGetUserWhenUserHasAccess() throws Exception {
        User save = userRepository.save(User.builder()
                .firstName("John")
                .lastName("John")
                .login("john")
                .mail("john@gmail.com")
                .password("pass")
                .build());
        mockMvc.perform(get("/api/users/" + save.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }

    //dopisac!
    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldGetUserWhenUserIsAdmin() throws Exception {
        User save = userRepository.save(User.builder()
                .firstName("John")
                .lastName("John")
                .login("john")
                .mail("john@gmail.com")
                .password("pass")
                .build());
        mockMvc.perform(get("/api/users/" + save.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldNotGetUserWhenUserDoesNotExist() throws Exception {
        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldGetUserPage() throws Exception {
        userRepository.save(User.builder()
                .firstName("John")
                .lastName("John")
                .login("john")
                .mail("john@gmail.com")
                .password("pass")
                .build());
        mockMvc.perform(get("/api/users/")
                        .queryParam("page", "0")
                        .queryParam("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(1))
                .andExpect(jsonPath("$.content[*].firstName",containsInAnyOrder("John")));

    }
}

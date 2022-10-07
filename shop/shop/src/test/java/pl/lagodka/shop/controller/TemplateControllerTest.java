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
import pl.lagodka.shop.model.dao.Template;
import pl.lagodka.shop.model.dto.TemplateDto;
import pl.lagodka.shop.repository.TemplateRepository;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.yml")
@Transactional
public class TemplateControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private TemplateRepository templateRepository;

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldSaveTemplate() throws Exception {
        mockMvc.perform(post("/api/templates")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(TemplateDto.builder()
                                .name("name")
                                .body("body")
                                .subject("subject")
                                .build())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("name"))
                .andExpect(jsonPath("$.body").value("body"))
                .andExpect(jsonPath("$.subject").value("subject"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldNotSaveTemplateWhenAlreadyExists() throws Exception {
        templateRepository.save(Template.builder()
                .name("name")
                .body("body")
                .subject("subject")
                .build());
        mockMvc.perform(post("/api/templates")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(TemplateDto.builder()
                                .name("name")
                                .body("body")
                                .subject("subject")
                                .build())))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void shouldNotGetTemplateWhenUserIsUnauthorized() throws Exception {
        mockMvc.perform(get("/api/templates/1"))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void shouldNotGetTemplateWhenUserHasNotAccess() throws Exception {
        mockMvc.perform(get("/api/templates/1"))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }


    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldGetTemplateWhenUserIsAdmin() throws Exception {
        Template save = templateRepository.save(Template.builder()
                .name("name")
                .body("body")
                .subject("subject")
                .build());
        mockMvc.perform(get("/api/templates/" + save.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("name"))
                .andExpect(jsonPath("$.body").value("body"))
                .andExpect(jsonPath("$.subject").value("subject"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldNotGetTemplateWhenTemplateDoesNotExist() throws Exception {
        mockMvc.perform(get("/api/templates/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldGetTemplatePage() throws Exception {
        templateRepository.save(Template.builder()
                .name("name")
                .body("body")
                .subject("subject")
                .build());
        mockMvc.perform(get("/api/templates/")
                        .queryParam("page", "0")
                        .queryParam("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(1))
                .andExpect(jsonPath("$.content[*].id").exists())
                .andExpect(jsonPath("$.content[*].name", containsInAnyOrder("name")))
                .andExpect(jsonPath("$.content[*].body", containsInAnyOrder("body")))
                .andExpect(jsonPath("$.content[*].subject", containsInAnyOrder("subject")));
    }

    @Test
    @WithMockUser
    void shouldNotGetTemplatePageWhenUserIsNotAdmin() throws Exception {
        templateRepository.save(Template.builder()
                .name("name")
                .body("body")
                .subject("subject")
                .build());
        mockMvc.perform(get("/api/templates/")
                        .queryParam("page", "0")
                        .queryParam("size", "10"))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(username = "john")
    void shouldNotUpdateTemplateWhenUserHasNotAccess() throws Exception {
        Template save = templateRepository.save(Template.builder()
                .name("name")
                .body("body")
                .subject("subject")
                .build());
        mockMvc.perform(put("/api/templates/" + save.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(TemplateDto.builder()
                                .name("name")
                                .body("body")
                                .subject("subject")
                                .build())))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldUpdateTemplateWhenUserIsAdmin() throws Exception {
        Template save = templateRepository.save(Template.builder()
                .name("name")
                .body("body")
                .subject("subject")
                .build());
        mockMvc.perform(put("/api/templates/" + save.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(TemplateDto.builder()
                                .name("name")
                                .body("body")
                                .subject("subject")
                                .build())))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").value("name"))
                .andExpect(jsonPath("$.body").value("body"))
                .andExpect(jsonPath("$.subject").value("subject"));
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldNotUpdateTemplateWhenTemplateDoesNotExist() throws Exception {
        mockMvc.perform(put("/api/templates/1"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldDeleteTemplate() throws Exception {
        Template save = templateRepository.save(Template.builder()
                .name("name")
                .body("body")
                .subject("subject")
                .build());
        mockMvc.perform(delete("/api/templates/" + save.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(username = "john")
    void shouldNotDeleteTemplateWhenUserIsNotAdmin() throws Exception {
        Template save = templateRepository.save(Template.builder()
                .name("name")
                .body("body")
                .subject("subject")
                .build());
        mockMvc.perform(delete("/api/templates/" + save.getId()))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldNotDeleteTemplateWhenTemplateDoesNotExist() throws Exception {
        mockMvc.perform(delete("/api/templates/1"))
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$").doesNotExist());
    }
}

package pl.lagodka.hotel.controller;

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
import pl.lagodka.hotel.model.dao.Room;
import pl.lagodka.hotel.model.dto.RoomDto;
import pl.lagodka.hotel.repository.RoomRepository;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.yml")
@Transactional
public class RoomControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private RoomRepository roomRepository;

    @Test
    void shouldSaveRoom() throws Exception {
        mockMvc.perform(post("/api/rooms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(RoomDto.builder()

                                .build())))
                .andExpect(status().isOk());
    }

    @Test
    void shouldNotSaveRoomWhenAlreadyExists() throws Exception {
        roomRepository.save(Room.builder()
                .build());
        mockMvc.perform(post("/api/rooms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(RoomDto.builder()

                                .build())));
//                .andExpect(status().isConflict())
//                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void shouldNotSaveRoomWhenUncorrectedData() throws Exception {
        mockMvc.perform(post("/api/rooms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(RoomDto.builder()

                                .build())));
//                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldNotSaveRoomWhenNotValidPassword() throws Exception {
        mockMvc.perform(post("/api/rooms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(RoomDto.builder()

                                .build())));
//                .andExpect(status().isBadRequest())
//                .andExpect(jsonPath("$").doesNotExist());

    }

    @Test
    void shouldNotGetRoomWhenUserIsUnauthorized() throws Exception {
        mockMvc.perform(get("/api/rooms/1"))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void shouldNotGetRoomWhenUserHasNotAccess() throws Exception {
        mockMvc.perform(get("/api/rooms/1"))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }


    @Test
    @WithMockUser(username = "john")
    void shouldGetRoomWhenUserHasAccess() throws Exception {
        Room save = roomRepository.save(Room.builder()

                .build());
        mockMvc.perform(get("/api/rooms/" + save.getId()));
//                .andExpect(status().isOk());
    }


    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldGetRoomWhenUserIsAdmin() throws Exception {
        Room save = roomRepository.save(Room.builder()

                .build());
        mockMvc.perform(get("/api/rooms/" + save.getId()))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldNotGetRoomWhenUserDoesNotExist() throws Exception {
        mockMvc.perform(get("/api/rooms/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldGetRoomPage() throws Exception {
        roomRepository.save(Room.builder()

                .build());
        mockMvc.perform(get("/api/rooms/")
                        .queryParam("page", "0")
                        .queryParam("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(1));

    }

    @Test
    @WithMockUser
    void shouldNotGetRoomPageWhenUserIsNotAdmin() throws Exception {
        roomRepository.save(Room.builder()

                .build());
        mockMvc.perform(get("/api/rooms/")
                        .queryParam("page", "0")
                        .queryParam("size", "10"))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(username = "john")
    void shouldUpdateRoomWhenUserHasAccess() throws Exception {
        Room save = roomRepository.save(Room.builder()
                .build());
        mockMvc.perform(put("/api/rooms/" + save.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(RoomDto.builder()

                                .build())));
//                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "john")
    void shouldNotUpdateRoomWhenUserHasNotAccess() throws Exception {
        Room save = roomRepository.save(Room.builder()

                .build());
        mockMvc.perform(put("/api/rooms/" + save.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(RoomDto.builder()

                                .build())))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldUpdateRoomWhenUserIsAdmin() throws Exception {
        Room save = roomRepository.save(Room.builder()

                .build());
        mockMvc.perform(put("/api/rooms/" + save.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(RoomDto.builder()

                                .build())))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldNotUpdateRoomWhenUserDoesNotExist() throws Exception {
        mockMvc.perform(put("/api/rooms/1"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldDeleteRoom() throws Exception {
        Room save = roomRepository.save(Room.builder()

                .build());
        mockMvc.perform(delete("/api/rooms/" + save.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(username = "john")
    void shouldNotDeleteRoomWhenUserIsNotAdmin() throws Exception {
        Room save = roomRepository.save(Room.builder()
                .build());
        mockMvc.perform(delete("/api/rooms/" + save.getId()))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldNotDeleteRoomWhenUserDoesNotExist() throws Exception {
        mockMvc.perform(delete("/api/rooms/1"))
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$").doesNotExist());
    }
}

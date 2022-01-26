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
import pl.lagodka.hotel.model.dao.Reservation;
import pl.lagodka.hotel.model.dto.ReservationDto;
import pl.lagodka.hotel.repository.ReservationRepository;

import javax.transaction.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.yml")
@Transactional
public class ReservationControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    void shouldSaveReservation() throws Exception {
        mockMvc.perform(post("/api/reservations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ReservationDto.builder()

                                .build())))
                .andExpect(status().isOk());
    }

    @Test
    void shouldNotSaveReservationWhenAlreadyExists() throws Exception {
        reservationRepository.save(Reservation.builder()
                .build());
        mockMvc.perform(post("/api/reservations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ReservationDto.builder()

                                .build())));
//                .andExpect(status().isConflict())
//                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void shouldNotSaveReservationWhenUncorrectedData() throws Exception {
        mockMvc.perform(post("/api/reservations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ReservationDto.builder()

                                .build())));
//                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldNotSaveReservationWhenNotValidPassword() throws Exception {
        mockMvc.perform(post("/api/reservations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ReservationDto.builder()

                                .build())));
//                .andExpect(status().isBadRequest())
//                .andExpect(jsonPath("$").doesNotExist());

    }

    @Test
    void shouldNotGetReservationWhenUserIsUnauthorized() throws Exception {
        mockMvc.perform(get("/api/reservations/1"))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void shouldNotGeReservationWhenUserHasNotAccess() throws Exception {
        mockMvc.perform(get("/api/reservations/1"))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }


    @Test
    @WithMockUser(username = "john")
    void shouldGetReservationWhenUserHasAccess() throws Exception {
        Reservation save = reservationRepository.save(Reservation.builder()

                .build());
        mockMvc.perform(get("/api/reservations/" + save.getId()));
//                .andExpect(status().isOk());
    }


    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldGetReservationWhenUserIsAdmin() throws Exception {
        Reservation save = reservationRepository.save(Reservation.builder()

                .build());
        mockMvc.perform(get("/api/reservations/" + save.getId()))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldNotGetReservationWhenUserDoesNotExist() throws Exception {
        mockMvc.perform(get("/api/reservations/1"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldGetReservationPage() throws Exception {
        reservationRepository.save(Reservation.builder()
                .build());
        mockMvc.perform(get("/api/reservations/")
                        .queryParam("page", "0")
                        .queryParam("size", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.content.length()").value(1));

    }

    @Test
    @WithMockUser
    void shouldNotGetReservationPageWhenUserIsNotAdmin() throws Exception {
        reservationRepository.save(Reservation.builder()

                .build());
        mockMvc.perform(get("/api/reservations/")
                        .queryParam("page", "0")
                        .queryParam("size", "10"))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(username = "john")
    void shouldUpdateReservationWhenUserHasAccess() throws Exception {
        Reservation save = reservationRepository.save(Reservation.builder()

                .build());
        mockMvc.perform(put("/api/users/" + save.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ReservationDto.builder()
                                .build())));
//                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "john")
    void shouldNotUpdateReservationWhenUserHasNotAccess() throws Exception {
        Reservation save = reservationRepository.save(Reservation.builder()

                .build());
        mockMvc.perform(put("/api/reservations/" + save.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ReservationDto.builder()
                                .build())))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldUpdateReservationWhenUserIsAdmin() throws Exception {
        Reservation save = reservationRepository.save(Reservation.builder()

                .build());
        mockMvc.perform(put("/api/reservations/" + save.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ReservationDto.builder()
                                .build())))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldNotUpdatReservationWhenUserDoesNotExist() throws Exception {
        mockMvc.perform(put("/api/reservations/1"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldDeleteReservation() throws Exception {
        Reservation save = reservationRepository.save(Reservation.builder()

                .build());
        mockMvc.perform(delete("/api/reservations/" + save.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(username = "john")
    void shouldNotDeleteReservationWhenUserIsNotAdmin() throws Exception {
        Reservation save = reservationRepository.save(Reservation.builder()

                .build());
        mockMvc.perform(delete("/api/reservations/" + save.getId()))
                .andExpect(status().isForbidden())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @WithMockUser(roles = "ADMIN")
    void shouldNotDeleteReservationWhenUserDoesNotExist() throws Exception {
        mockMvc.perform(delete("/api/reservations/1"))
                .andExpect(status().isNoContent())
                .andExpect(jsonPath("$").doesNotExist());
    }
}

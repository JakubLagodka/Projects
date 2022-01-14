package pl.lagodka.hotel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.lagodka.hotel.mapper.ReservationMapper;
import pl.lagodka.hotel.model.dto.ReservationDto;
import pl.lagodka.hotel.service.ReservationService;
import pl.lagodka.hotel.validator.group.Create;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
@Validated
public class ReservationController {
    private final ReservationService reservationService;

    private final ReservationMapper reservationMapper;

    @PostMapping
    @Validated(Create.class)
    public ReservationDto saveReservation(@RequestBody @Valid ReservationDto reservation) {
        return reservationMapper.toDto(reservationService.create(reservationMapper.toDao(reservation)));
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated() && hasRole('ADMIN')")
    public ReservationDto getReservationById(@PathVariable Long id) {
        return reservationMapper.toDto(reservationService.getById(id));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Page<ReservationDto> getReservationPage(@RequestParam int page, @RequestParam int size) {
        return reservationService.getPage(PageRequest.of(page, size))
                .map(reservationMapper::toDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated() && hasRole('ADMIN')")
    public ReservationDto updateReservation(@RequestBody @Valid ReservationDto reservation, @PathVariable Long id){
        return reservationMapper.toDto(reservationMapper.update(reservationMapper.toDao(reservation), id));
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteReservation(@PathVariable Long id){
        reservationService.delete(id);
    }
}

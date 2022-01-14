package pl.lagodka.hotel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.lagodka.hotel.mapper.ReservationMapper;
import pl.lagodka.hotel.mapper.RoomMapper;
import pl.lagodka.hotel.model.dto.ReservationDto;
import pl.lagodka.hotel.model.dto.RoomDto;
import pl.lagodka.hotel.service.ReservationService;
import pl.lagodka.hotel.service.RoomService;
import pl.lagodka.hotel.validator.group.Create;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
@Validated
public class RoomController {
    private final RoomService roomService;

    private final RoomMapper roomMapper;

    @PostMapping
    @Validated(Create.class)
    public RoomDto saveRoom(@RequestBody @Valid RoomDto room) {
        return roomMapper.toDto(roomService.create(roomMapper.toDao(room)));
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated() && hasRole('ADMIN')")
    public RoomDto getRoomById(@PathVariable Long id) {
        return roomMapper.toDto(roomService.getById(id));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Page<RoomDto> getRoomPage(@RequestParam int page, @RequestParam int size) {
        return roomService.getPage(PageRequest.of(page, size))
                .map(roomMapper::toDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated() && hasRole('ADMIN')")
    public RoomDto updateRoom(@RequestBody @Valid RoomDto room, @PathVariable Long id){
        return roomMapper.toDto(roomService.update(roomMapper.toDao(room), id));
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteRoom(@PathVariable Long id){
        roomService.delete(id);
    }
}

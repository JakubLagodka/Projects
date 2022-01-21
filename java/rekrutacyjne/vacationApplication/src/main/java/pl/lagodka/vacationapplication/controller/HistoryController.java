package pl.lagodka.vacationapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.lagodka.vacationapplication.mapper.HistoryMapper;
import pl.lagodka.vacationapplication.model.dto.UserDto;
import pl.lagodka.vacationapplication.repository.UserRepository;

@RestController
@RequestMapping("/api/histories")
@RequiredArgsConstructor
@PreAuthorize("hasRole('ADMIN')")
public class HistoryController {

    private final UserRepository userRepository;

    private final HistoryMapper historyMapper;

    @GetMapping("/users/{id}")
    public Page<UserDto> getUserHistory(@PathVariable Long id, @RequestParam int page, @RequestParam int size) {
        return userRepository.findRevisions(id, PageRequest.of(page, size))
                .map(historyMapper::toUserDto);
    }

}

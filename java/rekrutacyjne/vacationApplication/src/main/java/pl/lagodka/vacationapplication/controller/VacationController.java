package pl.lagodka.vacationapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import pl.lagodka.vacationapplication.model.dao.Vacation;
import pl.lagodka.vacationapplication.service.VacationService;

@RestController
@RequestMapping("/api/vacations")
@RequiredArgsConstructor
public class VacationController {
    private final VacationService vacationService;

    @PostMapping
    public Vacation saveUser(@RequestBody Vacation vacation) {
        return vacationService.create(vacation);
    }

    @GetMapping("/{id}")
    public Vacation getUserById(@PathVariable Long id) {
        return vacationService.getById(id);
    }

    @PutMapping("/{id}")
    public Vacation updateUser(@RequestBody Vacation vacation, @PathVariable Long id) {
        return vacationService.update(vacation, id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        vacationService.delete(id);
    }

    @GetMapping
    public Page<Vacation> getUserPage(@RequestParam int page, @RequestParam int size) {
        return vacationService.getPage(PageRequest.of(page, size));
    }
}

package pl.lagodka.vacationapplication.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.lagodka.vacationapplication.model.dao.User;
import pl.lagodka.vacationapplication.model.dao.Vacation;

public interface VacationService {

    Vacation getById(Long id);

    Vacation create(Vacation Vacation);

    Vacation update(Vacation Vacation, Long id);

    void delete(Long id);

    Page<Vacation> getPage(Pageable pageable);

}

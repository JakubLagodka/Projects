package pl.lagodka.vacationapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lagodka.vacationapplication.model.dao.Vacation;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
}

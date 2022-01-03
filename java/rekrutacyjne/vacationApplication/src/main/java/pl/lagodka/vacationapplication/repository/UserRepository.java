package pl.lagodka.vacationapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lagodka.vacationapplication.model.dao.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

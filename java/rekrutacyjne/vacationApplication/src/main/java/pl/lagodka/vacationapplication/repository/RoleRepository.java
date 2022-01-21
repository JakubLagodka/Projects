package pl.lagodka.vacationapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lagodka.vacationapplication.model.dao.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}

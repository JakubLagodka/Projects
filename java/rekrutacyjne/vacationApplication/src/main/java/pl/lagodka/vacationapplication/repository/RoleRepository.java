package pl.lagodka.vacationapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lagodka.vacationapplication.model.dao.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}

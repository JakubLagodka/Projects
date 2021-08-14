package pl.lagodka.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.lagodka.hotel.exception.NotFoundException;
import pl.lagodka.hotel.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>  {
    default Role getById(String code) {
        return findById(code).orElseThrow(() -> new NotFoundException(code));
    }
}

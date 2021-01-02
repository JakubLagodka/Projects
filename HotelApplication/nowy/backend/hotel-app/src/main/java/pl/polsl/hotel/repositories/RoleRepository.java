package pl.polsl.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.polsl.hotel.exceptions.NotFoundException;

import pl.polsl.hotel.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String>  {
    default Role getById(String code) {
        return findById(code).orElseThrow(() -> new NotFoundException(code));
    }
}

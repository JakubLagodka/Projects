package pl.polsl.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.hotel.exceptions.NotFoundException;
import pl.polsl.hotel.models.ActionStatus;

@Repository
public interface StatusRepository extends JpaRepository<ActionStatus, String> {
    default ActionStatus getById(String code) {
        return findById(code).orElseThrow(() -> new NotFoundException(code));
    }
}

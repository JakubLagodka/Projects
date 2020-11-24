package pl.polsl.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.hotel.exceptions.NotFoundException;
import pl.polsl.hotel.models.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    default Activity getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}

package pl.polsl.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.hotel.exceptions.NotFoundException;
import pl.polsl.hotel.models.ActivityType;

@Repository
public interface ActivityTypeRepository extends JpaRepository<ActivityType, String> {
    default ActivityType getById(String code) {
        return findById(code).orElseThrow(() -> new NotFoundException(code));
    }
}

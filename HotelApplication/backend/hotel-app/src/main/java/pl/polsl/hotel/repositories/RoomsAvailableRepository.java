package pl.polsl.hotel.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.hotel.exceptions.NotFoundException;
import pl.polsl.hotel.models.RoomsAvailable;

public interface RoomsAvailableRepository extends JpaRepository<RoomsAvailable, Long> {
    default RoomsAvailable getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}

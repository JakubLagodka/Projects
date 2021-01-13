package pl.polsl.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.hotel.exceptions.NotFoundException;
import pl.polsl.hotel.models.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    default Reservation getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}

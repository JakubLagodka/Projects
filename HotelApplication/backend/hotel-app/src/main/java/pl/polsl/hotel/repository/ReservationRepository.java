package pl.polsl.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.hotel.exception.NotFoundException;
import pl.polsl.hotel.model.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    default Reservation getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}

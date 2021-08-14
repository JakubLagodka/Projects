package pl.lagodka.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lagodka.hotel.exception.NotFoundException;
import pl.lagodka.hotel.model.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    default Reservation getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}

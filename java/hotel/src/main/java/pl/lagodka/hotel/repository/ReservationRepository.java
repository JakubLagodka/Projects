package pl.lagodka.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lagodka.hotel.model.dao.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {
}

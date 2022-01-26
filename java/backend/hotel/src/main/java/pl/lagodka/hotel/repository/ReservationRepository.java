package pl.lagodka.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import pl.lagodka.hotel.model.dao.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation,Long>, RevisionRepository<Reservation,Long,Integer> {
}

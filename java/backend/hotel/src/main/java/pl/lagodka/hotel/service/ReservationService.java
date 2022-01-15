package pl.lagodka.hotel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.lagodka.hotel.model.dao.Reservation;


public interface ReservationService {
    Reservation create(Reservation reservation);

    Reservation update(Reservation reservation, Long id);

    void delete(Long id);

    Reservation getById(Long id);

    Page<Reservation> getPage(Pageable pageable);
}

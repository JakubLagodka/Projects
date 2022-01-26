package pl.lagodka.hotel.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.lagodka.hotel.model.dao.Reservation;
import pl.lagodka.hotel.model.dao.Room;
import pl.lagodka.hotel.repository.ReservationRepository;
import pl.lagodka.hotel.service.ReservationService;
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;

    @Override
    public Reservation create(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Reservation update(Reservation reservation, Long id) {
        Reservation reservationDb = getById(id);
        reservationDb.setPrice(reservation.getPrice());

        return reservationDb;
    }

    @Override
    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override
    public Reservation getById(Long id) {
        return reservationRepository.getById(id);
    }

    @Override
    public Page<Reservation> getPage(Pageable pageable) {
        return reservationRepository.findAll(pageable);
    }
}

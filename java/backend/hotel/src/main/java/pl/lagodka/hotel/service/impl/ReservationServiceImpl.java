package pl.lagodka.hotel.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.lagodka.hotel.model.dao.Reservation;
import pl.lagodka.hotel.service.ReservationService;
@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    @Override
    public Reservation create(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation update(Reservation reservation, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Reservation getById(Long id) {
        return null;
    }

    @Override
    public Page<Reservation> getPage(Pageable pageable) {
        return null;
    }
}

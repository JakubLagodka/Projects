package pl.polsl.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.models.Reservation;

import pl.polsl.hotel.repositories.ReservationRepository;


import java.util.Optional;

@Component
public class ReservationService {

    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    public Iterable<Reservation> findAll() {
        return reservationRepository.findAll();

    }

    public Reservation save(Reservation reservation) {


        return reservationRepository.save(reservation);
    }

    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {



    }
}

package pl.polsl.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.exceptions.UsernameAlreadyUsedException;
import pl.polsl.hotel.models.Reservation;

import pl.polsl.hotel.models.ReservationView;
import pl.polsl.hotel.models.User;
import pl.polsl.hotel.models.UserView;
import pl.polsl.hotel.repositories.ReservationRepository;
import pl.polsl.hotel.repositories.RoomRepository;
import pl.polsl.hotel.repositories.UserRepository;


import java.util.Optional;

@Component
public class ReservationService {

    private ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;
    @Autowired
    public ReservationService(ReservationRepository reservationRepository,UserRepository userRepository,RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    public Iterable<Reservation> findAll() {
        return reservationRepository.findAll();

    }

    public ReservationView save(ReservationView reservationView)
    {

        Reservation reservation = map(reservationView);

        if(reservationView.getRoomNumber() != null)
            reservation.setRoom(roomRepository.getById(reservationView.getRoomNumber()));

        if(reservationView.getUserId() != null)
            reservation.setUser(userRepository.getById(reservationView.getUserId()));

        ReservationView returnedReservationView = map(reservationRepository.save(reservation));


        return returnedReservationView;
    }

    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }

    public Reservation map(ReservationView reservationView) {
        Reservation reservation = new Reservation();
        reservation.setEndDate(reservationView.getEndDate());
        reservation.setId(reservationView.getId());
        reservation.setPrice(reservationView.getPrice());
        reservation.setStartDate(reservationView.getStartDate());
        return reservation;
    }

    public ReservationView map(Reservation reservation) {
        ReservationView reservationView = new ReservationView();
        if (reservation.getUser() != null)
            reservationView.setUserId(reservation.getUser().getId());
        reservationView.setId(reservation.getId());
        reservationView.setEndDate(reservation.getEndDate());
        reservationView.setUserId(reservation.getUser().getId());
        reservationView.setPrice(reservation.getPrice());
        if(reservation.getRoom()!= null)
            reservationView.setRoomNumber(reservation.getRoom().getId());
        return reservationView;
    }
}

package pl.polsl.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;
import pl.polsl.hotel.models.*;

import pl.polsl.hotel.repositories.ReservationRepository;
import pl.polsl.hotel.repositories.RoomTypeRepository;
import pl.polsl.hotel.repositories.UserRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ReservationService {

    private ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final RoomTypeRepository roomTypeRepository;
    private ArrayList<ReservationView> reservationsFromCurrentUser;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository, RoomTypeRepository roomTypeRepository) {
        this.reservationRepository = reservationRepository;
        this.roomTypeRepository = roomTypeRepository;
        this.userRepository = userRepository;
        this.reservationsFromCurrentUser = new ArrayList<ReservationView>();
    }

    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    public List<ReservationView> getAllReservationsFromGivenUser(Long id) {
        this.reservationsFromCurrentUser.clear();

        for(Reservation reservation: reservationRepository.findAll())
        {
            if(reservation.getUser().getId() == id)
                reservationsFromCurrentUser.add(map(reservation));
        }

        return reservationsFromCurrentUser;
    }

    public Iterable<Reservation> findAll() {
        return reservationRepository.findAll();

    }

    public ReservationView updateReservation(Long reservationId, ReservationView reservationView) {

        Reservation reservationToUpdate = map(reservationView);

        reservationRepository.deleteById(reservationId);

        return map(reservationRepository.save(reservationToUpdate));
    }

    public ReservationView save(ReservationView reservationView)
    {

        Reservation reservation = map(reservationView);

        if(reservationView.getRoomTypeId() != null)
            reservation.setRoom(roomTypeRepository.getById(reservationView.getRoomTypeId()));

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
        reservation.setNumberOfDays(reservationView.getNumberOfDays());
        return reservation;
    }

    public ReservationView map(Reservation reservation) {
        ReservationView reservationView = new ReservationView();
        if (reservation.getUser() != null)
            reservationView.setUserId(reservation.getUser().getId());
        reservationView.setId(reservation.getId());
        reservationView.setEndDate(reservation.getEndDate());
        reservationView.setStartDate(reservation.getStartDate());
        reservationView.setNumberOfDays(reservation.getNumberOfDays());
        reservationView.setUserId(reservation.getUser().getId());
        reservationView.setPrice(reservation.getPrice());
        if(reservation.getRoom()!= null)
            reservationView.setRoomTypeId(reservation.getRoom().getId());
        return reservationView;
    }
}

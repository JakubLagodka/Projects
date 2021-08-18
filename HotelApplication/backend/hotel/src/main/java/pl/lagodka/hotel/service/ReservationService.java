package pl.lagodka.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Component;
import pl.lagodka.hotel.mapper.ReservationMapper;
import pl.lagodka.hotel.model.*;

import pl.lagodka.hotel.repository.ReservationRepository;
import pl.lagodka.hotel.repository.RoomTypeRepository;
import pl.lagodka.hotel.repository.UserRepository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ReservationService {

    private ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final RoomTypeRepository roomTypeRepository;
    private ArrayList<ReservationView> reservationsFromCurrentUser;
    private final ReservationMapper reservationMapper;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository, RoomTypeRepository roomTypeRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.roomTypeRepository = roomTypeRepository;
        this.userRepository = userRepository;
        this.reservationMapper = reservationMapper;
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
                reservationsFromCurrentUser.add(reservationMapper.map(reservation));
        }

        return reservationsFromCurrentUser;
    }

    public List<ReservationView> findAll() {
        List<Reservation> reservations =  reservationRepository.findAll();
        List<ReservationView> reservationViewList = null;

        for (Reservation reservation : reservations) {
            reservationViewList.add(reservationMapper.map(reservation));
        }

        return reservationViewList;
       // return reservations.stream().map(this::map).collect(Collectors.toList());
    }

    public ReservationView updateReservation(Long reservationId, ReservationView reservationView) {

        Reservation reservationToUpdate = reservationMapper.map(reservationView);

        reservationRepository.deleteById(reservationId);

        return reservationMapper.map(reservationRepository.save(reservationToUpdate));
    }

    public ReservationView save(ReservationView reservationView)
    {

        Reservation reservation = reservationMapper.map(reservationView);

        if(reservationView.getRoomTypeId() != null)
            reservation.setRoom(roomTypeRepository.getById(reservationView.getRoomTypeId()));

        if(reservationView.getUserId() != null)
            reservation.setUser(userRepository.getById(reservationView.getUserId()));

        ReservationView returnedReservationView = reservationMapper.map(reservationRepository.save(reservation));


        return returnedReservationView;
    }

    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }


}

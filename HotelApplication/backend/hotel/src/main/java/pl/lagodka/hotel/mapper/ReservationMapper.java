package pl.lagodka.hotel.mapper;

import org.springframework.stereotype.Component;
import pl.lagodka.hotel.model.Reservation;
import pl.lagodka.hotel.model.ReservationView;

@Component
public class ReservationMapper {

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

package pl.lagodka.hotel.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.lagodka.hotel.model.dao.Reservation;
import pl.lagodka.hotel.model.dto.ReservationDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-14T17:45:29+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public Reservation toDao(ReservationDto reservationDto) {
        if ( reservationDto == null ) {
            return null;
        }

        Reservation reservation = new Reservation();

        return reservation;
    }

    @Override
    public ReservationDto toDto(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationDto reservationDto = new ReservationDto();

        return reservationDto;
    }
}

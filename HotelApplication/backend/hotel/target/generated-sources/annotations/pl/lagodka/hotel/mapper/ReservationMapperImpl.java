package pl.lagodka.hotel.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.lagodka.hotel.model.dao.Reservation;
import pl.lagodka.hotel.model.dao.Reservation.ReservationBuilder;
import pl.lagodka.hotel.model.dto.ReservationDto;
import pl.lagodka.hotel.model.dto.ReservationDto.ReservationDtoBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-07T15:41:02+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ReservationMapperImpl implements ReservationMapper {

    @Override
    public Reservation toDao(ReservationDto reservationDto) {
        if ( reservationDto == null ) {
            return null;
        }

        ReservationBuilder reservation = Reservation.builder();

        reservation.id( reservationDto.getId() );
        reservation.startDate( reservationDto.getStartDate() );
        reservation.endDate( reservationDto.getEndDate() );
        reservation.numberOfDays( reservationDto.getNumberOfDays() );
        reservation.price( reservationDto.getPrice() );
        reservation.paid( reservationDto.isPaid() );

        return reservation.build();
    }

    @Override
    public ReservationDto toDto(Reservation reservation) {
        if ( reservation == null ) {
            return null;
        }

        ReservationDtoBuilder reservationDto = ReservationDto.builder();

        reservationDto.id( reservation.getId() );
        reservationDto.startDate( reservation.getStartDate() );
        reservationDto.endDate( reservation.getEndDate() );
        reservationDto.numberOfDays( reservation.getNumberOfDays() );
        reservationDto.price( reservation.getPrice() );
        reservationDto.paid( reservation.isPaid() );

        return reservationDto.build();
    }
}

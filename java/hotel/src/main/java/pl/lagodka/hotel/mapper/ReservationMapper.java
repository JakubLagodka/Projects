package pl.lagodka.hotel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.lagodka.hotel.model.dao.Reservation;
import pl.lagodka.hotel.model.dto.ReservationDto;
@Mapper(componentModel = "spring")
public interface ReservationMapper {
    Reservation toDao(ReservationDto reservationDto);

    @Mapping(target = "password",ignore = true)
    ReservationDto toDto(Reservation reservation);
}

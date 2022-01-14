package pl.lagodka.hotel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pl.lagodka.hotel.model.dao.Room;
import pl.lagodka.hotel.model.dto.RoomDto;
@Mapper(componentModel = "spring")
public interface RoomMapper {
    Room toDao(RoomDto roomDto);

    RoomDto toDto(Room room);
}

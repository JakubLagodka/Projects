package pl.lagodka.hotel.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.lagodka.hotel.model.dao.Room;
import pl.lagodka.hotel.model.dto.RoomDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-14T17:45:29+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class RoomMapperImpl implements RoomMapper {

    @Override
    public Room toDao(RoomDto roomDto) {
        if ( roomDto == null ) {
            return null;
        }

        Room room = new Room();

        return room;
    }

    @Override
    public RoomDto toDto(Room room) {
        if ( room == null ) {
            return null;
        }

        RoomDto roomDto = new RoomDto();

        return roomDto;
    }
}

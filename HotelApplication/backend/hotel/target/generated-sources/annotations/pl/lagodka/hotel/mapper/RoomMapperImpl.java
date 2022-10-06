package pl.lagodka.hotel.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import pl.lagodka.hotel.model.dao.Room;
import pl.lagodka.hotel.model.dao.Room.RoomBuilder;
import pl.lagodka.hotel.model.dto.RoomDto;
import pl.lagodka.hotel.model.dto.RoomDto.RoomDtoBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-05T19:51:39+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class RoomMapperImpl implements RoomMapper {

    @Override
    public Room toDao(RoomDto roomDto) {
        if ( roomDto == null ) {
            return null;
        }

        RoomBuilder room = Room.builder();

        room.id( roomDto.getId() );
        room.startDate( roomDto.getStartDate() );
        room.endDate( roomDto.getEndDate() );
        room.numberOfDays( roomDto.getNumberOfDays() );
        room.price( roomDto.getPrice() );
        room.paid( roomDto.isPaid() );
        room.createdDate( roomDto.getCreatedDate() );
        room.createdBy( roomDto.getCreatedBy() );
        room.lastModifiedDate( roomDto.getLastModifiedDate() );
        room.lastModifiedBy( roomDto.getLastModifiedBy() );

        return room.build();
    }

    @Override
    public RoomDto toDto(Room room) {
        if ( room == null ) {
            return null;
        }

        RoomDtoBuilder roomDto = RoomDto.builder();

        roomDto.id( room.getId() );
        roomDto.startDate( room.getStartDate() );
        roomDto.endDate( room.getEndDate() );
        roomDto.numberOfDays( room.getNumberOfDays() );
        roomDto.price( room.getPrice() );
        roomDto.paid( room.isPaid() );
        roomDto.createdDate( room.getCreatedDate() );
        roomDto.createdBy( room.getCreatedBy() );
        roomDto.lastModifiedDate( room.getLastModifiedDate() );
        roomDto.lastModifiedBy( room.getLastModifiedBy() );

        return roomDto.build();
    }
}

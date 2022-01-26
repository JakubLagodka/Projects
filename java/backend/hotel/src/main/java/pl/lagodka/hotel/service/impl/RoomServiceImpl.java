package pl.lagodka.hotel.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.lagodka.hotel.model.dao.Room;
import pl.lagodka.hotel.model.dao.User;
import pl.lagodka.hotel.repository.RoomRepository;
import pl.lagodka.hotel.repository.RoomTypeRepository;
import pl.lagodka.hotel.service.RoomService;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    private final RoomTypeRepository roomTypeRepository;


    @Override
    public Room create(Room room) {
        roomTypeRepository.findByName("TYPE_SINGLE").ifPresent(roomType -> room.setRoomTypes(Collections.singletonList(roomType)));

        return roomRepository.save(room);
    }

    @Override
    public Room update(Room room, Long id) {
        Room roomDb = getById(id);
        roomDb.setPrice(room.getPrice());

        return roomDb;
    }

    @Override
    public void delete(Long id) {
        roomRepository.deleteById(id);
    }

    @Override
    public Room getById(Long id) {
        return roomRepository.getById(id);
    }

    @Override
    public Page<Room> getPage(Pageable pageable) {
        return roomRepository.findAll(pageable);
    }
}

package pl.lagodka.hotel.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.lagodka.hotel.model.dao.Room;
import pl.lagodka.hotel.service.RoomService;

public class RoomServiceImpl implements RoomService {
    @Override
    public Room create(Room room) {
        return null;
    }

    @Override
    public Room update(Room room, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Room getById(Long id) {
        return null;
    }

    @Override
    public Page<Room> getPage(Pageable pageable) {
        return null;
    }
}
package pl.lagodka.hotel.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.lagodka.hotel.model.dao.Room;
import pl.lagodka.hotel.service.RoomService;
@Service
@RequiredArgsConstructor
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

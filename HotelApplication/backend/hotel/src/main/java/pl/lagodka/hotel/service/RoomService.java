package pl.lagodka.hotel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.lagodka.hotel.model.dao.Room;


public interface RoomService {
    Room create(Room room);

    Room update(Room room, Long id);

    void delete(Long id);

    Room getById(Long id);

    Page<Room> getPage(Pageable pageable);
}

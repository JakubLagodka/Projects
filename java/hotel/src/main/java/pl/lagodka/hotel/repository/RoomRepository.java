package pl.lagodka.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lagodka.hotel.model.dao.Room;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
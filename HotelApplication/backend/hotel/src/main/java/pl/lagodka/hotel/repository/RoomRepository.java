package pl.lagodka.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import pl.lagodka.hotel.model.dao.Room;

public interface RoomRepository extends JpaRepository<Room,Long>, RevisionRepository<Room,Long,Integer> {
}

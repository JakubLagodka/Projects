package pl.lagodka.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lagodka.hotel.model.dao.RoomType;

import java.util.Optional;

public interface RoomTypeRepository extends JpaRepository<RoomType,Long> {
    Optional<RoomType> findByName(String name);
}

package pl.polsl.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.hotel.exceptions.NotFoundException;

import pl.polsl.hotel.models.Parameters;
import pl.polsl.hotel.models.RoomType;


@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
    default RoomType getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}

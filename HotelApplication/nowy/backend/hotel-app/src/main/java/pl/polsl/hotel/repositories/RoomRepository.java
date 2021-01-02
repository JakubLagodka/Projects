package pl.polsl.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.hotel.exceptions.NotFoundException;

import pl.polsl.hotel.models.Room;


@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    default Room getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}

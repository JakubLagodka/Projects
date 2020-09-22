package pl.polsl.hotelapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.hotelapp.entities.HotelRoom;

@Repository
public interface HotelRoomRepo extends CrudRepository<HotelRoom,Long> {
}

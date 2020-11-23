package pl.polsl.hotelapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.hotelapp.models.HotelRoom;

@Repository
public interface HotelRoomRepo extends CrudRepository<HotelRoom,Long> {
}

package pl.polsl.hotelapp.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.hotelapp.dao.entities.HotelRoom;

@Repository
public interface HotelRoomRepo extends CrudRepository<HotelRoom,Long> {

}

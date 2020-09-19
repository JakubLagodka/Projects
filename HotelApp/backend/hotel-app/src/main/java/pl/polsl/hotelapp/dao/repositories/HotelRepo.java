package pl.polsl.hotelapp.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.hotelapp.dao.entities.Hotel;

@Repository
public interface HotelRepo extends CrudRepository<Hotel,Long> {

}

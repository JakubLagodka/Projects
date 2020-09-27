package pl.polsl.hotelapp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.hotelapp.models.Hotel;

@Repository
public interface HotelRepo extends CrudRepository<Hotel,Long> {
}

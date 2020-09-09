package pl.polsl.Hotel.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.Hotel.dao.entity.Hotel;

@Repository
public interface HotelRepo extends CrudRepository<Hotel,Long> {
}

package pl.polsl.hotelapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.hotelapp.models.HotelRoom;

@Repository
public interface HotelRoomRepo extends JpaRepository<HotelRoom,Long> {
}

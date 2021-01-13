package pl.polsl.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.polsl.hotel.exceptions.NotFoundException;
import pl.polsl.hotel.models.HotelNight;

@Repository
public interface HotelNightRepository extends JpaRepository<HotelNight, Long> {
    default HotelNight getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}

package pl.polsl.hotelapp.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.polsl.hotelapp.dao.repositories.HotelRepo;
import pl.polsl.hotelapp.dao.entities.Hotel;

import java.util.Optional;

@Service
public class HotelManager {

    private HotelRepo hotelRepo;

    @Autowired
    public HotelManager(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    public Optional<Hotel> findById(Long id) {
        return hotelRepo.findById(id);
    }

    public Iterable<Hotel> findAll() {
        return hotelRepo.findAll();
    }

    public Hotel save(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    public void deleteById(Long id) {
        hotelRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Hotel("FullWypas", 14,12,530, "222222222"));
        save(new Hotel("ElDorado", 13,11,360, "111111111"));
    }
}
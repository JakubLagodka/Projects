package pl.polsl.hotelapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.polsl.hotelapp.models.Hotel;
import pl.polsl.hotelapp.repositories.HotelRepo;

import java.util.Optional;

@Service
public class HotelService {

    private HotelRepo hotelRepo;

    @Autowired
    public HotelService(HotelRepo hotelRepo) {
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
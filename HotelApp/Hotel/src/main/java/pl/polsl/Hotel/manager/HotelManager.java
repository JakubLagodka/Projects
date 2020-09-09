package pl.polsl.Hotel.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.polsl.Hotel.dao.HotelRepo;
import pl.polsl.Hotel.dao.entity.Hotel;

import java.util.Optional;

@Service
public class HotelManager {

    private HotelRepo hotelRepo;

    @Autowired
    public HotelManager(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    public Optional<Hotel> findById(Long id){
        return hotelRepo.findById(id);
    }

    public Iterable<Hotel> findAll(){
        return hotelRepo.findAll();
    }

    public Hotel save(Hotel hotel){
        return hotelRepo.save(hotel);
    }

    public void deleteById(Long id){
        hotelRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB(){
        save(new Hotel(1L,"FullWypas", 530,"222222222"));
        save(new Hotel(2L,"ElDorado", 360,"111111111"));
    }


}

package pl.polsl.hotelapp.managers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.polsl.hotelapp.PillowType;
import pl.polsl.hotelapp.entities.HotelRoom;
import pl.polsl.hotelapp.repositories.HotelRoomRepo;

import java.util.Optional;

@Service
public class HotelRoomManager {
    private HotelRoomRepo hotelRoomRepo;

    @Autowired
    public HotelRoomManager(HotelRoomRepo hotelRoomRepo) {
        this.hotelRoomRepo = hotelRoomRepo;
    }

    public Optional<HotelRoom> findById(Long id) {
        return hotelRoomRepo.findById(id);
    }

    public Iterable<HotelRoom> findAll() {
        return hotelRoomRepo.findAll();

    }

    public HotelRoom save(HotelRoom hotelRoom) {
        return hotelRoomRepo.save(hotelRoom);
    }

    public void deleteById(Long id) {
        hotelRoomRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new HotelRoom(2,7,true,true,true, PillowType.NATURAL,true,100,1,true,true));
        save(new HotelRoom(3,4,true,false,true, PillowType.ANTIALLERGIC,true,150,2,true,true));
    }
}

package pl.polsl.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.polsl.hotel.PillowType;
import pl.polsl.hotel.models.Room;
import pl.polsl.hotel.repositories.RoomRepository;

import java.util.Optional;
@Component
public class RoomService {
    private RoomRepository roomRepo;

    @Autowired
    public RoomService(RoomRepository roomRepo) {
        this.roomRepo = roomRepo;
    }

    public Optional<Room> findById(Long id) {
        return roomRepo.findById(id);
    }

    public Iterable<Room> findAll() {
        return roomRepo.findAll();

    }

    public Room save(Room hotelRoom) {
        return roomRepo.save(hotelRoom);
    }

    public void deleteById(Long id) {
        roomRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        save(new Room(2,7,true,true,true, PillowType.NATURAL,true,100,1,true,true));
        save(new Room(3,4,true,false,true, PillowType.ANTIALLERGIC,true,150,2,true,true));
    }
}

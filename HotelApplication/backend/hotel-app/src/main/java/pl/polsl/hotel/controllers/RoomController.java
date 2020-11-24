package pl.polsl.hotel.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import pl.polsl.hotel.models.Room;
import pl.polsl.hotel.services.RoomService;

@RestController
@RequestMapping(value = "/room")
public class RoomController {
    private RoomService rooms;

    public RoomController(RoomService rooms) {
        this.rooms = rooms;
    }

    @GetMapping("/all")
    public Iterable<Room> getAll(){
        return rooms.findAll();
    }

    @GetMapping
    public Optional<Room> getByRoomId(@RequestParam Long index){
        return rooms.findById(index);
    }

    @PostMapping
    public Room addRoom(@RequestBody Room room){
        return rooms.save(room);
    }

    @PutMapping
    public Room updateRoom(@RequestBody Room room){
        return rooms.save(room);
    }

    @DeleteMapping
    public void deleteRoom(@RequestParam Long index){
        rooms.deleteById(index);

    }
}

package pl.polsl.hotel.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import pl.polsl.hotel.models.Room;
import pl.polsl.hotel.services.RoomService;

@RestController
@RequestMapping(value = "/room")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Room> getRooms(){
        return roomService.findAll();
    }

    @GetMapping
    public Optional<Room> getByRoomId(@RequestParam Long index){
        return roomService.findById(index);
    }

    @PostMapping
    public Room addRoom(@RequestParam Room room){
        return roomService.save(room);
    }

    @PutMapping
    public Room updateRoom(@RequestParam Room room){
        return roomService.save(room);
    }

    @DeleteMapping
    public void deleteRoom(@RequestParam Long index){
        roomService.deleteById(index);

    }
}

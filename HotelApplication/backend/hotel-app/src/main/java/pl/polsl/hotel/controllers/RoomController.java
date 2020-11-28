package pl.polsl.hotel.controllers;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import pl.polsl.hotel.models.Room;
import pl.polsl.hotel.models.UserView;
import pl.polsl.hotel.services.RoomService;

@RestController
@RequestMapping(value = "/room")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Room> getRooms(){
        return roomService.findAll();
    }

    @GetMapping("/available")
    public List<Room> getRoomsAvailable(@RequestParam String from, @RequestParam int numberOfDays)  {
        return roomService.getRoomsAvailable(from, numberOfDays);
    }

    @GetMapping("/booking")
    public Room bookRoom(@RequestParam Long roomId, @RequestParam String from, @RequestParam int numberOfDays) {
        return roomService.bookRoom(roomId, from,numberOfDays);
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

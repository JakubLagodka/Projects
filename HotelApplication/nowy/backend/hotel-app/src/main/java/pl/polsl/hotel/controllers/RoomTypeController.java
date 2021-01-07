package pl.polsl.hotel.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import pl.polsl.hotel.models.ReservationView;
import pl.polsl.hotel.models.RoomType;
import pl.polsl.hotel.models.RoomTypeView;
import pl.polsl.hotel.services.RoomTypeService;

@RestController
@RequestMapping(value = "/room")
public class RoomTypeController {
    private final RoomTypeService roomTypeService;

    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @GetMapping("/all")
    public Iterable<RoomTypeView> getRooms(){
        return roomTypeService.findAll();
    }

    @GetMapping("/available")
    public List<RoomTypeView> getRoomsAvailable(@RequestParam String startDate, @RequestParam String endDate)  {
        return roomTypeService.getRoomsAvailable(startDate, endDate);
    }

   /* @GetMapping("/booking")
    public Room bookRoom(@RequestParam Long roomId, @RequestParam String from, @RequestParam int numberOfDays) {
        return roomService.bookRoom(roomId, from,numberOfDays);
    }*/

    @GetMapping
    public Optional<RoomTypeView> getByRoomId(@RequestParam Long index){
        return roomTypeService.findById(index);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RoomTypeView addRoom(@RequestBody RoomTypeView roomType){
        return roomTypeService.save(roomType);
    }

    @PutMapping
    public RoomTypeView updateRoom(@RequestParam RoomTypeView roomType){
        return roomTypeService.save(roomType);
    }

    @DeleteMapping
    public void deleteRoom(@RequestParam Long index){
        roomTypeService.deleteById(index);

    }
}

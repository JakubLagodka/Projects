package pl.polsl.hotel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import pl.polsl.hotel.model.RoomType;

import pl.polsl.hotel.service.RoomTypeService;

@RestController
@RequestMapping(value = "/room")
public class RoomTypeController {
    private final RoomTypeService roomTypeService;

    public RoomTypeController(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @GetMapping("/all")
    public Iterable<RoomType> getRooms(){
        return roomTypeService.findAll();
    }

    @GetMapping("/available")
    public List<RoomType> getRoomsAvailable(@RequestParam String startDate, @RequestParam String endDate)  {
        return roomTypeService.getRoomsAvailable(startDate, endDate);
    }

   /* @GetMapping("/booking")
    public Room bookRoom(@RequestParam Long roomId, @RequestParam String from, @RequestParam int numberOfDays) {
        return roomService.bookRoom(roomId, from,numberOfDays);
    }*/

    @GetMapping("/is_available")
    public boolean isRoomAvailable(@RequestParam Long id){
        return roomTypeService.isAvailable(id);
    }

    @GetMapping
    public Optional<RoomType> getByRoomId(@RequestParam Long id){
        return roomTypeService.findById(id);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public RoomType addRoom(@RequestBody RoomType roomType){
        return roomTypeService.save(roomType);
    }

    @PutMapping
    public RoomType updateRoom(@RequestParam RoomType roomType){
        return roomTypeService.save(roomType);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteRoom(@RequestParam Long id){
        roomTypeService.deleteById(id);

    }
}

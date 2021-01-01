package pl.polsl.hotel.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RoomType> getRooms(){
        return roomTypeService.findAll();
    }

    @GetMapping("/available")
    public List<RoomType> getRoomsAvailable(@RequestParam String startDate, @RequestParam String endDate)  {
        return roomTypeService.getRoomsAvailable(startDate, endDate);
    }

    @GetMapping
    public Optional<RoomType> getByRoomId(@RequestParam Long index){
        return roomTypeService.findById(index);
    }

    @PostMapping
    public RoomType addRoom(@RequestParam RoomType room){
        return roomTypeService.save(room);
    }

    @PutMapping
    public RoomType updateRoom(@RequestParam RoomType room){
        return roomTypeService.save(room);
    }

    @DeleteMapping
    public void deleteRoom(@RequestParam Long index){
        roomTypeService.deleteById(index);

    }
}

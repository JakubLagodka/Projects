package pl.polsl.hotelapp.controllers;

import org.springframework.web.bind.annotation.*;
import pl.polsl.hotelapp.models.HotelRoom;
import pl.polsl.hotelapp.services.HotelRoomService;

import java.util.Optional;

@RestController
@RequestMapping("/hotelRoom")
public class HotelRoomController {
    private HotelRoomService hotelRooms;

    public HotelRoomController(HotelRoomService hotelRooms) {
        this.hotelRooms = hotelRooms;
    }

    @GetMapping("/all")
    public Iterable<HotelRoom> getAll(){
        return hotelRooms.findAll();
    }

    @GetMapping("/available")
    public Iterable<HotelRoom> getRoomsAvailable(@RequestParam String from, @RequestParam int numberOfDays){
        return hotelRooms.getRoomsAvailable(from, numberOfDays);
    }

    @GetMapping
    public Optional<HotelRoom> getByHotelRoomId(@RequestParam Long index){
        return hotelRooms.findById(index);
    }

    @PostMapping
    public HotelRoom addHotelRoom(@RequestBody HotelRoom hotelRoom){
        return hotelRooms.save(hotelRoom);
    }

    @PutMapping
    public HotelRoom updateHotelRoom(@RequestBody HotelRoom hotelRoom){
        return hotelRooms.save(hotelRoom);
    }

    @DeleteMapping
    public void deleteHotelRoom(@RequestParam Long index){
        hotelRooms.deleteById(index);

    }
}

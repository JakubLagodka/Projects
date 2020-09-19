package pl.polsl.hotelapp.api;

import org.springframework.web.bind.annotation.*;
import pl.polsl.hotelapp.dao.entities.HotelRoom;
import pl.polsl.hotelapp.managers.HotelRoomManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/hotel_room")
public class HotelRoomApi {
    private HotelRoomManager hotelRooms;

    public HotelRoomApi(HotelRoomManager hotelRooms) {
        this.hotelRooms = hotelRooms;
    }

    @GetMapping("/all")
    public Iterable<HotelRoom> getAll(){
        return hotelRooms.findAll();
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

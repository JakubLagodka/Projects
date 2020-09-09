package pl.polsl.hotelapp.api;

import org.springframework.web.bind.annotation.*;
import pl.polsl.hotelapp.dao.entity.Hotel;
import pl.polsl.hotelapp.manager.HotelManager;

import java.util.Optional;

@RestController
@RequestMapping("/api/hotel")
public class HotelApi {
    private HotelManager hotels;

    public HotelApi(HotelManager hotels) {
        this.hotels = hotels;
    }

    @GetMapping("/all")
    public Iterable<Hotel> getAll(){
        return hotels.findAll();
    }

    @GetMapping
    public Optional<Hotel> getByHotelId(@RequestParam Long index){
        return hotels.findById(index);
    }

    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel){
        return hotels.save(hotel);
    }

    @PutMapping
    public Hotel updateHotel(@RequestBody Hotel hotel){
        return hotels.save(hotel);
    }

    @DeleteMapping
    public void deleteHotel(@RequestParam Long index){
        hotels.deleteById(index);
    }
}

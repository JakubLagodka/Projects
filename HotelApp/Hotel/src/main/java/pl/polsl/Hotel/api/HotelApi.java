package pl.polsl.Hotel.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.polsl.Hotel.dao.entity.Hotel;
import pl.polsl.Hotel.manager.HotelManager;

import java.util.ArrayList;
import java.util.List;
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

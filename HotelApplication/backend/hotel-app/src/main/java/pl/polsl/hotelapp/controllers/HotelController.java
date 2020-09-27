package pl.polsl.hotelapp.controllers;

import org.springframework.web.bind.annotation.*;
import pl.polsl.hotelapp.models.Hotel;
import pl.polsl.hotelapp.services.HotelService;

import java.util.Optional;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    private HotelService hotels;

    public HotelController(HotelService hotels) {
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

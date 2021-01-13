package pl.polsl.hotel.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.hotel.models.HotelNight;
import pl.polsl.hotel.services.HotelNightService;

import java.util.List;
@RestController
@RequestMapping(value = "/hotel_night")
public class HotelNightController {
    private final HotelNightService hotelNightService;

    public HotelNightController(HotelNightService hotelNightService) {
        this.hotelNightService = hotelNightService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HotelNight> getHotelNight() {
        return hotelNightService.getHotelNight();
    }
}

package pl.polsl.hotel.services;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.models.*;
import pl.polsl.hotel.repositories.HotelNightRepository;
import java.util.List;
@Component
public class HotelNightService implements StartUpFiller{
    private final HotelNightRepository  hotelNightRepository;

    public HotelNightService(HotelNightRepository hotelNightRepository) {
        this.hotelNightRepository = hotelNightRepository;
    }


    public List<HotelNight> getHotelNight() {
        List<HotelNight> hotelNight = hotelNightRepository.findAll();
        return hotelNight;
    }

    public void createInitialData() throws RuntimeException {

            HotelNight hotelNight = new HotelNight();
            hotelNight.setCheckInTime((long) 14);
            hotelNight.setCheckOutTime((long) 12);
            hotelNightRepository.save(hotelNight);
    }
}

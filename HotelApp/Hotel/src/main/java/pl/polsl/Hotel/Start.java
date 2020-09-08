package pl.polsl.Hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class Start {

    private HotelRepo hotelRepo;

    @Autowired
    public Start(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample(){

        Hotel hotel = new Hotel("FullWypas", 530,"222222222");
        hotelRepo.save(hotel);
    }
}

package pl.polsl.hotelapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.polsl.hotelapp.PillowType;
import pl.polsl.hotelapp.models.HotelRoom;
import pl.polsl.hotelapp.repositories.HotelRoomRepo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HotelRoomService {
    private HotelRoomRepo hotelRoomRepo;
    private List<HotelRoom> roomsAvailable;

    @Autowired
    public HotelRoomService(HotelRoomRepo hotelRoomRepo) {
        this.hotelRoomRepo = hotelRoomRepo;
        this.roomsAvailable = new ArrayList<HotelRoom>();

    }

    public Optional<HotelRoom> findById(Long id) {
        return hotelRoomRepo.findById(id);
    }

    public Iterable<HotelRoom> findAll() {
        return hotelRoomRepo.findAll();

    }
    public List<HotelRoom> getRoomsAvailable(String from, int numberOfDays) {
        roomsAvailable.clear();
        int index = 0;
        boolean isAvailable = true;
        LocalDate fromDate = LocalDate.parse(from);
        for (HotelRoom room : hotelRoomRepo.findAll()) {
            for (LocalDate date: room.getAvailableDates()) {

                if((date.getYear() == fromDate.getYear())&&(date.getMonth() == fromDate.getMonth())&& (date.getDayOfMonth() == fromDate.getDayOfMonth()))
                {
                    if(room.getIsAvailable().get(index))
                    {
                        for(int i = index + 1; i < index + numberOfDays;i++)
                        {
                            if(!room.getIsAvailable().get(i))
                            {
                                isAvailable = false;
                                break;
                            }
                        }
                        if(isAvailable)
                            roomsAvailable.add(room);
                    }
                    break;
                }

            }
                index++;
            }
        return roomsAvailable;
    }

    public HotelRoom save(HotelRoom hotelRoom) {
        return hotelRoomRepo.save(hotelRoom);
    }

    public void deleteById(Long id) {
        hotelRoomRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;

        String formattedDate = formatter.format(LocalDate.now());
        // System.out.println(date);
        save(new HotelRoom(2,7,true,true,true, PillowType.NATURAL,true,100,1,true,true));
        save(new HotelRoom(3,4,true,false,true, PillowType.ANTIALLERGIC,true,150,2,true,true));
    }
}

package pl.polsl.hotel.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.PillowType;
import pl.polsl.hotel.models.*;
import pl.polsl.hotel.repositories.RoomRepository;


import java.time.LocalDate;
import java.util.*;

@Component
public class RoomService extends MySession implements StartUpFiller {
    private final RoomRepository roomRepository;
    private Random generator;
    private ArrayList<Room> roomsAvailable;
    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
        this.generator = new Random();
        this.roomsAvailable = new ArrayList<Room>();
    }

    public Optional<Room> findById(Long id) {
        return roomRepository.findById(id);
    }

    public Iterable<Room> findAll() {
        return roomRepository.findAll();

    }

    public Iterable<Room> getRoomsAvailable(LocalDate from, int number_of_days) {
        int index = 0;
        boolean isAvailable = true;
        for (Room room : roomRepository.findAll()) {
            for (LocalDate date: room.getAvailableDates()) {

                if(date == from)
                {
                    if(room.getIsAvailable().get(index))
                    {
                       for(int i = index + 1; i < index + number_of_days;i++)
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
                index++;
            }

        }
        return roomsAvailable;
    }

    public Room save(Room room) {
        return roomRepository.save(room);
    }

    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }

    public void createInitialData() throws RuntimeException {

        if(session.get(Room.class.getSimpleName(),1) == null)
        {
            generator = new Random();

            Room room1 = new Room();
            room1.setNumberOfBeds(generator.nextInt(3) + 1);
            room1.setStorey(generator.nextInt(9));
            room1.setBalcony(generator.nextBoolean());
            room1.setBeautifulViewFromTheWindows(generator.nextBoolean());
            room1.setCloseToElevator(generator.nextBoolean());
            room1.setTypeOfPillow(PillowType.NATURAL) ;
            room1.setCanBeReserved(generator.nextBoolean());
            room1.setPriceForOneDay(10 * generator.nextInt(5) + 50);
            room1.setReadyToUseOnAGivenDay(generator.nextBoolean());


            Room room2 = new Room();
            room2.setNumberOfBeds(generator.nextInt(3) + 1);
            room2.setStorey(generator.nextInt(9));
            room2.setBalcony(generator.nextBoolean());
            room2.setBeautifulViewFromTheWindows(generator.nextBoolean());
            room2.setCloseToElevator(generator.nextBoolean());
            room2.setTypeOfPillow(PillowType.ANTIALLERGIC) ;
            room2.setCanBeReserved(generator.nextBoolean());
            room2.setPriceForOneDay(10 * generator.nextInt(50) + 50);
            room2.setReadyToUseOnAGivenDay(generator.nextBoolean());


            roomRepository.saveAll(Arrays.asList(room1,room2));
        }
    }
}

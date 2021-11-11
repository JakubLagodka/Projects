package pl.polsl.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.configuration.StartUpFiller;
import pl.polsl.hotel.model.*;
import pl.polsl.hotel.repository.ReservationRepository;
import pl.polsl.hotel.repository.RoomTypeRepository;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Component
public class RoomTypeService implements StartUpFiller {
    private final RoomTypeRepository roomTypeRepository;
    private final ReservationRepository reservationRepository;
    private Random generator;
    private ArrayList<RoomType> roomsAvailable;
    private LocalDate startLocalDate;
    private Date startDate;
    private LocalDate endLocalDate;
    private Date endDate;
    int numberOfRoomsAvailable;
    boolean isAvailable;
    @Autowired
    public RoomTypeService(RoomTypeRepository roomTypeRepository, ReservationRepository reservationRepository) {
        this.roomTypeRepository = roomTypeRepository;
        this.generator = new Random();
        this.roomsAvailable = new ArrayList<RoomType>();
        this.reservationRepository = reservationRepository;
    }

    public Optional<RoomType> findById(Long id) {
        return roomTypeRepository.findById(id);
    }

    public Iterable<RoomType> findAll() {
        return roomTypeRepository.findAll();

    }
    private void convertDates(String start, String end)
    {
        roomsAvailable.clear();

        startLocalDate = LocalDate.parse(start);
        startDate = convertToDate(startLocalDate);
        Calendar startCal = Calendar.getInstance();
        startCal.setTime(startDate);
        startCal.add(Calendar.HOUR, 23);
        startDate = startCal.getTime();
        endLocalDate = LocalDate.parse(end);
        endDate = convertToDate(endLocalDate);
    }

    public List<RoomType> getRoomsAvailable(String start, String end) {

        convertDates(start, end);

        for (RoomType roomType : roomTypeRepository.findAll()) {
            isAvailable = true;
            numberOfRoomsAvailable = roomType.getNumber1();

            for (Reservation reservation : reservationRepository.findAll())
            {
                if(reservation.getRoom().getId() == roomType.getId() &&
                        ((startDate.after(reservation.getStartDate()) && startDate.before(reservation.getEndDate())) ||
                                (endDate.before(reservation.getEndDate()) && endDate.after(reservation.getStartDate()))||
                                (startDate.before(reservation.getStartDate()) && endDate.after(reservation.getStartDate())) ))
                {
                    numberOfRoomsAvailable--;

                    if(numberOfRoomsAvailable <= 0)
                    {
                        isAvailable = false;
                        break;
                    }
                }
            }

            if(isAvailable)
                roomsAvailable.add(roomType);

        }
        return roomsAvailable;

    }



    public RoomType save(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    public void deleteById(Long id) {
        roomTypeRepository.deleteById(id);
    }

    public void createInitialData() throws RuntimeException {

        //if(this.session.get(Admin.class.getSimpleName(),1) == null)
       /* if("tak" == null)
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
        }*/
    }
    public LocalDate convertToLocalDate (Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
    public Date convertToDate (LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }

    public boolean isAvailable(Long index) {
        return false;
    }

   /* public Room bookRoom(Long roomId, String from, int numberOfDays) {
        fromLocalDate = LocalDate.parse(from);
        Room room = roomRepository.getById(roomId);
        int index = 0;
        /*for (LocalDate date: room.getAvailableDates())
        {

            if((date.getYear() == fromDate.getYear())&&(date.getMonth() == fromLocalDate.getMonth())&& (date.getDayOfMonth() == fromLocalDate.getDayOfMonth()))
            {
                room.getIsAvailable().set(index,false);
                for(int i = index + 1; i < index + numberOfDays;i++)
                {
                    room.getIsAvailable().set(i,false);
                }

               break;
            }
            index++;
        }
        roomRepository.save(room);
        return room;
    }*/
}

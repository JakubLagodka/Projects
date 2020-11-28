package pl.polsl.hotel.services;

import pl.polsl.hotel.repositories.RoomRepository;
import pl.polsl.hotel.repositories.RoomsAvailableRepository;

public class RoomAvailableService {
    private final RoomsAvailableRepository roomsAvailableRepository;

    public RoomAvailableService(RoomsAvailableRepository roomsAvailableRepository) {
        this.roomsAvailableRepository = roomsAvailableRepository;
    }

}

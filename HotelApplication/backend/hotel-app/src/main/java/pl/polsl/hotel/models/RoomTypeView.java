package pl.polsl.hotel.models;

import org.springframework.lang.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RoomTypeView {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NonNull
    private Long id;

    private Long hotelId;

    private long numberOfRoomsAvailable;

    private Long RoomTypeParametersId;

    public RoomTypeView() {
    }

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public long getNumberOfRoomsAvailable() {
        return numberOfRoomsAvailable;
    }

    public void setNumberOfRoomsAvailable(long numberOfRoomsAvailable) {
        this.numberOfRoomsAvailable = numberOfRoomsAvailable;
    }

    public Long getRoomTypeParametersId() {
        return RoomTypeParametersId;
    }

    public void setRoomTypeParametersId(Long roomTypeParametersId) {
        RoomTypeParametersId = roomTypeParametersId;
    }
}

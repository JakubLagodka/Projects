package pl.polsl.hotel.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity(name = "room_type")
public class RoomType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NonNull
    private Long id;

    private long hotelId;

    private long numberOfRoomsAvailable;

    @ManyToOne
    private Parameters roomTypeParameters;

    public RoomType() {

    }


    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public long getNumberOfRoomsAvailable() {
        return numberOfRoomsAvailable;
    }

    public void setNumberOfRoomsAvailable(long numberOfRoomsAvailable) {
        this.numberOfRoomsAvailable = numberOfRoomsAvailable;
    }

    public Parameters getRoomTypeParameters() {
        return roomTypeParameters;
    }

    public void setRoomTypeParameters(Parameters roomTypeParameters) {
        this.roomTypeParameters = roomTypeParameters;
    }
}

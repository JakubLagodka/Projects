package pl.polsl.hotel.models;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "roomsAvailable")
public class RoomsAvailable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NonNull
    private Long id;

    private Long roomId;

    private LocalDate date;

    private boolean isAvailable;


    public RoomsAvailable() {
    }

    @NonNull
    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(@NonNull Long roomId) {
        this.roomId = roomId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


}

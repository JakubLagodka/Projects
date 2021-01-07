package pl.polsl.hotel.models;

import org.springframework.lang.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RoomTypeView {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NonNull
    private Long id;

    private Long checkInTime;

    private Long checkOutTime;

    private int numberOfBeds;

    private long price;

    private int number1;

    private int number2;

    private int number3;

    private int number4;

    private int number5;

    private int number6;

    private int number7;

    private int number8;

    private int number9;

    private int number10;

    private int number11;

    private int number12;

    private double number13;

    private double number14;

    private double number15;

    private double number16;

    private double number17;

    private double number18;

    private double number19;

    private double number20;

    private double number21;

    private double number22;

    private String string1;

    private String string2;

    private String string3;

    private String string4;

    private String string5;

    private String string6;

    private String string7;

    private String string8;

    private String string9;

    private String string10;

    private String string11;

    private String string12;

    private boolean boolean1;

    private boolean boolean2;

    private boolean boolean3;

    private boolean boolean4;

    private boolean boolean5;

    private boolean boolean6;

    private boolean boolean7;

    private boolean boolean8;

    private boolean boolean9;

    private boolean boolean10;

    private boolean boolean11;

    private boolean boolean12;

    public RoomTypeView() {

    }

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    /*public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }*/

   /* public long getNumberOfRoomsAvailable() {
        return numberOfRoomsAvailable;
    }

    public void setNumberOfRoomsAvailable(long numberOfRoomsAvailable) {
        this.numberOfRoomsAvailable = numberOfRoomsAvailable;
    }*/
}

package pl.polsl.hotelapp.models;

import javax.persistence.*;

@Entity
@Table(name = "Hotel")
public class Hotel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long hotelId;

    private String hotelName;

    private int theBeginningOfTheHotelDay;

    private int endOfTheHotelDay;

    private int numberOfFreeRooms;

    private String phoneNumber;

    public Hotel() { }

    public Hotel(String hotelName, int theBeginningOfTheHotelDay, int endOfTheHotelDay, int numberOfFreeRooms, String phoneNumber) {
        this.hotelName = hotelName;
        this.theBeginningOfTheHotelDay = theBeginningOfTheHotelDay;
        this.endOfTheHotelDay = endOfTheHotelDay;
        this.numberOfFreeRooms = numberOfFreeRooms;
        this.phoneNumber = phoneNumber;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;

    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getTheBeginningOfTheHotelDay() {
        return theBeginningOfTheHotelDay;
    }

    public void setTheBeginningOfTheHotelDay(int theBeginningOfTheHotelDay) {
        this.theBeginningOfTheHotelDay = theBeginningOfTheHotelDay;
    }

    public int getEndOfTheHotelDay() {
        return endOfTheHotelDay;
    }

    public void setEndOfTheHotelDay(int endOfTheHotelDay) {
        this.endOfTheHotelDay = endOfTheHotelDay;
    }

    public int getNumberOfFreeRooms() {
        return numberOfFreeRooms;
    }

    public void setNumberOfFreeRooms(int numberOfFreeRooms) {
        this.numberOfFreeRooms = numberOfFreeRooms;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

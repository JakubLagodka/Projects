package pl.polsl.hotelapp.models;

import pl.polsl.hotelapp.PillowType;

import javax.persistence.*;

@Entity
@Table(name = "HotelRoom")
public class HotelRoom {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long roomId;

    private int numberOfBeds;

    private int storey;

    private boolean highStorey;

    private boolean CloseToElevator;

    private boolean BeautifulViewFromTheWindows;

    private PillowType typeOfPillow;

    private boolean balcony;

    private long priceForOneDay;

    private long hotelId;

    private boolean readyToUseOnAGivenDay;

    private boolean canBeReserved;

    public HotelRoom() { }

    public HotelRoom(int numberOfBeds, int storey, boolean highStorey, boolean CloseToElevator, boolean BeautifulViewFromTheWindows,
                     PillowType typeOfPillow, boolean balcony, long priceForOneDay, long hotelId, boolean readyToUseOnAGivenDay,
                     boolean canBeReserved) {
        this.numberOfBeds = numberOfBeds;
        this.storey = storey;
        this.highStorey = highStorey;
        this.CloseToElevator = CloseToElevator;
        this.BeautifulViewFromTheWindows = BeautifulViewFromTheWindows;
        this.typeOfPillow = typeOfPillow;
        this.balcony = balcony;
        this.priceForOneDay = priceForOneDay;
        this.hotelId = hotelId;
        this.readyToUseOnAGivenDay = readyToUseOnAGivenDay;
        this.canBeReserved = canBeReserved;

    }

    public Long getRoomId() {
        return roomId;
    }

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean isHighStorey() {
        return highStorey;
    }

    public void setHighStorey(boolean highStorey) {
        this.highStorey = highStorey;
    }

    public boolean isCloseToElevator() {
        return CloseToElevator;
    }

    public void setCloseToElevator(boolean closeToElevator) {
        CloseToElevator = closeToElevator;
    }

    public boolean isBeautifulViewFromTheWindows() {
        return BeautifulViewFromTheWindows;
    }

    public void setBeautifulViewFromTheWindows(boolean beautifulViewFromTheWindows) {
        BeautifulViewFromTheWindows = beautifulViewFromTheWindows;
    }

    public PillowType getTypeOfPillow() {
        return typeOfPillow;
    }

    public void setTypeOfPillow(PillowType typeOfPillow) {
        this.typeOfPillow = typeOfPillow;
    }

    public boolean isBalcony() {
        return balcony;
    }

    public void setBalcony(boolean balcony) {
        this.balcony = balcony;
    }

    public long getPriceForOneDay() {
        return priceForOneDay;
    }

    public void setPriceForOneDay(long priceForOneDay) {
        this.priceForOneDay = priceForOneDay;
    }

    public long getHotelId() {
        return hotelId;
    }

    public void setHotelId(long hotelId) {
        this.hotelId = hotelId;
    }

    public boolean isReadyToUseOnAGivenDay() {
        return readyToUseOnAGivenDay;
    }

    public void setReadyToUseOnAGivenDay(boolean readyToUseOnAGivenDay) {
        this.readyToUseOnAGivenDay = readyToUseOnAGivenDay;
    }

    public boolean isCanBeReserved() {
        return canBeReserved;
    }

    public void setCanBeReserved(boolean canBeReserved) {
        this.canBeReserved = canBeReserved;
    }
}

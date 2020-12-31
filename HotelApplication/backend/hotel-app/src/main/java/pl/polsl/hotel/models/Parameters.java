package pl.polsl.hotel.models;

import org.springframework.lang.NonNull;

import javax.persistence.*;

@Table(name = "parameters")
@Entity
public class Parameters {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NonNull
    private Long id;

    private Long checkInTime;

    private Long checkOutTime;

    private int numberOfBeds;

   /* private int storey;

    private boolean CloseToElevator;

    private boolean BeautifulViewFromTheWindows;

    private PillowType typeOfPillow;

    private boolean balcony;*/

    private long priceForOneDay;


    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    public Long getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Long checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Long getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(Long checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

   /* public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
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
    }*/

    public long getPriceForOneDay() {
        return priceForOneDay;
    }

    public void setPriceForOneDay(long priceForOneDay) {
        this.priceForOneDay = priceForOneDay;
    }
}

package pl.polsl.hotel.models;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Date;


public class ReservationView {

    @NonNull
    private Long id;
    @Nullable
    private Long userId;
    @Nullable
    private Long roomNumber;
    @NonNull
    private Date startDate;
    @NonNull
    private Date endDate;
    @NonNull
    private int numberOfDays;
    @NonNull
    private int priceForOneDay;

    public ReservationView() {
    }

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    @Nullable
    public Long getUserId() {
        return userId;
    }

    public void setUserId(@Nullable Long userId) {
        this.userId = userId;
    }

    @Nullable
    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(@Nullable Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    @NonNull
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(@NonNull Date startDate) {
        this.startDate = startDate;
    }

    @NonNull
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(@NonNull Date endDate) {
        this.endDate = endDate;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public int getPriceForOneDay() {
        return priceForOneDay;
    }

    public void setPriceForOneDay(int priceForOneDay) {
        this.priceForOneDay = priceForOneDay;
    }
}

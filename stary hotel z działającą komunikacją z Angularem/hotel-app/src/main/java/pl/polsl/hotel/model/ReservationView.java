package pl.polsl.hotel.model;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Date;


public class ReservationView {

    @NonNull
    private Long id;
    @Nullable
    private Long userId;
    @Nullable
    private Long roomTypeId;
    @NonNull
    private Date startDate;
    @NonNull
    private Date endDate;
    @NonNull
    private int numberOfDays;
    @NonNull
    private double price;

    @NonNull
    private boolean paid;

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
    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(@Nullable Long roomTypeId) {
        this.roomTypeId = roomTypeId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
}

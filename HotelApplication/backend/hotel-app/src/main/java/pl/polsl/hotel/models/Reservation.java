package pl.polsl.hotel.models;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;

import java.util.Date;

@Table(name = "reservations")
@Entity
public class Reservation {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @NonNull
    private Long id;

    @ManyToOne
    @Nullable
    private Room room;

    @ManyToOne
    @Nullable
    private User user;
    @NonNull
    private Date startDate;
    @NonNull
    private Date endDate;

    @NonNull
    private int numberOfDays;
    @NonNull
    private int priceForOneDay;

    public Reservation() {
    }

    public Reservation(@Nullable Room room, @Nullable User user, @NonNull Date startDate, @NonNull Date endDate, int numberOfDays, int priceForOneDay) {
        this.room = room;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.numberOfDays = numberOfDays;
        this.priceForOneDay = priceForOneDay;
    }

    @NonNull
    public Long getId() {
        return id;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    @Nullable
    public Room getRoom() {
        return room;
    }

    public void setRoom(@Nullable Room room) {
        this.room = room;
    }

    @Nullable
    public User getUser() {
        return user;
    }

    public void setUser(@Nullable User user) {
        this.user = user;
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

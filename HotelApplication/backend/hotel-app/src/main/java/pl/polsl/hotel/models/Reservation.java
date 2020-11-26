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

    private Date startDate;

    private Date endDate;

    private double price;

    public Reservation() {
    }

    public Reservation( @Nullable Room room, @Nullable User user, Date startDate, Date endDate, double price) {
        this.room = room;
        this.user = user;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

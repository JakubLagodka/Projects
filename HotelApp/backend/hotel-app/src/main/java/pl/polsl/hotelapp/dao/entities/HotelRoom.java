package pl.polsl.hotelapp.dao.entities;

import pl.polsl.hotelapp.PillowType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HotelRoom {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long room_id;

    private int number_of_beds;

    private int storey;

    private boolean is_high_storey;

    private boolean is_close_to_elevator;

    private boolean is_beautiful_view_from_the_windows;

    private PillowType type_of_pillow;

    private boolean is_balcony;

    private long price_for_one_day;

    private long hotel_id;

    private boolean is_ready_to_use_on_a_given_day;

    private boolean can_be_reserved;

    public HotelRoom() { }

    public HotelRoom(int number_of_beds, int storey, boolean is_high_storey, boolean is_close_to_elevator, boolean is_beautiful_view_from_the_windows, PillowType type_of_pillow, boolean is_balcony, long price_for_one_day, long hotel_id, boolean is_ready_to_use_on_a_given_day, boolean can_be_reserved) {
        this.number_of_beds = number_of_beds;
        this.storey = storey;
        this.is_high_storey = is_high_storey;
        this.is_close_to_elevator = is_close_to_elevator;
        this.is_beautiful_view_from_the_windows = is_beautiful_view_from_the_windows;
        this.type_of_pillow = type_of_pillow;
        this.is_balcony = is_balcony;
        this.price_for_one_day = price_for_one_day;
        this.hotel_id = hotel_id;
        this.is_ready_to_use_on_a_given_day = is_ready_to_use_on_a_given_day;
        this.can_be_reserved = can_be_reserved;
    }

    public Long getRoom_id() {
        return room_id;
    }

    public void setRoom_id(Long room_id) {
        this.room_id = room_id;
    }

    public int getNumber_of_beds() {
        return number_of_beds;
    }

    public void setNumber_of_beds(int number_of_beds) {
        this.number_of_beds = number_of_beds;
    }

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }

    public boolean isIs_high_storey() {
        return is_high_storey;
    }

    public void setIs_high_storey(boolean is_high_storey) {
        this.is_high_storey = is_high_storey;
    }

    public boolean isIs_close_to_elevator() {
        return is_close_to_elevator;
    }

    public void setIs_close_to_elevator(boolean is_close_to_elevator) {
        this.is_close_to_elevator = is_close_to_elevator;
    }

    public boolean isIs_beautiful_view_from_the_windows() {
        return is_beautiful_view_from_the_windows;
    }

    public void setIs_beautiful_view_from_the_windows(boolean is_beautiful_view_from_the_windows) {
        this.is_beautiful_view_from_the_windows = is_beautiful_view_from_the_windows;
    }

    public PillowType getType_of_pillow() {
        return type_of_pillow;
    }

    public void setType_of_pillow(PillowType type_of_pillow) {
        this.type_of_pillow = type_of_pillow;
    }

    public boolean isIs_balcony() {
        return is_balcony;
    }

    public void setIs_balcony(boolean is_balcony) {
        this.is_balcony = is_balcony;
    }

    public long getPrice_for_one_day() {
        return price_for_one_day;
    }

    public void setPrice_for_one_day(long price_for_one_day) {
        this.price_for_one_day = price_for_one_day;
    }

    public long getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(long hotel_id) {
        this.hotel_id = hotel_id;
    }

    public boolean isIs_ready_to_use_on_a_given_day() {
        return is_ready_to_use_on_a_given_day;
    }

    public void setIs_ready_to_use_on_a_given_day(boolean is_ready_to_use_on_a_given_day) {
        this.is_ready_to_use_on_a_given_day = is_ready_to_use_on_a_given_day;
    }

    public boolean isCan_be_reserved() {
        return can_be_reserved;
    }

    public void setCan_be_reserved(boolean can_be_reserved) {
        this.can_be_reserved = can_be_reserved;
    }
}

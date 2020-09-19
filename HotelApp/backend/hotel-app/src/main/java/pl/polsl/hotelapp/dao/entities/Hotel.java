package pl.polsl.hotelapp.dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Hotel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long hotel_id;

    private String hotel_name;

    private int the_beginning_of_the_hotel_day;

    private int end_of_the_hotel_day;

    private int number_of_free_rooms;

    private String phone_number;

    public Hotel() { }

    public Hotel(String hotel_name, int the_beginning_of_the_hotel_day, int end_of_the_hotel_day,
                 int number_of_free_rooms, String phone_number) {
        this.hotel_name = hotel_name;
        this.the_beginning_of_the_hotel_day = the_beginning_of_the_hotel_day;
        this.end_of_the_hotel_day = end_of_the_hotel_day;
        this.number_of_free_rooms = number_of_free_rooms;
        this.phone_number = phone_number;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public int getThe_beginning_of_the_hotel_day() {
        return the_beginning_of_the_hotel_day;
    }

    public void setThe_beginning_of_the_hotel_day(int the_beginning_of_the_hotel_day) {
        this.the_beginning_of_the_hotel_day = the_beginning_of_the_hotel_day;
    }

    public int getEnd_of_the_hotel_day() {
        return end_of_the_hotel_day;
    }

    public void setEnd_of_the_hotel_day(int end_of_the_hotel_day) {
        this.end_of_the_hotel_day = end_of_the_hotel_day;
    }

    public int getNumber_of_free_rooms() {
        return number_of_free_rooms;
    }

    public void setNumber_of_free_rooms(int number_of_free_rooms) {
        this.number_of_free_rooms = number_of_free_rooms;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public long getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(long hotel_id) {
        this.hotel_id = hotel_id;
    }

}

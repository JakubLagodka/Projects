package pl.polsl.Hotel.dao.entity;

import javax.persistence.*;

@Entity
public class Hotel {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long hotel_id;

    private String hotel_name;

    private int number_of_free_rooms;

    private String phone_number;

    public Hotel() {
    }

    public Hotel(Long hotel_id, String hotel_name, int number_of_free_rooms, String phone_number) {
        this.hotel_id = hotel_id;
        this.hotel_name = hotel_name;
        this.number_of_free_rooms = number_of_free_rooms;
        this.phone_number = phone_number;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
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

    public Long getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Long hotel_id) {
        this.hotel_id = hotel_id;
    }

}

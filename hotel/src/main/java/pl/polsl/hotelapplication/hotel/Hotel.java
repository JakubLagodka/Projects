package pl.polsl.hotelapplication.hotel;

import javax.persistence.*;

@Entity
public class Hotel {
    @Id
    @GeneratedValue
    private long hotel_id;

    private String hotel_name;

    private int number_of_free_rooms;

    private String phone_number;


    public long getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(long hotel_id) {
        this.hotel_id = hotel_id;
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

    @Override
    public String toString(){
        return "Hotel{"+"id="+hotel_id+", name='"+hotel_name+"', free rooms="+number_of_free_rooms+", nuber="+phone_number;
    }
}

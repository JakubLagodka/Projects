package pl.lagodka.hotel.model.dao;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity

public class Room {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
}

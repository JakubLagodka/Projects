package pl.polsl.hotel.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotel.models.Reservation;

import pl.polsl.hotel.services.ReservationService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/all")
    public Iterable<Reservation> getAll(){
        return reservationService.findAll();
    }

    @GetMapping
    public Optional<Reservation> getByReservationId(@RequestParam Long index){
        return reservationService.findById(index);
    }

    @PostMapping
    public Reservation addReservation(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }

    @PutMapping
    public Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }

    @DeleteMapping
    public void deleteReservation(@RequestParam Long index){
        reservationService.deleteById(index);

    }
}

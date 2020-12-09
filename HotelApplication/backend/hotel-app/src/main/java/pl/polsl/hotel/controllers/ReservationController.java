package pl.polsl.hotel.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotel.models.Reservation;

import pl.polsl.hotel.models.ReservationView;
import pl.polsl.hotel.services.ReservationService;

import java.util.List;
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

    @GetMapping("/given_user")
    public List<ReservationView> getAllReservationsFromGivenUser(@RequestParam Long userId){
        return reservationService.getAllReservationsFromGivenUser(userId);
    }

    @GetMapping
    public Optional<Reservation> getByReservationId(@RequestParam Long index){
        return reservationService.findById(index);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReservationView addReservation(@RequestBody ReservationView reservation){
        return reservationService.save(reservation);
    }

    @PutMapping
    public ReservationView updateReservation(@RequestBody ReservationView reservation){
        return reservationService.save(reservation);
    }

    @DeleteMapping
    public void deleteReservation(@RequestParam Long index){
        reservationService.deleteById(index);

    }
}

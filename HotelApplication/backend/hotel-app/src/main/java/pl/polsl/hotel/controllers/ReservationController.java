package pl.polsl.hotel.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotel.models.Reservation;

import pl.polsl.hotel.models.ReservationView;
import pl.polsl.hotel.models.User;
import pl.polsl.hotel.models.UserView;
import pl.polsl.hotel.repositories.UserRepository;
import pl.polsl.hotel.services.MailService;
import pl.polsl.hotel.services.ReservationService;
import pl.polsl.hotel.services.UserService;
import springfox.documentation.annotations.ApiIgnore;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    private final UserRepository userRepository;

    private final MailService mailService;

    public ReservationController(ReservationService reservationService, MailService mailService, UserRepository userRepository) {
        this.reservationService = reservationService;
        this.mailService = mailService;
        this.userRepository = userRepository;
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
    public ReservationView addReservation(@RequestBody ReservationView reservation) throws MessagingException {
        User booking = userRepository.getById(reservation.getUserId());

        mailService.sendMail(booking.getEmail(), "Reservation has been made!","xd",false);

        return reservationService.save(reservation);
    }

    /*@PutMapping
    public ReservationView updateReservation(@RequestParam Long id, @RequestBody ReservationView reservation){
        return reservationService.updateReservation(id, reservation);
    }*/
    @PatchMapping(value = "/{id}/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReservationView updateReservation(@PathVariable Long id,
                               @RequestBody ReservationView reservation) {
        return reservationService.updateReservation(id, reservation);
    }
    @DeleteMapping
    public void deleteReservation(@RequestParam Long id){
        reservationService.deleteById(id);

    }
}

package pl.polsl.hotel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotel.configuration.MailConfiguration;
import pl.polsl.hotel.model.Reservation;

import pl.polsl.hotel.model.ReservationView;
import pl.polsl.hotel.model.User;
import pl.polsl.hotel.repository.UserRepository;
import pl.polsl.hotel.service.ReservationService;

import javax.mail.MessagingException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    private final UserRepository userRepository;

    private final MailConfiguration mailConfiguration;

    public ReservationController(ReservationService reservationService, UserRepository userRepository, MailConfiguration mailConfiguration) {
        this.reservationService = reservationService;
        this.userRepository = userRepository;
        this.mailConfiguration = mailConfiguration;
    }

    @GetMapping("/all")
    public List<ReservationView> getAll(){
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

         mailConfiguration.sendMail(booking.getEmail(), "Dokonano rezerwacji pokoju","fag",true);

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

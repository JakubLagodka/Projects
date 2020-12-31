package pl.polsl.hotel.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotel.models.Parameters;
import pl.polsl.hotel.models.ReservationView;
import pl.polsl.hotel.models.User;
import pl.polsl.hotel.services.ParametersService;

import javax.mail.MessagingException;
import java.util.Optional;

public class ParametersController {
    private final ParametersService parametersService;

    public ParametersController(ParametersService parametersService) {
        this.parametersService = parametersService;
    }

    @GetMapping
    public Optional<Parameters> getByParameterId(@RequestParam Long index){
        return parametersService.findById(index);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ReservationView addReservation(@RequestBody ReservationView reservation) throws MessagingException {
        User booking = userRepository.getById(reservation.getUserId());

        // mailService.sendMail(booking.getEmail(), "Reservation has been made!","xd",false);

        return reservationService.save(reservation);
    }
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

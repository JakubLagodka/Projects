package pl.polsl.hotelapp.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.hotelapp.models.Login;
import pl.polsl.hotelapp.models.Token;
import pl.polsl.hotelapp.services.AuthenticationService;

@RestController
@RequestMapping(value = "/authentication")
public class AuthenticationController {



    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Token createAuthenticationToken(@RequestBody Login login) {
        return authenticationService.loginUser(login);
    }

}

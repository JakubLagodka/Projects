package pl.lagodka.hotel.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lagodka.hotel.model.Token;
import pl.lagodka.hotel.model.User;
import pl.lagodka.hotel.service.AuthenticationTokenService;


@RestController
@RequestMapping(value = "/authentication")
public class TokenController {

    private final AuthenticationTokenService authenticationTokenService;

    public TokenController(AuthenticationTokenService authenticationTokenService) {
        this.authenticationTokenService = authenticationTokenService;
    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Token createAuthenticationToken(@RequestBody User user) {
        return authenticationTokenService.loginUser(user);
    }

}

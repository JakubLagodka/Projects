package pl.polsl.hotelapp.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import pl.polsl.hotelapp.models.Login;
import pl.polsl.hotelapp.models.Token;
import pl.polsl.hotelapp.models.User;
import pl.polsl.hotelapp.repositories.UserRepo;

import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Component
public class AuthenticationService {

    private static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60; // 5h
    private static final String secret = "jakieshaslo";

    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsServiceImpl userDetailsService;

    public AuthenticationService(UserRepo userRepo, AuthenticationManager authenticationManager, UserDetailsServiceImpl userDetailsService) {
        this.userRepo = userRepo;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
    }

    private Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        String parsedToken;
        if (token != null && token.startsWith("Bearer "))
            parsedToken = token.substring(7);
        else
            parsedToken = token;
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(parsedToken).getBody();
        return claimsResolver.apply(claims);
    }

    private String generateToken(UserDetails userDetails) {
        return Jwts.builder().setClaims(new HashMap<>()).setSubject(userDetails.getUsername()).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        return getUsernameFromToken(token).equals(userDetails.getUsername()) && !getExpirationDateFromToken(token).before(new Date());
    }


    public User getUserFromToken(String token) {
        try {
            String userName = getClaimFromToken(token, Claims::getSubject);
            return userRepo.findByUsername(userName).orElseThrow(() -> new Exception("Token does not match any user"));
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }


    public Token loginUser(Login login) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(login.getUsername());
            String tmp_token = generateToken(userDetails);
            Token token = new Token();
            token.setValue(tmp_token);
            token.setExpirationDate(getExpirationDateFromToken(tmp_token));
            return token;
        }  catch (Exception e){
            throw new RuntimeException("Wrong credentials");
        }
    }

}

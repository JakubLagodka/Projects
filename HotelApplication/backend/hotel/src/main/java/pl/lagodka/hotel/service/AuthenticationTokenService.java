package pl.lagodka.hotel.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.lagodka.hotel.configuration.ModifiedUserDetailsService;
import pl.lagodka.hotel.exception.NotAuthorizedException;
import pl.lagodka.hotel.model.Token;
import pl.lagodka.hotel.model.User;
import pl.lagodka.hotel.repository.UserRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Service
public class AuthenticationTokenService {

    private static final long JWT_TOKEN_VALIDITY = 2 * 3600; // 2 godziny
    private static final String secret = "jakieshaslo";

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;
    private final ModifiedUserDetailsService userDetailsService;

    public AuthenticationTokenService(UserRepository userRepository, AuthenticationManager authenticationManager, ModifiedUserDetailsService userDetailsService) {
        this.userRepository = userRepository;
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
            return userRepository.findByUsername(userName).orElseThrow(() -> new NotAuthorizedException("Token does not match any user"));
        }catch (Exception e){
            throw new NotAuthorizedException(e.getMessage());
        }
    }


    public Token loginUser(User user) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
            String geretated_token = generateToken(userDetails);
            Token token = new Token();
            token.setToken(geretated_token);
            token.setExpirationDate(getExpirationDateFromToken(geretated_token));
            return token;
        }  catch (Exception e){
            throw new NotAuthorizedException("Wrong credentials");
        }
    }

}

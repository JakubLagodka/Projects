package pl.polsl.hotel.services;

import org.springframework.lang.NonNull;
import pl.polsl.hotel.models.User;
import pl.polsl.hotel.views.AuthenticationPost;
import pl.polsl.hotel.views.AuthenticationView;

public interface AuthenticationService {

    @NonNull
    User getUserFromToken(String token);

    @NonNull
    AuthenticationView loginUser(AuthenticationPost authenticationPost);

}

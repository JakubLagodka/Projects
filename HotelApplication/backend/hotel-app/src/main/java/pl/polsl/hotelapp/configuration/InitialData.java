package pl.polsl.hotelapp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.polsl.hotelapp.entities.User;
import pl.polsl.hotelapp.repositories.UserRepo;

@Configuration
public class InitialData {

    private UserRepo userRepo;

    public InitialData(UserRepo userRepo, PasswordEncoder passwordEncoder) {

        User user = new User();
        user.setUsername("Jan");
        user.setPassword(passwordEncoder.encode("Jan111"));
        user.setRole("ROLE_ADMIN");
        userRepo.save(user);
    }
}

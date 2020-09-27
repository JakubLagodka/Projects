package pl.polsl.hotelapp.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.polsl.hotelapp.models.User;
import pl.polsl.hotelapp.repositories.UserRepo;

@Configuration
public class InitialData {

    private UserRepo userRepo;

    public InitialData(UserRepo userRepo, PasswordEncoder passwordEncoder) {

        User userJan = new User();
        userJan.setUsername("Jan");
        userJan.setPassword(passwordEncoder.encode("Jan111"));
        userJan.setRole("ROLE_ADMIN");
        userRepo.save(userJan);

        User userJanusz = new User();
        userJanusz.setUsername("Janusz");
        userJanusz.setPassword(passwordEncoder.encode("Janusz111"));
        userJanusz.setRole("ROLE_USER");
        userRepo.save(userJanusz);
    }
}

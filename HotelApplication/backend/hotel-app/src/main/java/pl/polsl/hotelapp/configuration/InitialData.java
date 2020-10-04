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
        userJan.setName("Jan");
        userJan.setSurname("Kowalski");
        userJan.setPassword(passwordEncoder.encode("Jan111"));
        userJan.setMail("Jan.example@gmail.com");
        userJan.setRole("ROLE_ADMIN");
        userJan.setEnabled(true);

        User userJanusz = new User();
        userJanusz.setUsername("Janusz");
        userJanusz.setName("Janusz");
        userJanusz.setSurname("Nowak");
        userJanusz.setPassword(passwordEncoder.encode("Janusz111"));
        userJanusz.setMail("Janusz.example@gmail.com");
        userJanusz.setRole("ROLE_USER");
        userJanusz.setEnabled(true);

        userRepo.save(userJan);
        userRepo.save(userJanusz);
    }
}

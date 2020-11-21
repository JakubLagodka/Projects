package pl.polsl.hotelapp.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.polsl.hotelapp.models.Token;
import pl.polsl.hotelapp.models.User;
import pl.polsl.hotelapp.repositories.TokenRepo;
import pl.polsl.hotelapp.repositories.UserRepo;

import javax.mail.MessagingException;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private TokenRepo tokenRepo;

    private MailService mailService;

    private UserRepo userRepo;

    private PasswordEncoder passwordEncoder;

    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder, TokenRepo tokenRepo, MailService mailService) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepo = tokenRepo;
        this.mailService = mailService;
    }

    public void addUser(User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepo.save(user);
        sendToken(user);
    }

    private void sendToken(User user) {
        String tokenValue = UUID.randomUUID().toString();

        Token token = new Token();
        token.setValue(tokenValue);
        token.setUser(user);
        tokenRepo.save(token);

        String url = "http://localhost:8080/token?value=" + tokenValue;

        try {
            mailService.sendMail(user.getMail(), "Potwierdzaj to!",url,false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    //TODO zrobić role jako enum!

    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    public Iterable<User> findAll() {
        return userRepo.findAll();

    }

    public User save(User user) {
        return userRepo.save(user);
    }

    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //todo throw if not exist - obsługa błędów
        return userRepo.findByUsername(s).get();
    }
}

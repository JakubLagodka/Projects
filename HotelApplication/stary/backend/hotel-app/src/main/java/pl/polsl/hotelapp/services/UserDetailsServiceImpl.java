package pl.polsl.hotelapp.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.polsl.hotelapp.repositories.UserRepo;

@Service
public class UserDetailsServiceImpl  {

    private UserRepo userRepo;

    public UserDetailsServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //todo throw if not exist - obsługa błędów
        return userRepo.findByUsername(s).get();
    }
}

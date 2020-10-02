package pl.polsl.hotelapp.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotelapp.models.Token;
import pl.polsl.hotelapp.models.User;
import pl.polsl.hotelapp.repositories.TokenRepo;
import pl.polsl.hotelapp.repositories.UserRepo;
import pl.polsl.hotelapp.services.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService users;

    private UserRepo userRepo;

    private TokenRepo tokenRepo;

    public UserController(UserService users, UserRepo userRepo, TokenRepo tokenRepo) {
        this.users = users;
        this.userRepo = userRepo;
        this.tokenRepo = tokenRepo;
    }

    @GetMapping("/all")
    public Iterable<User> getAll(){
        return users.findAll();
    }

    @GetMapping
    public Optional<User> getByUserId(@RequestParam Long index){
        return users.findById(index);
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return users.save(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        return users.save(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam Long index){
        users.deleteById(index);

    }

    @GetMapping("/for-admin")
    public String forAdmin(){
        return "for-admin";
    }

    @GetMapping("/for-user")
    public String forUser(){
        return "for-user";
    }

    @GetMapping("/sign-up")
    public String signUp(Model model){
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/register")
    public String register(User user){
        users.addUser(user);
        return "register";
    }

    @GetMapping("/token")
    public String token(@RequestParam String value){
        Token byValue = tokenRepo.findByValue(value);
        User user = byValue.getUser();
        user.setEnabled(true);
        userRepo.save(user);

        return "loggedUser";
    }
}

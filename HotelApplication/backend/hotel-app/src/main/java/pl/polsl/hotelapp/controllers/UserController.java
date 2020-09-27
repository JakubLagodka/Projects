package pl.polsl.hotelapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.polsl.hotelapp.models.Token;
import pl.polsl.hotelapp.models.User;
import pl.polsl.hotelapp.repositories.TokenRepo;
import pl.polsl.hotelapp.repositories.UserRepo;
import pl.polsl.hotelapp.services.UserService;

@Controller
public class UserController {

    private UserService userService;

    private UserRepo userRepo;

    private TokenRepo tokenRepo;

    public UserController(UserService userService, UserRepo userRepo, TokenRepo tokenRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
        this.tokenRepo = tokenRepo;
    }

    @GetMapping("/loggedUser")
    @ResponseBody
    public String loggedUser(){
        return "hello, you are logged in!";
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
        userService.addUser(user);
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

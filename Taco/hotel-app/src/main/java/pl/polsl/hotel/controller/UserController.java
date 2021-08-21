package pl.polsl.hotel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotel.model.User;
import pl.polsl.hotel.model.UserView;
import pl.polsl.hotel.service.UserService;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserView registerUser(@RequestBody UserView userPost) {
        return userService.createUser(userPost);
    }

    @GetMapping(value = "/self", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserView getUser(@ApiIgnore @RequestHeader(value = "Authorization") String token) {
        return userService.getUser(token);
    }

    @GetMapping("/all")
    public List<UserView> getUsers() {
        return userService.getUsers();
    }

    @PatchMapping(value = "/{userId}/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserView updateUser(@ApiIgnore @RequestHeader(value = "Authorization") String token,
                               @PathVariable Long userId,
                               @RequestBody User user) {
        return userService.getPatchedUser(token, userId, user);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void deleteUser(@RequestParam Long id) {
        userService.deleteById(id);

    }
}

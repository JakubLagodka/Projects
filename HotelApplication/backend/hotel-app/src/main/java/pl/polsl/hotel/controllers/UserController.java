package pl.polsl.hotel.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotel.models.User;
import pl.polsl.hotel.services.UserService;

import pl.polsl.hotel.models.UserView;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    /*  private final UserService userService;

      public UserController(UserService userService) {
          this.userService = userService;
      }

      @ResponseStatus(value = HttpStatus.CREATED)
      @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
      public User registerUser(@ApiIgnore @RequestHeader(value = "Authorization") String token,
                               @RequestBody User user) {
          return userService.createUser(token, user);
      }

      @GetMapping(value = "/self", produces = MediaType.APPLICATION_JSON_VALUE)
      public User getUser(@ApiIgnore @RequestHeader(value = "Authorization") String token) {
          return userService.getUser(token);
      }

      @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
      public Iterable<User> getUsers() {
          return userService.getUsers();
      }

      @PatchMapping(value = "/{userId}/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
      public User updateUser(@ApiIgnore @RequestHeader(value = "Authorization") String token,
                                 @PathVariable Long userId,
                                 @RequestBody User userPatch) {
          return userService.save(token, userId, userPatch);
      }*/
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserView registerUser(@ApiIgnore @RequestHeader(value = "Authorization") String token,
                                 @RequestBody User user) {
        return userService.createUser(token, user);
    }

    @GetMapping(value = "/self", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserView getUser(@ApiIgnore @RequestHeader(value = "Authorization") String token) {
        return userService.getUser(token);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserView> getUsers() {
        return userService.getUsers();
    }

    @PatchMapping(value = "/{userId}/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserView updateUser(@ApiIgnore @RequestHeader(value = "Authorization") String token,
                               @PathVariable Long userId,
                               @RequestBody User user) {
        return userService.getPatchedUser(token, userId, user);
    }
}

package pl.lagodka.shop.cotroller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import pl.lagodka.shop.model.User;
import pl.lagodka.shop.service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @GetMapping
    public Page<User> getUserPage(@RequestParam int page, @RequestParam int size) {
        return userService.getPage(PageRequest.of(page, size));
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id){
        return userService.update(user, id);
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.delete(id);
    }

}

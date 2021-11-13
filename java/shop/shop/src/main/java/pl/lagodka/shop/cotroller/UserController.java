package pl.lagodka.shop.cotroller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import pl.lagodka.shop.mapper.UserMapper;
import pl.lagodka.shop.model.dao.User;
import pl.lagodka.shop.model.dto.UserDto;
import pl.lagodka.shop.service.UserService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    private final UserMapper userMapper;

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto user) {
        return userMapper.toDto(userService.create(userMapper.toDao(user)));
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userMapper.toDto(userService.getById(id));
    }

    @GetMapping
    public Page<UserDto> getUserPage(@RequestParam int page, @RequestParam int size) {
        return userService.getPage(PageRequest.of(page, size))
                .map(userMapper::toDto);
    }

    @PutMapping("/{id}")
    public UserDto updateUser(@RequestBody UserDto user, @PathVariable Long id){
        return userMapper.toDto(userService.update(userMapper.toDao(user), id));
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.delete(id);
    }

}

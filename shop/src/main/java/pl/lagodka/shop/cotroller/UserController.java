package pl.lagodka.shop.cotroller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.lagodka.shop.mapper.UserMapper;
import pl.lagodka.shop.model.dto.UserDto;
import pl.lagodka.shop.service.UserService;
import pl.lagodka.shop.validator.group.Create;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    private final UserMapper userMapper;

    @PostMapping
    @Validated(Create.class)
    public UserDto saveUser(@RequestBody @Valid UserDto user) {
       return userMapper.toDto(userService.create(userMapper.toDao(user)));
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated() && (@securityService.hasAccessToUser(#id) || hasRole('ADMIN'))")
    @Operation(description = "get user by his id", security = @SecurityRequirement(name = "bearer"))
    public UserDto getUserById(@PathVariable Long id) {
        return userMapper.toDto(userService.getById(id));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "get page of users", security = @SecurityRequirement(name = "bearer"))
    public Page<UserDto> getUserPage(@RequestParam int page, @RequestParam int size) {
        return userService.getPage(PageRequest.of(page, size))
                .map(userMapper::toDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated() && (@securityService.hasAccessToUser(#id) || hasRole('ADMIN'))")
    @Operation(description = "update given user", security = @SecurityRequirement(name = "bearer"))
    public UserDto updateUser(@RequestBody @Valid UserDto user, @PathVariable Long id){
        return userMapper.toDto(userService.update(userMapper.toDao(user), id));
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(description = "delete given user", security = @SecurityRequirement(name = "bearer"))
    public void deleteUser(@PathVariable Long id){
        userService.delete(id);
    }

}

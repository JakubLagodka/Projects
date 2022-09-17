package pl.lagodka.hotel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.lagodka.hotel.config.MailConfig;
import pl.lagodka.hotel.flyweight.generic.strategy.mail.MailSenderStrategy;
import pl.lagodka.hotel.mapper.UserMapper;
import pl.lagodka.hotel.model.dto.UserDto;
import pl.lagodka.hotel.service.UserService;
import pl.lagodka.hotel.validator.group.Create;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    private final UserMapper userMapper;

    private final MailSenderStrategy mailSenderGenericStrategy;

    private final MailConfig mailConfig;

    @PostMapping
    @Validated(Create.class)
    public UserDto saveUser(@RequestBody @Valid UserDto user) {
        mailSenderGenericStrategy.sendMail(mailConfig,user.getMail(),"User has been created", "User with given data has been created");
        return userMapper.toDto(userService.create(userMapper.toDao(user)));
    }

    @GetMapping("/{id}")
    @PreAuthorize("isAuthenticated() && (@securityService.hasAccessToUser(#id) || hasRole('ADMIN'))")
    public UserDto getUserById(@PathVariable Long id) {
        return userMapper.toDto(userService.getById(id));
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Page<UserDto> getUserPage(@RequestParam int page, @RequestParam int size) {
        return userService.getPage(PageRequest.of(page, size))
                .map(userMapper::toDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("isAuthenticated() && (@securityService.hasAccessToUser(#id) || hasRole('ADMIN'))")
    public UserDto updateUser(@RequestBody @Valid UserDto user, @PathVariable Long id){
        return userMapper.toDto(userService.update(userMapper.toDao(user), id));
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable Long id){
        userService.delete(id);
    }

}

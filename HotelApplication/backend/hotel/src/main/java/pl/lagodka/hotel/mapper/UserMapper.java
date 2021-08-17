package pl.lagodka.hotel.mapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.lagodka.hotel.configuration.AppConfig;
import pl.lagodka.hotel.model.User;
import pl.lagodka.hotel.model.UserView;
@Component
public class UserMapper {
    private final AppConfig appConfig;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserMapper(AppConfig appConfig, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appConfig = appConfig;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public User map(UserView userView) {
        User user = new User();
        user.setUsername(userView.getUsername());
        user.setSurname(userView.getSurname());
        user.setEmail(userView.getEmail());
        user.setName(userView.getName());
        user.setPassword(appConfig.bCryptPasswordEncoder().encode(userView.getPassword()));
        return user;
    }

    public UserView map(User user) {
        UserView userView = new UserView();
        if (user.getRole() != null)
            userView.setRoleCode(user.getRole().getCode());
        userView.setId(user.getId());
        userView.setEmail(user.getEmail());
        userView.setName(user.getName());
        userView.setSurname(user.getSurname());
        userView.setUsername(user.getUsername());
        return userView;
    }
}

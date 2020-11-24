package pl.polsl.hotel.mappers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import pl.polsl.hotel.models.User;
import pl.polsl.hotel.views.UserPatch;
import pl.polsl.hotel.views.UserPost;
import pl.polsl.hotel.views.UserView;

@Component
public class UserMapper {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserMapper(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public User map(UserPost userPost) {
        User user = new User();
        user.setUsername(userPost.getUsername());
        user.setSurname(userPost.getSurname());
        user.setEmail(userPost.getEmail());
        user.setName(userPost.getName());
        user.setPassword(bCryptPasswordEncoder.encode(userPost.getPassword()));
        return user;
    }


    public void map(UserPatch userPatch, User user) {
        if (userPatch.getSurname() != null)
            user.setSurname(userPatch.getSurname());
        if (userPatch.getEmail() != null)
            user.setEmail(userPatch.getEmail());
        if (userPatch.getName() != null)
            user.setName(userPatch.getName());
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

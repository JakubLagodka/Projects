package pl.polsl.hotel.services;

import org.springframework.lang.NonNull;
import pl.polsl.hotel.views.UserPatch;
import pl.polsl.hotel.views.UserPost;
import pl.polsl.hotel.views.UserView;

import java.util.List;

public interface UserService {

    @NonNull
    UserView createUser(String token, UserPost userPost);

    @NonNull
    UserView getUser(String token);

    @NonNull
    UserView getPatchedUser(String token, Long userId, UserPatch userPatch);

    @NonNull
    List<UserView> getUsers();

}

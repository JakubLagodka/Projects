package pl.polsl.hotel.mappers;

import org.springframework.lang.NonNull;
import pl.polsl.hotel.models.User;
import pl.polsl.hotel.views.UserPatch;
import pl.polsl.hotel.views.UserPost;
import pl.polsl.hotel.views.UserView;

public interface UserMapper {

    @NonNull
    User map(UserPost userPost);

    void map(UserPatch userPatch, User user);

    UserView map(User user);

}

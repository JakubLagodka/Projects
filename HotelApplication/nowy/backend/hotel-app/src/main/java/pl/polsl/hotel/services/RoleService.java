package pl.polsl.hotel.services;

import org.springframework.lang.NonNull;
import pl.polsl.hotel.views.CodeNameView;

import java.util.List;

public interface RoleService {

    @NonNull
    List<CodeNameView> getRoles();

}

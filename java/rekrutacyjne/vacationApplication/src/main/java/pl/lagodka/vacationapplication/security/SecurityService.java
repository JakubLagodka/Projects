package pl.lagodka.vacationapplication.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.lagodka.vacationapplication.service.UserService;

@Service
@RequiredArgsConstructor
public class SecurityService {

    private final UserService userService;

    public boolean hasAccessToUser(Long id){
        return userService.getCurrentUser().getId().equals(id);

    }
}

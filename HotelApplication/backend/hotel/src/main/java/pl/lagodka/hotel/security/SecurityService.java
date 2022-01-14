package pl.lagodka.hotel.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.lagodka.hotel.service.UserService;

@Service
@RequiredArgsConstructor
public class SecurityService {

    private final UserService userService;

    public boolean hasAccessToUser(Long id){
        return userService.getCurrentUser().getId().equals(id);

    }
}

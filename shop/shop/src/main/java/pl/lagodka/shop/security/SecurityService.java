package pl.lagodka.shop.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.lagodka.shop.service.UserService;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
@Slf4j
public class SecurityService {

    private final UserService userService;

    public boolean hasAccessToUser(Long id) {
        try {
            return userService.getCurrentUser().getId().equals(id);
        } catch (EntityNotFoundException e) {
            log.warn(e.getMessage(), e);
            return false;
        }

    }
}

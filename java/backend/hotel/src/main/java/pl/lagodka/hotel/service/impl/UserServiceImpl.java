package pl.lagodka.hotel.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.lagodka.hotel.model.dao.User;
import pl.lagodka.hotel.repository.RoleRepository;
import pl.lagodka.hotel.repository.UserRepository;
import pl.lagodka.hotel.service.UserService;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Collections;

import static pl.lagodka.hotel.security.SecurityUtils.getCurrentUserLogin;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final RoleRepository roleRepository;

    @Override
    public User create(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        roleRepository.findByName("ROLE_USER").ifPresent(role -> user.setRoles(Collections.singletonList(role)));

        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User update(User user, Long id) {
        User userDb = getById(id);
        userDb.setFirstName(user.getFirstName());
        userDb.setLastName(user.getLastName());

        return userDb;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }

    @Override
    public Page<User> getPage(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getCurrentUser() {
        return userRepository.findByLogin(getCurrentUserLogin())
                .orElseThrow(() -> new EntityNotFoundException("User not logged"));
    }
}

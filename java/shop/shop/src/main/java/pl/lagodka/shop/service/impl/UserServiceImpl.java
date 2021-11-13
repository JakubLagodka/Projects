package pl.lagodka.shop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.lagodka.shop.model.dao.User;
import pl.lagodka.shop.repository.UserRepository;
import pl.lagodka.shop.service.UserService;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public User create(User user) {
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
}

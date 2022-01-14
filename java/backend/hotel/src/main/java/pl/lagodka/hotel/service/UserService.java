package pl.lagodka.hotel.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.lagodka.hotel.model.dao.User;

public interface UserService {
    User create(User user);

    User update(User user, Long id);

    void delete(Long id);

    User getById(Long id);

    Page<User> getPage(Pageable pageable);

    User getCurrentUser();
}

package pl.lagodka.vacationapplication.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.lagodka.vacationapplication.model.dao.User;

public interface UserService {

    User getById(Long id);

    User create(User user);

    User update(User user, Long id);

    void delete(Long id);

    Page<User> getPage(Pageable pageable);

    User getCurrentUser();
}

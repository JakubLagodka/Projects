package pl.lagodka.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lagodka.hotel.model.dao.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByLoginOrMail(String login, String mail);

    Optional<User> findByLogin(String login);
}

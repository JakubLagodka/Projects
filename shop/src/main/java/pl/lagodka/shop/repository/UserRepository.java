package pl.lagodka.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import pl.lagodka.shop.model.dao.User;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long>, RevisionRepository<User,Long,Integer> {

    Optional<User> findByLoginOrMail(String login, String mail);

    Optional<User> findByLogin(String login);
}

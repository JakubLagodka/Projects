package pl.lagodka.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lagodka.shop.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

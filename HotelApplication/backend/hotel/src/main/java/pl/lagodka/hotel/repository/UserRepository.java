package pl.lagodka.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import pl.lagodka.hotel.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String userName);

    @Transactional
    @Modifying
    @Query(value = "update users set dtype = ?2 where id = ?1", nativeQuery = true)
    void updateRole(Long id, String roleClassName);

}

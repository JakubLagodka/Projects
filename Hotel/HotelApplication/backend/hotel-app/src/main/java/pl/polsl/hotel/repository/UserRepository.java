package pl.polsl.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.polsl.hotel.exception.NotFoundException;

import pl.polsl.hotel.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String userName);

    @Transactional
    @Modifying
    @Query(value = "update users set dtype = ?2 where id = ?1", nativeQuery = true)
    void updateRole(Long id, String roleClassName);

    default User getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}


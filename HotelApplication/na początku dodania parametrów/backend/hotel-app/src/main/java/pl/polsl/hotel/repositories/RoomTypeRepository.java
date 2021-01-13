package pl.polsl.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.hotel.exceptions.NotFoundException;

import pl.polsl.hotel.models.Parameters;
import pl.polsl.hotel.models.RoomType;


@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
    @Transactional
    @Modifying
    @Query(value = "update rooms_type set = ?1", nativeQuery = true)
    void updateParameters(String parameterName);
    default RoomType getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}

package pl.polsl.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.hotel.exceptions.NotFoundException;

import pl.polsl.hotel.models.RoomType;


@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {


    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int  int", nativeQuery = true)
    void addTableInt();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int2  int", nativeQuery = true)
    void addTableInt2();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int3  int", nativeQuery = true)
    void addTableInt3();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int4  int", nativeQuery = true)

    void addTableInt4();
    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int5  int", nativeQuery = true)
    void addTableInt5();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int6  int", nativeQuery = true)
    void addTableInt6();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int7  int", nativeQuery = true)
    void addTableInt7();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int8  int", nativeQuery = true)
    void addTableInt8();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int9  int", nativeQuery = true)
    void addTableInt9();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD int10  int", nativeQuery = true)
    void addTableInt10();




    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD double double precision", nativeQuery = true)
    void addTableDouble();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD text text", nativeQuery = true)
    void addTableString();

    @Transactional
    @Modifying
    @Query(value = "ALTER TABLE rooms_type ADD boolean boolean", nativeQuery = true)
    void addTableBoolean();
    default RoomType getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}

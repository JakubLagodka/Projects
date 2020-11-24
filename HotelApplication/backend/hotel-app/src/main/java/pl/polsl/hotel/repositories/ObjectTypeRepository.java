package pl.polsl.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.polsl.hotel.exceptions.NotFoundException;
import pl.polsl.hotel.models.ObjectType;

@Repository
public interface ObjectTypeRepository extends JpaRepository<ObjectType, String> {
    default ObjectType getById(String code) {
        return findById(code).orElseThrow(() -> new NotFoundException(code));
    }
}

package pl.polsl.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.polsl.hotel.exceptions.NotFoundException;

import pl.polsl.hotel.models.Object;
@Repository
public interface ObjectRepository extends JpaRepository<Object, Long> {
    default Object getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}

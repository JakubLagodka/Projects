package pl.polsl.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.hotel.exceptions.NotFoundException;
import pl.polsl.hotel.models.IdEntity;

public interface BaseIdRepository<T extends IdEntity> extends JpaRepository<T, Long> {

    default T getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(id));
    }

}

package pl.polsl.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.hotel.exceptions.NotFoundException;
import pl.polsl.hotel.models.CodeEntity;

public interface BaseCodeRepository<T extends CodeEntity> extends JpaRepository<T, String> {

    default T getById(String code) {
        return findById(code).orElseThrow(() -> new NotFoundException(code));
    }

}

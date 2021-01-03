package pl.polsl.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.hotel.exceptions.NotFoundException;
import pl.polsl.hotel.models.Parameters;

public interface ParametersRepository extends JpaRepository<Parameters, Long> {

    default Parameters getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}

package pl.polsl.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.hotel.exception.NotFoundException;
import pl.polsl.hotel.model.Parameter;

public interface ParameterRepository extends JpaRepository<Parameter, Long> {

    default Parameter getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}

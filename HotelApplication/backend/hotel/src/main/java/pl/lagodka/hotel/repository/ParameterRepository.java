package pl.lagodka.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lagodka.hotel.exception.NotFoundException;
import pl.lagodka.hotel.model.Parameter;

public interface ParameterRepository extends JpaRepository<Parameter, Long> {

    default Parameter getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}

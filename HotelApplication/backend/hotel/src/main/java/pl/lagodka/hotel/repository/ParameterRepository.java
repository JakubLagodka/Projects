package pl.lagodka.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lagodka.hotel.exception.NotFoundException;
import pl.lagodka.hotel.model.Parameter;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, Long> {

    default Parameter getById(Long id) {
        return findById(id).orElseThrow(() -> new NotFoundException(id));
    }
}

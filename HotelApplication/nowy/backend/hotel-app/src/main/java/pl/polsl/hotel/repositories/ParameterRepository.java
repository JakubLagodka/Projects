package pl.polsl.hotel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import pl.polsl.hotel.exceptions.NotFoundException;
import pl.polsl.hotel.models.Parameter;

public interface ParameterRepository extends CrudRepository<Parameter, Long> {

    // default Parameter getById(Long id) {
    //    return findById(id).orElseThrow(() -> new NotFoundException(id));
   // }
}

package pl.polsl.hotel.repositories;

import org.springframework.stereotype.Repository;
import pl.polsl.hotel.models.ActionStatus;

@Repository
public interface StatusRepository extends BaseCodeRepository<ActionStatus> {

}

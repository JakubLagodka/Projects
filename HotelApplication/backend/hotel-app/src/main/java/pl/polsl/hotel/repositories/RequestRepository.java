package pl.polsl.hotel.repositories;

import org.springframework.stereotype.Repository;
import pl.polsl.hotel.models.*;
import pl.polsl.hotel.models.Object;

import java.util.List;

@Repository
public interface RequestRepository extends BaseIdRepository<Request> {

    List<Request> findAllByObjectClient(Client client);

    List<Request> findAllByActivitiesContains(List<Activity> activities);

    List<Request> findAllByActivitiesContainsAndObject(List<Activity> activities, Object object);

    List<Request> findAllByManagerAndObject(Manager manager, Object object);

}

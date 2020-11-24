package pl.polsl.hotel.services;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.exceptions.CodeAlreadyUsedException;
import pl.polsl.hotel.exceptions.ForbiddenAccessException;
import pl.polsl.hotel.models.*;
import pl.polsl.hotel.repositories.ActivityTypeRepository;

@Component
public class ActivityTypeService implements StartUpFiller {

    private final ActivityTypeRepository activityTypeRepository;
    private final AuthenticationTokenService authenticationTokenService;

    public ActivityTypeService(ActivityTypeRepository activityTypeRepository, AuthenticationTokenService authenticationTokenService) {
        this.activityTypeRepository = activityTypeRepository;
        this.authenticationTokenService = authenticationTokenService;
    }


    public ActivityType createActivityType(String token, ActivityType activityType) {
        validateIfUserCanModify(token);
        if (activityTypeRepository.existsById(activityType.getCode()))
            throw new CodeAlreadyUsedException(activityType.getCode());

        return activityTypeRepository.save(activityType);
    }


    public ActivityType getPatchedActivityType(String token, String activityTypeCode) {
        validateIfUserCanModify(token);
        ActivityType activityType = activityTypeRepository.getById(activityTypeCode);
        return activityTypeRepository.save(activityType);
    }


    public Iterable<ActivityType> getActivitiesTypes(String token) {
        User currentUser = authenticationTokenService.getUserFromToken(token);
        if (!(currentUser instanceof Manager || currentUser instanceof Worker))
            throw new ForbiddenAccessException(Manager.class, Worker.class);
        return activityTypeRepository.findAll();
    }

    private void validateIfUserCanModify(String token) {
        User user = authenticationTokenService.getUserFromToken(token);
        if (!(user instanceof Manager))
            throw new ForbiddenAccessException(Manager.class);
    }


    public void createInitialData() throws RuntimeException {
        ActivityType fix = new ActivityType();
        fix.setCode("FIX");
        fix.setName("Fix");
        activityTypeRepository.save(fix);

        ActivityType test = new ActivityType();
        test.setCode("TST");
        test.setName("Test");
        activityTypeRepository.save(test);

        ActivityType refactor = new ActivityType();
        refactor.setCode("REF");
        refactor.setName("Refactor");
        activityTypeRepository.save(refactor);
    }
}

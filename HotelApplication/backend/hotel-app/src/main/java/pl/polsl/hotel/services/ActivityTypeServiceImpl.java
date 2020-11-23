package pl.polsl.hotel.services;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.exceptions.CodeAlreadyUsedException;
import pl.polsl.hotel.exceptions.ForbiddenAccessException;
import pl.polsl.hotel.mappers.CodeNameMapper;
import pl.polsl.hotel.models.ActivityType;
import pl.polsl.hotel.models.Manager;
import pl.polsl.hotel.models.User;
import pl.polsl.hotel.models.Worker;
import pl.polsl.hotel.repositories.ActivityTypeRepository;
import pl.polsl.hotel.views.CodeNamePatch;
import pl.polsl.hotel.views.CodeNamePost;
import pl.polsl.hotel.views.CodeNameView;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActivityTypeServiceImpl implements ActivityTypeService, StartUpFiller {

    private final ActivityTypeRepository activityTypeRepository;
    private final AuthenticationService authenticationService;
    private final CodeNameMapper codeNameMapper;

    public ActivityTypeServiceImpl(ActivityTypeRepository activityTypeRepository, AuthenticationService authenticationService, CodeNameMapper codeNameMapper) {
        this.activityTypeRepository = activityTypeRepository;
        this.authenticationService = authenticationService;
        this.codeNameMapper = codeNameMapper;
    }

    @Override
    public CodeNameView createActivityType(String token, CodeNamePost codeNamePost) {
        validateIfUserCanModify(token);
        if (activityTypeRepository.existsById(codeNamePost.getCode()))
            throw new CodeAlreadyUsedException(codeNamePost.getCode());
        ActivityType activityType = new ActivityType();
        codeNameMapper.map(codeNamePost, activityType);
        return codeNameMapper.map(activityTypeRepository.save(activityType));
    }

    @Override
    public CodeNameView getPatchedActivityType(String token, String activityTypeCode, CodeNamePatch codeNamePatch) {
        validateIfUserCanModify(token);
        ActivityType activityType = activityTypeRepository.getById(activityTypeCode);
        codeNameMapper.map(codeNamePatch, activityType);
        return codeNameMapper.map(activityTypeRepository.save(activityType));
    }

    @Override
    public List<CodeNameView> getActivitiesTypes(String token) {
        User currentUser = authenticationService.getUserFromToken(token);
        if (!(currentUser instanceof Manager || currentUser instanceof Worker))
            throw new ForbiddenAccessException(Manager.class, Worker.class);
        List<ActivityType> activityTypes = activityTypeRepository.findAll();
        return activityTypes.stream().map(codeNameMapper::map).collect(Collectors.toList());
    }

    private void validateIfUserCanModify(String token) {
        User user = authenticationService.getUserFromToken(token);
        if (!(user instanceof Manager))
            throw new ForbiddenAccessException(Manager.class);
    }

    @Override
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

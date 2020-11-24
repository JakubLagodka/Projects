package pl.polsl.hotel.services;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.exceptions.BadRequestException;
import pl.polsl.hotel.exceptions.ForbiddenAccessException;
import pl.polsl.hotel.mappers.ActivityMapper;
import pl.polsl.hotel.models.Activity;
import pl.polsl.hotel.models.Request;
import pl.polsl.hotel.models.User;
import pl.polsl.hotel.models.Worker;
import pl.polsl.hotel.repositories.ActivityRepository;
import pl.polsl.hotel.repositories.ActivityTypeRepository;
import pl.polsl.hotel.repositories.RequestRepository;
import pl.polsl.hotel.repositories.UserRepository;
import pl.polsl.hotel.views.ActionProgressPatch;
import pl.polsl.hotel.views.ActivityPatch;
import pl.polsl.hotel.views.ActivityPost;
import pl.polsl.hotel.views.ActivityView;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final RequestRepository requestRepository;
    private final UserRepository userRepository;
    private final ActivityTypeRepository activityTypeRepository;
    private final AuthenticationService authenticationService;
    private final ActionService actionService;
    private final ActivityMapper activityMapper;

    public ActivityService(ActivityRepository activityRepository, RequestRepository requestRepository, UserRepository userRepository, ActivityTypeRepository activityTypeRepository, AuthenticationService authenticationService, ActionService actionService, ActivityMapper activityMapper) {
        this.activityRepository = activityRepository;
        this.requestRepository = requestRepository;
        this.userRepository = userRepository;
        this.activityTypeRepository = activityTypeRepository;
        this.authenticationService = authenticationService;
        this.actionService = actionService;
        this.activityMapper = activityMapper;
    }


    public ActivityView createActivity(String token, ActivityPost activityPost) {
        User manager = authenticationService.getUserFromToken(token);
        Request request = requestRepository.getById(activityPost.getRequestId());
        if (!manager.equals(request.getManager()))
            throw new ForbiddenAccessException("Only manager that created request can add activities to it");
        Activity activity = activityMapper.map(activityPost);
        updateActivityTypeAndWorker(activity, activityPost.getActivityTypeCode(), activityPost.getWorkerId());
        activity.setRequest(request);
        activity.setActionStatus(actionService.getInitialStatus());
        return activityMapper.map(activityRepository.save(activity));
    }


    public ActivityView getPatchedActivity(String token, Long activityId, ActionProgressPatch actionProgressPatch) {
        User user = authenticationService.getUserFromToken(token);
        Activity activity = activityRepository.getById(activityId);
        if (activity.getEndDate() != null)
            throw new BadRequestException("Cannot update progress in already finished activity");
        if (!user.equals(activity.getWorker()) && !user.equals(activity.getRequest().getManager()))
            throw new ForbiddenAccessException("Only worker assigned to activity and manager that created it can update its progress");
        actionService.patchAction(actionProgressPatch, activity);
        return activityMapper.map(activityRepository.save(activity));
    }


    public ActivityView getPatchedActivity(String token, Long activityId, ActivityPatch activityPatch) {
        User currentUser = authenticationService.getUserFromToken(token);
        Activity activity = activityRepository.getById(activityId);
        if (!currentUser.equals(activity.getRequest().getManager()))
            throw new ForbiddenAccessException("Only manager that created request can update its parameters");
        updateActivityTypeAndWorker(activity, activityPatch.getActivityTypeCode(), activityPatch.getWorkerId());
        activityMapper.map(activityPatch, activity);
        return activityMapper.map(activityRepository.save(activity));
    }


    public List<ActivityView> getRequestActivities(String token, Long requestId) {
        User currentUser = authenticationService.getUserFromToken(token);
        Request request = requestRepository.getById(requestId);
        if (!currentUser.equals(request.getManager()))
            throw new ForbiddenAccessException("Only manager that created request can retrieve its activities");
        List<Activity> activities = request.getActivities();
        return activities.stream().map(activityMapper::map).collect(Collectors.toList());
    }


    public List<ActivityView> getWorkerActivities(String token) {
        User currentUser = authenticationService.getUserFromToken(token);
        if (!(currentUser instanceof Worker))
            throw new BadRequestException("This request is designed for workers");
        List<Activity> activities = ((Worker) currentUser).getActivities();
        return activities.stream().map(activityMapper::map).collect(Collectors.toList());
    }


    public void deleteActivity(String token, Long activityId) {
        User currentUser = authenticationService.getUserFromToken(token);
        Activity activity = activityRepository.getById(activityId);
        if (!currentUser.equals(activity.getRequest().getManager()))
            throw new ForbiddenAccessException("Only manager that created request can remove it");
        activityRepository.delete(activity);
    }

    private void updateActivityTypeAndWorker(Activity activity, String activityTypeCode, Long workerId) {
        if (activityTypeCode != null)
            activity.setActivityType(activityTypeRepository.getById(activityTypeCode));
        if (workerId != null) {
            User worker = userRepository.getById(workerId);
            if (!(worker instanceof Worker))
                throw new BadRequestException("WorkerId does not point at worker");
            activity.setWorker((Worker) worker);
        }
    }

}

package pl.polsl.hotel.mappers;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.models.Activity;
import pl.polsl.hotel.views.ActivityPatch;
import pl.polsl.hotel.views.ActivityPost;
import pl.polsl.hotel.views.ActivityView;

@Component
public class ActivityMapperImpl implements ActivityMapper {

    private final ActionMapper actionMapper;

    public ActivityMapperImpl(ActionMapper actionMapper) {
        this.actionMapper = actionMapper;
    }

    @Override
    public Activity map(ActivityPost activityPost) {
        Activity activity = new Activity();
        actionMapper.map(activityPost, activity);
        return activity;
    }

    @Override
    public void map(ActivityPatch activityPatch, Activity activity) {
        actionMapper.map(activityPatch, activity);
    }

    @Override
    public ActivityView map(Activity activity) {
        ActivityView activityView = new ActivityView();
        actionMapper.map(activity, activityView);
        if (activity.getWorker() != null)
            activityView.setWorkerId(activity.getWorker().getId());
        activityView.setRequestId(activity.getRequest().getId());
        if (activity.getActivityType() != null)
            activityView.setActivityTypeCode(activity.getActivityType().getCode());
        return activityView;
    }

}

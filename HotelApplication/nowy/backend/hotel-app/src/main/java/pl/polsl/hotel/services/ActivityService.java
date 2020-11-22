package pl.polsl.hotel.services;

import org.springframework.lang.NonNull;
import pl.polsl.hotel.views.ActionProgressPatch;
import pl.polsl.hotel.views.ActivityPatch;
import pl.polsl.hotel.views.ActivityPost;
import pl.polsl.hotel.views.ActivityView;

import java.util.List;

public interface ActivityService {

    @NonNull
    ActivityView createActivity(String token, ActivityPost activityPost);

    @NonNull
    ActivityView getPatchedActivity(String token, Long activityId, ActionProgressPatch actionProgressPatch);

    @NonNull
    ActivityView getPatchedActivity(String token, Long activityId, ActivityPatch activityPatch);

    @NonNull
    List<ActivityView> getRequestActivities(String token, Long requestId);

    @NonNull
    List<ActivityView> getWorkerActivities(String token);

    void deleteActivity(String token, Long activityId);

}

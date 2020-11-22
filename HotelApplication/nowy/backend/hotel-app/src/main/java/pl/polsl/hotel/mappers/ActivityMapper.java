package pl.polsl.hotel.mappers;

import org.springframework.lang.NonNull;
import pl.polsl.hotel.models.Activity;
import pl.polsl.hotel.views.ActivityPatch;
import pl.polsl.hotel.views.ActivityPost;
import pl.polsl.hotel.views.ActivityView;

public interface ActivityMapper {

    @NonNull
    Activity map(ActivityPost activityPost);

    void map(ActivityPatch activityPatch, Activity activity);

    @NonNull
    ActivityView map(Activity activity);

}

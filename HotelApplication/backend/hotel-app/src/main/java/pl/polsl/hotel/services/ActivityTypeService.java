package pl.polsl.hotel.services;

import org.springframework.lang.NonNull;
import pl.polsl.hotel.views.CodeNamePatch;
import pl.polsl.hotel.views.CodeNamePost;
import pl.polsl.hotel.views.CodeNameView;

import java.util.List;

public interface ActivityTypeService {

    @NonNull
    CodeNameView createActivityType(String token, CodeNamePost codeNamePost);

    @NonNull
    CodeNameView getPatchedActivityType(String token, String activityTypeCode, CodeNamePatch codeNamePatch);

    @NonNull
    List<CodeNameView> getActivitiesTypes(String token);

}

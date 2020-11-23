package pl.polsl.hotel.services;

import org.springframework.lang.NonNull;
import pl.polsl.hotel.views.ActionProgressPatch;
import pl.polsl.hotel.views.RequestPatch;
import pl.polsl.hotel.views.RequestPost;
import pl.polsl.hotel.views.RequestView;

import java.util.List;

public interface RequestService {

    @NonNull
    RequestView createRequest(String token, RequestPost requestPost);

    @NonNull
    RequestView getPatchedRequest(String token, Long requestId, ActionProgressPatch actionProgressPatch);

    @NonNull
    RequestView getPatchedRequest(String token, Long requestId, RequestPatch requestPatch);

    void deleteRequest(String token, Long requestId);

    @NonNull
    List<RequestView> getRequests(String token);

    @NonNull
    List<RequestView> getRequests(String token, Long objectId);

}

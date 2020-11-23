package pl.polsl.hotel.services;

import org.springframework.lang.NonNull;
import pl.polsl.hotel.views.ObjectPatch;
import pl.polsl.hotel.views.ObjectPost;
import pl.polsl.hotel.views.ObjectView;

import java.util.List;

public interface ObjectService {

    @NonNull
    ObjectView createObject(String token, ObjectPost objectPost);

    @NonNull
    ObjectView getPatchedObject(String token, Long objectId, ObjectPatch objectPatch);

    @NonNull
    List<ObjectView> getObjects(String token);

    void deleteObject(String token, Long objectId);

}

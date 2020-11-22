package pl.polsl.hotel.mappers;

import org.springframework.lang.NonNull;
import pl.polsl.hotel.models.Object;
import pl.polsl.hotel.views.ObjectPatch;
import pl.polsl.hotel.views.ObjectPost;
import pl.polsl.hotel.views.ObjectView;

public interface ObjectMapper {

    @NonNull
    Object map(ObjectPost objectPost);

    void map(ObjectPatch objectPatch, Object object);

    @NonNull
    ObjectView map(Object object);

}

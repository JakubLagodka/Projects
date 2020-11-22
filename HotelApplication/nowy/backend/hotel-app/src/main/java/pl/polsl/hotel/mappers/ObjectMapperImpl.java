package pl.polsl.hotel.mappers;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.models.Object;
import pl.polsl.hotel.views.ObjectPatch;
import pl.polsl.hotel.views.ObjectPost;
import pl.polsl.hotel.views.ObjectView;

@Component
public class ObjectMapperImpl implements ObjectMapper {

    @Override
    public Object map(ObjectPost objectPost) {
        Object object = new Object();
        object.setName(objectPost.getName());
        return object;
    }

    @Override
    public void map(ObjectPatch objectPatch, Object object) {
        if (objectPatch.getName() != null)
            object.setName(objectPatch.getName());
    }

    @Override
    public ObjectView map(Object object) {
        ObjectView objectView = new ObjectView();
        objectView.setName(object.getName());
        objectView.setClientId(object.getClient().getId());
        objectView.setId(object.getId());
        objectView.setObjectTypeCode(object.getObjectType().getCode());
        return objectView;
    }
}

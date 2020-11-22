package pl.polsl.hotel.services;

import org.springframework.lang.NonNull;
import pl.polsl.hotel.views.CodeNamePatch;
import pl.polsl.hotel.views.CodeNamePost;
import pl.polsl.hotel.views.CodeNameView;

import java.util.List;

public interface ObjectTypeService {

    @NonNull
    CodeNameView createObjectType(String token, CodeNamePost codeNamePost);

    @NonNull
    CodeNameView getPatchedObjectType(String token, String objectTypeCode, CodeNamePatch codeNamePatch);

    @NonNull
    List<CodeNameView> getObjectsTypes(String token);

}

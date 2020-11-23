package pl.polsl.hotel.mappers;

import org.springframework.lang.NonNull;
import pl.polsl.hotel.models.Request;
import pl.polsl.hotel.views.RequestPatch;
import pl.polsl.hotel.views.RequestPost;
import pl.polsl.hotel.views.RequestView;

public interface RequestMapper {

    @NonNull
    Request map(RequestPost requestPost);

    void map(RequestPatch requestPatch, Request request);

    @NonNull
    RequestView map(Request request);

}

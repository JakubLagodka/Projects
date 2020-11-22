package pl.polsl.hotel.mappers;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.models.Request;
import pl.polsl.hotel.views.RequestPatch;
import pl.polsl.hotel.views.RequestPost;
import pl.polsl.hotel.views.RequestView;

@Component
public class RequestMapperImpl implements RequestMapper {

    private final ActionMapper actionMapper;

    public RequestMapperImpl(ActionMapper actionMapper) {
        this.actionMapper = actionMapper;
    }

    @Override
    public Request map(RequestPost requestPost) {
        Request request = new Request();
        actionMapper.map(requestPost, request);
        return request;
    }

    @Override
    public void map(RequestPatch requestPatch, Request request) {
        actionMapper.map(requestPatch, request);
    }

    @Override
    public RequestView map(Request request) {
        RequestView requestView = new RequestView();
        actionMapper.map(request, requestView);
        requestView.setObjectId(request.getObject().getId());
        return requestView;
    }

}

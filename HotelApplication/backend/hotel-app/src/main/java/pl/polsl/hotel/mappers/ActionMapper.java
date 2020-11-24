package pl.polsl.hotel.mappers;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.models.Action;
import pl.polsl.hotel.views.ActionPatch;
import pl.polsl.hotel.views.ActionPost;
import pl.polsl.hotel.views.ActionView;

@Component
public class ActionMapper {


    public <T extends Action, R extends ActionPost> void map(R actionPost, T action) {
        action.setDescription(actionPost.getDescription());
    }


    public <T extends Action, R extends ActionPatch> void map(R actionPatch, T action) {
        if (actionPatch.getHasDescription())
            action.setDescription(actionPatch.getDescription());
    }


    public <T extends ActionView, R extends Action> void map(R action, T actionView) {
        actionView.setDescription(action.getDescription());
        actionView.setEndDate(action.getEndDate());
        actionView.setRegisterDate(action.getRegisterDate());
        actionView.setId(action.getId());
        actionView.setResult(action.getResult());
        actionView.setStatusCode(action.getActionStatus().getCode());
    }

}

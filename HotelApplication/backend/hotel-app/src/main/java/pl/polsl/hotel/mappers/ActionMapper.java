package pl.polsl.hotel.mappers;

import pl.polsl.hotel.models.Action;
import pl.polsl.hotel.views.ActionPatch;
import pl.polsl.hotel.views.ActionPost;
import pl.polsl.hotel.views.ActionView;

public interface ActionMapper {

    <T extends Action, R extends ActionPost> void map(R actionPost, T action);

    <T extends Action, R extends ActionPatch> void map(R actionPatch, T action);

    <T extends ActionView, R extends Action> void map(R action, T actionView);

}

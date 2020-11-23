package pl.polsl.hotel.services;

import org.springframework.lang.NonNull;
import pl.polsl.hotel.models.Action;
import pl.polsl.hotel.models.ActionStatus;
import pl.polsl.hotel.views.ActionProgressPatch;

public interface ActionService {

    @NonNull
    <T extends Action> void patchAction(ActionProgressPatch actionProgressPatch, T action);

    @NonNull
    ActionStatus getInitialStatus();

}

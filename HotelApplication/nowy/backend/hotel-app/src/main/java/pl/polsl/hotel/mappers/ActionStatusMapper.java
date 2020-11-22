package pl.polsl.hotel.mappers;

import org.springframework.lang.NonNull;
import pl.polsl.hotel.models.ActionStatus;
import pl.polsl.hotel.views.ActionStatusView;

public interface ActionStatusMapper {

    @NonNull
    ActionStatusView map(ActionStatus actionStatus);

}

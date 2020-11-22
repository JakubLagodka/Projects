package pl.polsl.hotel.services;

import org.springframework.lang.NonNull;
import pl.polsl.hotel.views.ActionStatusView;

import java.util.List;

public interface ActionStatusService {

    @NonNull
    List<ActionStatusView> getAvailableStatuses();

}

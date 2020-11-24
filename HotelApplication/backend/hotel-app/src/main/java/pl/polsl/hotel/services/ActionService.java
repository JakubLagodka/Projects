package pl.polsl.hotel.services;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.exceptions.BadRequestException;
import pl.polsl.hotel.models.Action;
import pl.polsl.hotel.models.ActionStatus;
import pl.polsl.hotel.repositories.StatusRepository;

import java.util.Date;

@Component
public class ActionService {

    private final StatusRepository statusRepository;

    public ActionService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }


    public <T extends Action> void patchAction(ActionStatus actionStatus, T action) {
        if (actionStatus.getCode() != null) {
            ActionStatus ret_actionStatus = statusRepository.getById(actionStatus.getCode());
            if (!action.getActionStatus().getChildActionStatuses().contains(actionStatus))
                throw new BadRequestException("Status broke requested flow");
            action.setActionStatus(ret_actionStatus);
            if (actionStatus.getChildActionStatuses().isEmpty()) {
                action.setResult(actionStatus.getCode());
                action.setEndDate(new Date());
            }
        }
    }


    public ActionStatus getInitialStatus() {
        return statusRepository
                .findAll()
                .stream()
                .filter(status -> status.getParentActionStatuses().isEmpty())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not found initial status"));
    }

}

package pl.polsl.hotel.services;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.exceptions.BadRequestException;
import pl.polsl.hotel.models.Action;
import pl.polsl.hotel.models.ActionStatus;
import pl.polsl.hotel.repositories.StatusRepository;
import pl.polsl.hotel.views.ActionProgressPatch;

import java.util.Date;

@Component
public class ActionServiceImpl implements ActionService {

    private final StatusRepository statusRepository;

    public ActionServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public <T extends Action> void patchAction(ActionProgressPatch actionProgressPatch, T action) {
        if (actionProgressPatch.getStatusCode() != null) {
            ActionStatus actionStatus = statusRepository.getById(actionProgressPatch.getStatusCode());
            if (!action.getActionStatus().getChildActionStatuses().contains(actionStatus))
                throw new BadRequestException("Status broke requested flow");
            action.setActionStatus(actionStatus);
            if (actionStatus.getChildActionStatuses().isEmpty()) {
                action.setResult(actionProgressPatch.getResult());
                action.setEndDate(new Date());
            }
        }
    }

    @Override
    public ActionStatus getInitialStatus() {
        return statusRepository
                .findAll()
                .stream()
                .filter(status -> status.getParentActionStatuses().isEmpty())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Not found initial status"));
    }

}

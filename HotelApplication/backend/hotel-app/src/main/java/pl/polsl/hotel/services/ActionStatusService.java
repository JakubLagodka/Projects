package pl.polsl.hotel.services;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.mappers.ActionStatusMapper;
import pl.polsl.hotel.models.ActionStatus;
import pl.polsl.hotel.repositories.StatusRepository;
import pl.polsl.hotel.views.ActionStatusView;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ActionStatusService implements StartUpFiller {

    private final StatusRepository statusRepository;
    private final ActionStatusMapper actionStatusMapper;

    public ActionStatusService(StatusRepository statusRepository, ActionStatusMapper actionStatusMapper) {
        this.statusRepository = statusRepository;
        this.actionStatusMapper = actionStatusMapper;
    }


    public List<ActionStatusView> getAvailableStatuses() {
        List<ActionStatus> actionStatuses = statusRepository.findAll();
        return actionStatuses.stream().map(actionStatusMapper::map).collect(Collectors.toList());
    }


    public void createInitialData() throws RuntimeException {
        ActionStatus actionStatusOpen = new ActionStatus();
        actionStatusOpen.setCode("OPN");
        actionStatusOpen.setName("Open");

        ActionStatus actionStatusProgress = new ActionStatus();
        actionStatusProgress.setCode("PRO");
        actionStatusProgress.setName("Progress");

        ActionStatus actionStatusCancelled = new ActionStatus();
        actionStatusCancelled.setCode("CAN");
        actionStatusCancelled.setName("Canceled");

        ActionStatus actionStatusFinished = new ActionStatus();
        actionStatusFinished.setCode("FIN");
        actionStatusFinished.setName("Finished");

        statusRepository.saveAll(Arrays.asList(actionStatusFinished, actionStatusCancelled, actionStatusProgress, actionStatusOpen));

        actionStatusOpen.setChildActionStatuses(new HashSet<>(Arrays.asList(actionStatusCancelled, actionStatusFinished, actionStatusProgress)));
        actionStatusProgress.setChildActionStatuses(new HashSet<>(Arrays.asList(actionStatusCancelled, actionStatusFinished)));
        actionStatusProgress.setParentActionStatuses(new HashSet<>(Collections.singletonList(actionStatusOpen)));
        actionStatusCancelled.setParentActionStatuses(new HashSet<>(Arrays.asList(actionStatusOpen, actionStatusProgress)));
        actionStatusFinished.setParentActionStatuses(new HashSet<>(Arrays.asList(actionStatusOpen, actionStatusProgress)));

        statusRepository.saveAll(Arrays.asList(actionStatusFinished, actionStatusCancelled, actionStatusProgress, actionStatusOpen));
    }

}

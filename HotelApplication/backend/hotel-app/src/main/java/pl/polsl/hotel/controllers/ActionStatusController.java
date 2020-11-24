package pl.polsl.hotel.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.polsl.hotel.services.ActionStatusService;


@RestController
@RequestMapping(value = "/action_status")
public class ActionStatusController {

    private final ActionStatusService actionStatusService;

    public ActionStatusController(ActionStatusService actionStatusService) {
        this.actionStatusService = actionStatusService;
    }

    /*@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ActionStatus> getRequestActivities() {
        return actionStatusService.getAvailableStatuses();
    }*/


}

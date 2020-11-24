package pl.polsl.hotel.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotel.models.ActivityType;
import pl.polsl.hotel.services.ActivityTypeService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(value = "/activity_type")
public class ActivityTypeController {

    private final ActivityTypeService activityTypeService;

    public ActivityTypeController(ActivityTypeService activityTypeService) {
        this.activityTypeService = activityTypeService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ActivityType createActivityType(@ApiIgnore @RequestHeader(value = "Authorization") String token,
                                           @RequestBody ActivityType codeNamePost) {
        return activityTypeService.createActivityType(token, codeNamePost);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<ActivityType> getActivityTypes(@ApiIgnore @RequestHeader(value = "Authorization") String token) {
        return activityTypeService.getActivitiesTypes(token);
    }

    @PatchMapping(value = "/{activityTypeCode}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ActivityType updateActivityType(@ApiIgnore @RequestHeader(value = "Authorization") String token,
                                           @PathVariable String activityTypeCode,
                                           @RequestBody ActivityType codeNamePatch) {
        return activityTypeService.getPatchedActivityType(token, activityTypeCode);
    }

}

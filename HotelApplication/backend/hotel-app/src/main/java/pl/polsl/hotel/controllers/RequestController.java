package pl.polsl.hotel.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotel.models.ActionStatus;
import pl.polsl.hotel.models.Request;
import pl.polsl.hotel.services.RequestService;

import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping(value = "/request")
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Request createRequest(@ApiIgnore @RequestHeader(value = "Authorization") String token,
                                 @RequestBody Request request) {
        return requestService.createRequest(token, request);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Request> getRequests(@ApiIgnore @RequestHeader(value = "Authorization") String token,
                                         @RequestParam(required = false) Long objectId) {
        if (objectId != null)
            return requestService.getRequests(token, objectId);
        else
            return requestService.getRequests(token);
    }

    @PatchMapping(value = "/progress/{requestId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Request updateRequestProgress(@ApiIgnore @RequestHeader(value = "Authorization") String token,
                                             @PathVariable Long requestId,
                                             @RequestBody ActionStatus actionStatus) {
        return requestService.getPatchedRequest(token, requestId, actionStatus);
    }

    @PatchMapping(value = "/{requestId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Request updateRequest(@ApiIgnore @RequestHeader(value = "Authorization") String token,
                                     @PathVariable Long requestId,
                                     @RequestBody ActionStatus actionStatus) {
        return requestService.getPatchedRequest(token, requestId, actionStatus);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{requestId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteRequest(@ApiIgnore @RequestHeader(value = "Authorization") String token,
                              @PathVariable Long requestId) {
        requestService.deleteRequest(token, requestId);
    }


}

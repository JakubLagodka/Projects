package pl.polsl.hotel.services;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.exceptions.BadRequestException;
import pl.polsl.hotel.exceptions.ForbiddenAccessException;
import pl.polsl.hotel.models.*;
import pl.polsl.hotel.repositories.RequestRepository;

import java.util.List;

@Component
public class RequestService {

    private final RequestRepository requestRepository;
    private final AuthenticationTokenService authenticationTokenService;
    private final ActionService actionService;

    public RequestService(RequestRepository requestRepository, AuthenticationTokenService authenticationTokenService, ActionService actionService) {
        this.requestRepository = requestRepository;
        this.authenticationTokenService = authenticationTokenService;
        this.actionService = actionService;
    }


    public Request createRequest(String token, Request request) {
        User currentUser = authenticationTokenService.getUserFromToken(token);
        if (!(currentUser instanceof Manager))
            throw new ForbiddenAccessException(Manager.class);
        Request ret_request = new Request();
        ret_request.setManager((Manager) currentUser);
        ret_request.setActionStatus(actionService.getInitialStatus());
        return requestRepository.save(ret_request);
    }


    public Request getPatchedRequest(String token, Long requestId, ActionStatus actionStatus) {
        User currentUser = authenticationTokenService.getUserFromToken(token);
        Request request = requestRepository.getById(requestId);
        if (request.getEndDate() != null)
            throw new BadRequestException("Cannot update progress in already finished request");
        if (!currentUser.equals(request.getManager()))
            throw new ForbiddenAccessException("Only manager that created request can update its progress");
        actionService.patchAction(actionStatus, request);
        return requestRepository.save(request);
    }


  /*  public Request getPatchedRequest(String token, Long requestId, RequestPatch requestPatch) {
        User currentUser = authenticationService.getUserFromToken(token);
        Request request = requestRepository.getById(requestId);
        if (!currentUser.equals(request.getManager()))
            throw new ForbiddenAccessException("Only manager that created request can update it");

        return requestRepository.save(request);
    }*/


    public void deleteRequest(String token, Long requestId) {
        User currentUser = authenticationTokenService.getUserFromToken(token);
        Request request = requestRepository.getById(requestId);
        if (!currentUser.equals(request.getManager()))
            throw new ForbiddenAccessException("Only manager that created request can remove it");
        requestRepository.delete(request);
    }


    public List<Request> getRequests(String token, Long objectId) {
        User currentUser = authenticationTokenService.getUserFromToken(token);
        List<Request> requests = null;
        if (currentUser instanceof Manager)
            requests = requestRepository.findAllByManager((Manager) currentUser);

        if (currentUser instanceof Worker)
            requests = requestRepository.findAllByActivitiesContains(((Worker) currentUser).getActivities());
        if (requests == null)
            throw new ForbiddenAccessException(Manager.class, Worker.class, Client.class);
        return requests;
    }


    public List<Request> getRequests(String token) {
        User currentUser = authenticationTokenService.getUserFromToken(token);
        List<Request> requests = null;
        if (currentUser instanceof Manager)
            requests = ((Manager) currentUser).getRequests();
        if (currentUser instanceof Worker)
            requests = requestRepository.findAllByActivitiesContains(((Worker) currentUser).getActivities());
        if (requests == null)
            throw new ForbiddenAccessException(Manager.class, Worker.class, Client.class);
        return requests;
    }

}

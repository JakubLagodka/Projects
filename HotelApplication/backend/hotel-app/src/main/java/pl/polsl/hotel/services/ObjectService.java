package pl.polsl.hotel.services;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.exceptions.BadRequestException;
import pl.polsl.hotel.exceptions.ForbiddenAccessException;
import pl.polsl.hotel.models.Client;
import pl.polsl.hotel.models.Manager;
import pl.polsl.hotel.models.Object;
import pl.polsl.hotel.models.User;
import pl.polsl.hotel.repositories.ObjectRepository;
import pl.polsl.hotel.repositories.ObjectTypeRepository;
import pl.polsl.hotel.repositories.UserRepository;


@Component
public class ObjectService  {

    private final ObjectRepository objectRepository;
    private final AuthenticationTokenService authenticationTokenService;
    private final ObjectTypeRepository objectTypeRepository;
    private final UserRepository userRepository;


    public ObjectService(ObjectRepository objectRepository, AuthenticationTokenService authenticationTokenService, ObjectTypeRepository objectTypeRepository, UserRepository userRepository) {
        this.objectRepository = objectRepository;
        this.authenticationTokenService = authenticationTokenService;
        this.objectTypeRepository = objectTypeRepository;
        this.userRepository = userRepository;
    }


    public Object createObject(String token, Object object) {
        checkModifyPermission(token);
        User client = userRepository.getById(object.getId());
        if (!(client instanceof Client))
            throw new BadRequestException("clientId does not point at Client");
        object.setClient((Client) client);
        object.setObjectType(objectTypeRepository.getById(object.getObjectType().getCode()));
        return objectRepository.save(object);
    }


    public Object getPatchedObject(String token, Long objectId) {
        checkModifyPermission(token);
        Object object = objectRepository.getById(objectId);
        return objectRepository.save(object);
    }


    public Iterable<Object> getObjects(String token) {
        User user = authenticationTokenService.getUserFromToken(token);
        Iterable<Object> objects = null;
        if (user instanceof Client)
            objects = ((Client) user).getObjects();
        if (user instanceof Manager)
            objects = objectRepository.findAll();
        if (objects == null)
            throw new ForbiddenAccessException(Manager.class, Client.class);
        return objects;
    }


    public void deleteObject(String token, Long objectId) {
        checkModifyPermission(token);
        objectRepository.delete(objectRepository.getById(objectId));
    }

    private void checkModifyPermission(String token) {
        User user = authenticationTokenService.getUserFromToken(token);
        if (!(user instanceof Manager))
            throw new ForbiddenAccessException(Manager.class);
    }

}

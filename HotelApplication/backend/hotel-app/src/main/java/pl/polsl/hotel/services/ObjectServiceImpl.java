package pl.polsl.hotel.services;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.exceptions.BadRequestException;
import pl.polsl.hotel.exceptions.ForbiddenAccessException;
import pl.polsl.hotel.mappers.ObjectMapper;
import pl.polsl.hotel.models.Client;
import pl.polsl.hotel.models.Manager;
import pl.polsl.hotel.models.Object;
import pl.polsl.hotel.models.User;
import pl.polsl.hotel.repositories.ObjectRepository;
import pl.polsl.hotel.repositories.ObjectTypeRepository;
import pl.polsl.hotel.repositories.UserRepository;
import pl.polsl.hotel.views.ObjectPatch;
import pl.polsl.hotel.views.ObjectPost;
import pl.polsl.hotel.views.ObjectView;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ObjectServiceImpl implements ObjectService {

    private final ObjectRepository objectRepository;
    private final AuthenticationService authenticationService;
    private final ObjectTypeRepository objectTypeRepository;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;

    public ObjectServiceImpl(ObjectRepository objectRepository, AuthenticationService authenticationService, ObjectTypeRepository objectTypeRepository, UserRepository userRepository, ObjectMapper objectMapper) {
        this.objectRepository = objectRepository;
        this.authenticationService = authenticationService;
        this.objectTypeRepository = objectTypeRepository;
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public ObjectView createObject(String token, ObjectPost objectPost) {
        checkModifyPermission(token);
        Object object = objectMapper.map(objectPost);
        User client = userRepository.getById(objectPost.getClientId());
        if (!(client instanceof Client))
            throw new BadRequestException("clientId does not point at Client");
        object.setClient((Client) client);
        object.setObjectType(objectTypeRepository.getById(objectPost.getObjectTypeCode()));
        return objectMapper.map(objectRepository.save(object));
    }

    @Override
    public ObjectView getPatchedObject(String token, Long objectId, ObjectPatch objectPatch) {
        checkModifyPermission(token);
        Object object = objectRepository.getById(objectId);
        objectMapper.map(objectPatch, object);
        return objectMapper.map(objectRepository.save(object));
    }

    @Override
    public List<ObjectView> getObjects(String token) {
        User user = authenticationService.getUserFromToken(token);
        List<Object> objects = null;
        if (user instanceof Client)
            objects = ((Client) user).getObjects();
        if (user instanceof Manager)
            objects = objectRepository.findAll();
        if (objects == null)
            throw new ForbiddenAccessException(Manager.class, Client.class);
        return objects.stream().map(objectMapper::map).collect(Collectors.toList());
    }

    @Override
    public void deleteObject(String token, Long objectId) {
        checkModifyPermission(token);
        objectRepository.delete(objectRepository.getById(objectId));
    }

    private void checkModifyPermission(String token) {
        User user = authenticationService.getUserFromToken(token);
        if (!(user instanceof Manager))
            throw new ForbiddenAccessException(Manager.class);
    }

}

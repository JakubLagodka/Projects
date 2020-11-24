package pl.polsl.hotel.services;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.exceptions.CodeAlreadyUsedException;
import pl.polsl.hotel.exceptions.ForbiddenAccessException;
import pl.polsl.hotel.models.Client;
import pl.polsl.hotel.models.Manager;
import pl.polsl.hotel.models.ObjectType;
import pl.polsl.hotel.models.User;
import pl.polsl.hotel.repositories.ObjectTypeRepository;

import java.util.List;

@Component
public class ObjectTypeService implements StartUpFiller {

    private final ObjectTypeRepository objectTypeRepository;
    private final AuthenticationTokenService authenticationTokenService;

    public ObjectTypeService(ObjectTypeRepository objectTypeRepository, AuthenticationTokenService authenticationTokenService) {
        this.objectTypeRepository = objectTypeRepository;
        this.authenticationTokenService = authenticationTokenService;
    }


    public ObjectType createObjectType(String token, ObjectType objectType) {
        validateIfUserCanModify(token);
        if (objectTypeRepository.existsById(objectType.getCode()))
            throw new CodeAlreadyUsedException(objectType.getCode());
        return objectTypeRepository.save(objectType);
    }


    public ObjectType getPatchedObjectType(String token, String objectTypeCode) {
        validateIfUserCanModify(token);
        ObjectType objectType = objectTypeRepository.getById(objectTypeCode);
        objectTypeRepository.save(objectType);
        return objectType;
    }


    public List<ObjectType> getObjectsTypes(String token) {
        User currentUser = authenticationTokenService.getUserFromToken(token);
        if (!(currentUser instanceof Manager || currentUser instanceof Client))
            throw new ForbiddenAccessException(Manager.class, Client.class);
        List<ObjectType> objectTypes = objectTypeRepository.findAll();
        return objectTypes;
    }

    private void validateIfUserCanModify(String token) {
        User user = authenticationTokenService.getUserFromToken(token);
        if (!(user instanceof Manager))
            throw new ForbiddenAccessException(Manager.class);
    }

    @Override
    public void createInitialData() throws RuntimeException {
        ObjectType programming = new ObjectType();
        programming.setCode("PRG");
        programming.setName("Programing");
        objectTypeRepository.save(programming);

        ObjectType management = new ObjectType();
        management.setCode("MAN");
        management.setName("Management");
        objectTypeRepository.save(management);
    }

}

package pl.polsl.hotel.services;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.exceptions.CodeAlreadyUsedException;
import pl.polsl.hotel.exceptions.ForbiddenAccessException;
import pl.polsl.hotel.mappers.CodeNameMapper;
import pl.polsl.hotel.models.Client;
import pl.polsl.hotel.models.Manager;
import pl.polsl.hotel.models.ObjectType;
import pl.polsl.hotel.models.User;
import pl.polsl.hotel.repositories.ObjectTypeRepository;
import pl.polsl.hotel.views.CodeNamePatch;
import pl.polsl.hotel.views.CodeNamePost;
import pl.polsl.hotel.views.CodeNameView;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ObjectTypeService implements StartUpFiller {

    private final ObjectTypeRepository objectTypeRepository;
    private final AuthenticationService authenticationService;
    private final CodeNameMapper codeNameMapper;

    public ObjectTypeService(ObjectTypeRepository objectTypeRepository, AuthenticationService authenticationService, CodeNameMapper codeNameMapper) {
        this.objectTypeRepository = objectTypeRepository;
        this.authenticationService = authenticationService;
        this.codeNameMapper = codeNameMapper;
    }


    public CodeNameView createObjectType(String token, CodeNamePost codeNamePost) {
        validateIfUserCanModify(token);
        if (objectTypeRepository.existsById(codeNamePost.getCode()))
            throw new CodeAlreadyUsedException(codeNamePost.getCode());
        ObjectType objectType = new ObjectType();
        codeNameMapper.map(codeNamePost, objectType);
        return codeNameMapper.map(objectTypeRepository.save(objectType));
    }


    public CodeNameView getPatchedObjectType(String token, String objectTypeCode, CodeNamePatch codeNamePatch) {
        validateIfUserCanModify(token);
        ObjectType objectType = objectTypeRepository.getById(objectTypeCode);
        codeNameMapper.map(codeNamePatch, objectType);
        return codeNameMapper.map(objectTypeRepository.save(objectType));
    }


    public List<CodeNameView> getObjectsTypes(String token) {
        User currentUser = authenticationService.getUserFromToken(token);
        if (!(currentUser instanceof Manager || currentUser instanceof Client))
            throw new ForbiddenAccessException(Manager.class, Client.class);
        List<ObjectType> objectTypes = objectTypeRepository.findAll();
        return objectTypes.stream().map(codeNameMapper::map).collect(Collectors.toList());
    }

    private void validateIfUserCanModify(String token) {
        User user = authenticationService.getUserFromToken(token);
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

package pl.polsl.hotel.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotel.models.ObjectType;
import pl.polsl.hotel.services.ObjectTypeService;

import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping(value = "/object_type")
public class ObjectTypeController {

    private final ObjectTypeService objectTypeService;

    public ObjectTypeController(ObjectTypeService objectTypeService) {
        this.objectTypeService = objectTypeService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ObjectType createObjectType(@ApiIgnore @RequestHeader(value = "Authorization") String token,
                                       @RequestBody ObjectType objectType) {
        return objectTypeService.createObjectType(token, objectType);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ObjectType> getObjectTypes(@ApiIgnore @RequestHeader(value = "Authorization") String token) {
        return objectTypeService.getObjectsTypes(token);
    }

    @PatchMapping(value = "/{activityTypeCode}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ObjectType updateObjectType(@ApiIgnore @RequestHeader(value = "Authorization") String token,
                                         @PathVariable String activityTypeCode) {
        return objectTypeService.getPatchedObjectType(token, activityTypeCode);
    }

}

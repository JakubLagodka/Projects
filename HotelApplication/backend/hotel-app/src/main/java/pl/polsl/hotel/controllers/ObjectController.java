package pl.polsl.hotel.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotel.services.ObjectService;

import springfox.documentation.annotations.ApiIgnore;

import pl.polsl.hotel.models.Object;

@RestController
@RequestMapping(value = "/object")
public class ObjectController {

    private ObjectService objectService;

    public ObjectController(ObjectService objectService) {
        this.objectService = objectService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object createObject(@ApiIgnore @RequestHeader(value = "Authorization") String token,
                                   @RequestBody Object objectPost) {
        return objectService.createObject(token, objectPost);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Object> getObjects(@ApiIgnore @RequestHeader(value = "Authorization") String token) {
        return objectService.getObjects(token);
    }

    @PatchMapping(value = "/{objectId}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Object updateObject(@ApiIgnore @RequestHeader(value = "Authorization") String token,
                                   @PathVariable Long objectId,
                                   @RequestBody Object objectPatch) {
        return objectService.getPatchedObject(token, objectId);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{objectId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteObject(@ApiIgnore @RequestHeader(value = "Authorization") String token,
                             @PathVariable Long objectId) {
        objectService.deleteObject(token, objectId);
    }

}

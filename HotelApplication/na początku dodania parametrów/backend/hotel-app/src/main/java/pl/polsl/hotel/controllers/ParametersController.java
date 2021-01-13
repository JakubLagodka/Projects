package pl.polsl.hotel.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotel.models.Parameters;

import pl.polsl.hotel.services.ParametersService;

import java.util.Optional;

public class ParametersController {
    private final ParametersService parametersService;

    public ParametersController(ParametersService parametersService) {
        this.parametersService = parametersService;
    }

    @GetMapping
    public Optional<Parameters> getByParameterId(@RequestParam Long index){
        return parametersService.findById(index);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Parameters addParameter(@RequestBody Parameters parameters)  {

        return parametersService.save(parameters);
    }

    @PatchMapping(value = "/{id}/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Parameters updateParameter(@PathVariable Long id, @RequestBody Parameters reservation) {
        return parametersService.updateParameters(id, reservation);
    }

    @DeleteMapping
    public void deleteParameters(@RequestParam Long id){
        parametersService.deleteById(id);

    }
}

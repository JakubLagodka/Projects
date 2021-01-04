package pl.polsl.hotel.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.polsl.hotel.models.Parameter;
import pl.polsl.hotel.services.ParameterService;

import java.util.Optional;
@RestController
@RequestMapping(value = "/parameter")
public class ParameterController {
    private final ParameterService parameterService;

    public ParameterController(ParameterService parameterService) {
        this.parameterService = parameterService;
    }

    @GetMapping("/all")
    public Iterable<Parameter> getAll(){
        return parameterService.findAll();
    }

    @GetMapping
    public Optional<Parameter> getByParameterId(@RequestParam Long index){
        return parameterService.findById(index);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Parameter addParameter(@RequestBody Parameter parameter)  {

        return parameterService.save(parameter);
    }

    @PatchMapping(value = "/{id}/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Parameter updateParameter(@PathVariable Long id, @RequestBody Parameter parameter) {
        return parameterService.updateParameters(id, parameter);
    }

    @DeleteMapping("/delete")
    public void deleteParameter(@RequestParam Long id){
        parameterService.deleteById(id);


    }
}

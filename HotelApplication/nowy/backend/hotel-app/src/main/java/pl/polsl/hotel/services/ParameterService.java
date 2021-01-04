package pl.polsl.hotel.services;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.models.*;
import pl.polsl.hotel.repositories.ParameterRepository;

import java.util.Optional;
@Component
public class ParameterService implements StartUpFiller{
    private final ParameterRepository parameterRepository;

    public ParameterService(ParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    public Optional<Parameter> findById(Long id) {
        return parameterRepository.findById(id);
    }

    public Parameter updateParameter(Long id, Parameter parameter) {

        parameterRepository.deleteById(id);

        return parameterRepository.save(parameter);
    }

    public Parameter save(Parameter parameter) {
        return parameterRepository.save(parameter);
    }

    public void deleteById(Long id) {
        parameterRepository.delete(parameterRepository.getById(id));
    }

    public Iterable<Parameter> findAll() {
        return parameterRepository.findAll();
    }

    public void createInitialData() throws RuntimeException
    {
        if(parameterRepository.findAll().isEmpty())
        {
            Parameter numberOfBeds = new Parameter();
            numberOfBeds.setParameterName("numberOfBeds");
            numberOfBeds.setParameterType("number");
            numberOfBeds.setModifiable(false);
            parameterRepository.save(numberOfBeds);

            Parameter numberOfRoomsAvailable = new Parameter();
            numberOfRoomsAvailable.setParameterName("numberOfRoomsAvailable");
            numberOfRoomsAvailable.setParameterType("number");
            numberOfRoomsAvailable.setModifiable(false);
            parameterRepository.save(numberOfRoomsAvailable);

            Parameter checkInTime = new Parameter();
            checkInTime.setParameterName("checkInTime");
            checkInTime.setParameterType("number");
            checkInTime.setModifiable(false);
            parameterRepository.save(checkInTime);

            Parameter CheckOutTime = new Parameter();
            CheckOutTime.setParameterName("CheckOutTime");
            CheckOutTime.setParameterType("number");
            CheckOutTime.setModifiable(false);
            parameterRepository.save(CheckOutTime);
        }



    }
}

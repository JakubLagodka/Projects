package pl.polsl.hotel.services;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.polsl.hotel.models.*;
import pl.polsl.hotel.repositories.ParameterRepository;
import pl.polsl.hotel.repositories.RoomTypeRepository;

import java.util.Optional;
@Component
public class ParameterService implements StartUpFiller{
    private final ParameterRepository parameterRepository;
    private final RoomTypeRepository roomTypeRepository;

    public ParameterService(ParameterRepository parameterRepository, RoomTypeRepository roomTypeRepository) {
        this.parameterRepository = parameterRepository;
        this.roomTypeRepository = roomTypeRepository;
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

            roomTypeRepository.addTableInt();

            Parameter numberOfRoomsAvailable = new Parameter();
            numberOfRoomsAvailable.setParameterName("numberOfRoomsAvailable");
            numberOfRoomsAvailable.setParameterType("number");
            numberOfRoomsAvailable.setModifiable(false);
            parameterRepository.save(numberOfRoomsAvailable);

            roomTypeRepository.addTableInt2();

            Parameter checkInTime = new Parameter();
            checkInTime.setParameterName("checkInTime");
            checkInTime.setParameterType("number");
            checkInTime.setModifiable(false);
            parameterRepository.save(checkInTime);

            roomTypeRepository.addTableInt3();

            Parameter CheckOutTime = new Parameter();
            CheckOutTime.setParameterName("CheckOutTime");
            CheckOutTime.setParameterType("number");
            CheckOutTime.setModifiable(false);
            parameterRepository.save(CheckOutTime);

            roomTypeRepository.addTableInt4();


        }



    }
}

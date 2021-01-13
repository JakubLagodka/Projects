package pl.polsl.hotel.services;

import org.springframework.stereotype.Component;
import pl.polsl.hotel.models.Parameters;
import pl.polsl.hotel.repositories.ParametersRepository;

import java.util.Optional;

@Component
public class ParametersService {
    private final ParametersRepository parametersRepository;

    public ParametersService(ParametersRepository parametersRepository) {
        this.parametersRepository = parametersRepository;
    }

    public Optional<Parameters> findById(Long id) {
        return parametersRepository.findById(id);
    }

    public Parameters updateParameters(Long id, Parameters parameters) {

        parametersRepository.deleteById(id);

        return parametersRepository.save(parameters);
    }

    public Parameters save(Parameters parameters) {
        return parametersRepository.save(parameters);
    }

    public void deleteById(Long id) {
        parametersRepository.deleteById(id);
    }
}

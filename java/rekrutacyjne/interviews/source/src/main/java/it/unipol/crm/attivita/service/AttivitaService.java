package it.unipol.crm.attivita.service;

import it.unipol.crm.attivita.persistence.model.Attivita;
import it.unipol.crm.attivita.persistence.entity.attivita.UplCrmAttivita;
import it.unipol.crm.attivita.persistence.entity.attivita.UplCrmAttivitaRepository;
import it.unipol.crm.attivita.persistence.exceptions.NuovaAttivitaValidationException;
import it.unipol.crm.attivita.persistence.model.NuovaAttivita;
import it.unipol.crm.attivita.persistence.service.UplCrmAttivitaPersistenceService;
import it.unipol.crm.attivita.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
public class AttivitaService {

    @Autowired
    private UplCrmAttivitaRepository repository;

    @Autowired
    private UplCrmAttivitaPersistenceService service;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserUtil userUtil;

    @Transactional
    public Optional<Attivita> getAttivita(BigInteger attivitaId) {

        Optional<UplCrmAttivita> attivita = repository.findById(attivitaId);

        return attivita.map(uplCrmAttivita -> modelMapper.map(uplCrmAttivita, Attivita.class));
    }

    public List<Attivita> addAttivita(NuovaAttivita request, String userName, String xUnipolApplication, String tokenValue) throws NuovaAttivitaValidationException {

        List<Attivita> attivitaInserted = new ArrayList<>();

        if (request == null) {
            return attivitaInserted;
        }

        // all the validation and business logic is on persistence library side
        final List<UplCrmAttivita> inserted = service.insertNuovaAttivita(request,
                userUtil.calculateUpdateUser(userName, xUnipolApplication),
                tokenValue,
                "attivita");

        for(UplCrmAttivita att : inserted){
            attivitaInserted.add(modelMapper.map(att, Attivita.class));
        }

        return attivitaInserted;
    }

    @Transactional
    public Attivita updateAttivita(Attivita request, String userName, String xUnipolApplication) {

        if (request.getId() == null) {
            log.warn("Null attivita id to update.");
            throw new IllegalArgumentException("Null attivita id to update.");
        }
        UplCrmAttivita uplCrmRequest = modelMapper.map(request, UplCrmAttivita.class);
        return repository.findById(BigInteger.valueOf(request.getId()))
                .map(old -> updateFields(uplCrmRequest, old))
                .map(toUpdate -> {
                    toUpdate.setLastUpdateUser(userUtil.calculateUpdateUser(userName, xUnipolApplication));
                    toUpdate.setLastUpdateDt(new Timestamp(System.currentTimeMillis()));
                    return toUpdate;
                })
                .map(repository::save)
                .map(updated -> modelMapper.map(updated, Attivita.class))
                .orElseThrow();
    }

    @Transactional
    public Attivita deleteAttivita(BigInteger attivitaId) {

        final Optional<UplCrmAttivita> optional = repository.findById(attivitaId);

        if (optional.isPresent()) {
            final UplCrmAttivita value = optional.get();
            repository.delete(value);
            return modelMapper.map(value, Attivita.class);
        } else {
            throw new NoSuchElementException("Attivita with given id doesn't exist!");
        }
    }

    protected <T> T updateFields(T source, T destination) {
        modelMapper.map(source, destination);
        return destination;
    }
}

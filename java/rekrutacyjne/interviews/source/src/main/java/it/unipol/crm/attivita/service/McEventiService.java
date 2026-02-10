package it.unipol.crm.attivita.service;

import it.unipol.crm.attivita.model.McEventi;
import it.unipol.crm.attivita.persistence.entity.mceventi.UplCrmMcEventi;
import it.unipol.crm.attivita.persistence.entity.mceventi.UplCrmMcEventiRepository;
import it.unipol.crm.attivita.persistence.service.UplCrmMcEventiPersistenceService;
import it.unipol.crm.attivita.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
public class McEventiService {

    @Autowired
    UplCrmMcEventiRepository repository;

    @Autowired
    UplCrmMcEventiPersistenceService persistenceService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserUtil userUtil;

    @Transactional
    public McEventi insertMcEventi(McEventi mcEventi) {

        if (mcEventi.getMcEventiId() != null) {
            log.error("McEventi id field should be null.");
            throw new IllegalArgumentException("McEventi id field should be null.");
        }

        final UplCrmMcEventi objToInsert = modelMapper.map(mcEventi, UplCrmMcEventi.class);
        log.info("received object: " + objToInsert);

        final UplCrmMcEventi saved = persistenceService.insertMcEventi(objToInsert);

        return modelMapper.map(saved, McEventi.class);
    }

    @Transactional
    public McEventi updateMcEventi(McEventi mcEventi, String userName, String xUnipolApplication) {

        if (mcEventi.getMcEventiId() == null) {
            log.error("Null McEventi id to update.");
            throw new IllegalArgumentException("Null McEventi id to update.");
        }

        final UplCrmMcEventi objToUpdate = modelMapper.map(mcEventi, UplCrmMcEventi.class);
        log.info("received object: " + objToUpdate);

        final Optional<UplCrmMcEventi> existingObj = repository.findById(objToUpdate.getMcEventiId());
        log.info("existing object: " + existingObj);

        existingObj.ifPresentOrElse(
                x -> {
                    modelMapper.map(objToUpdate, x);
                    x.setLastUpdateUser(userUtil.calculateUpdateUser(userName, xUnipolApplication));
                    x.setLastUpdateDt(new Timestamp(System.currentTimeMillis()));
                    log.info("existing object after applying not null values from received object: " + x);
                    repository.save(x);
                },
                () -> { throw new NoSuchElementException("McEventi with given id not found."); }
        );

        if (existingObj.isPresent()) {
            return modelMapper.map(existingObj.get(), McEventi.class);
        } else {
            throw new NoSuchElementException("McEventi with given id not found.");
        }
    }

    @Transactional
    public void deleteMcEventi(McEventi mcEventi) {

        repository.findById(mcEventi.getMcEventiId())
                .ifPresent(repository::delete);
    }
}

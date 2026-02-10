package it.unipol.crm.anagrafica.gestione.service.entities;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmRecapiti;
import it.unipol.crm.anagrafica.gestione.repository.UplCrmRecapitiRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@Component @Getter
@AllArgsConstructor
public class UplCrmRecapitiPersistenceService {
    @Autowired
    private UplCrmRecapitiRepository repository;

  
    public UplCrmRecapiti insertRecapiti(UplCrmRecapiti recapiti){

        var now = new Timestamp(System.currentTimeMillis());
        if (recapiti.getDataInserimento() == null) {
            recapiti.setDataInserimento(now);
        }

        if (recapiti.getUtenteInserimento() == null || recapiti.getDataInizio() == null ||
                recapiti.getIdSoggetto() == null || recapiti.getCodicetiporecapito() == null ||
        recapiti.getRecapito() == null || recapiti.getCodiceusorecapito() == null) {
            throw new IllegalArgumentException("One of the following not-null fields in insert object is null: " +
                    "recapiti = " + recapiti.getIdRecapito());
        }

        repository.save(recapiti);

        log.debug("Inserted new recapiti, id = {}", recapiti.getIdRecapito());

        return recapiti;
    }
}

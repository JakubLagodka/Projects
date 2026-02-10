package it.unipol.crm.anagrafica.gestione.service.entities;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmNuclei;
import it.unipol.crm.anagrafica.gestione.repository.UplCrmNucleiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@Component
public class UplCrmNucleiPersistenceService {
    @Autowired
    private UplCrmNucleiRepository repository;

  
    public UplCrmNuclei insertNuclei(UplCrmNuclei nuclei){

        var now = new Timestamp(System.currentTimeMillis());
        if (nuclei.getDataInserimento() == null) {
            nuclei.setDataInserimento(now);
        }
        nuclei.setDataAggiornamento(now);

        if (nuclei.getUtenteInserimento() == null || nuclei.getDataInizio() == null ||
                nuclei.getIdSoggettocapogruppo() == null || nuclei.getCodicetiponucleo() == null) {
            throw new IllegalArgumentException("One of the following not-null fields in insert object is null: " +
                    "nuclei = " + nuclei.getIdNucleo());
        }

        repository.save(nuclei);

        log.debug("Inserted new nuclei, id = {}", nuclei.getIdNucleo());

        return nuclei;
    }
}

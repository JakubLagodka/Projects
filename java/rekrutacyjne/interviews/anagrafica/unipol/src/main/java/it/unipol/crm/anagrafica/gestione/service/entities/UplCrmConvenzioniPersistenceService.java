package it.unipol.crm.anagrafica.gestione.service.entities;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmConvenzioni;
import it.unipol.crm.anagrafica.gestione.repository.UplCrmConvenzioniRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@Component
public class UplCrmConvenzioniPersistenceService {
    @Autowired
    private UplCrmConvenzioniRepository repository;

  
    public UplCrmConvenzioni insertConvenzioni(UplCrmConvenzioni convenzioni){

        var now = new Timestamp(System.currentTimeMillis());
        if (convenzioni.getDataInserimento() == null) {
            convenzioni.setDataInserimento(now);
        }
        convenzioni.setDataAggiornamento(now);

        if (convenzioni.getUtenteInserimento() == null) {
            throw new IllegalArgumentException("One of the following not-null fields in insert object is null: " +
                    "anomaleAnagrafiche = " + convenzioni.getIdConvenzione());
        }
        repository.save(convenzioni);

        log.debug("Inserted new convenzioni, id = {}", convenzioni.getIdConvenzione());

        return convenzioni;
    }
}

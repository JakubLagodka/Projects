package it.unipol.crm.anagrafica.gestione.service.entities;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmOptout;
import it.unipol.crm.anagrafica.gestione.repository.UplCrmOptoutRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@Component
public class UplCrmOptoutPersistenceService {
    @Autowired
    private UplCrmOptoutRepository repository;

  
    public UplCrmOptout insertOptout(UplCrmOptout optout){

        var now = new Timestamp(System.currentTimeMillis());
        if (optout.getDataInserimento() == null) {
            optout.setDataInserimento(now);
        }
        optout.setDataAggiornamento(now);

        if (optout.getUtenteInserimento() == null || optout.getDataInizio() == null ||
                optout.getIdSoggetto() == null || optout.getCodicetipooptout() == null) {
            throw new IllegalArgumentException("One of the following not-null fields in insert object is null: " +
                    "optout = " + optout.getIdOptout());
        }

        repository.save(optout);

        log.debug("Inserted new optout, id = {}", optout.getIdOptout());

        return optout;
    }
}

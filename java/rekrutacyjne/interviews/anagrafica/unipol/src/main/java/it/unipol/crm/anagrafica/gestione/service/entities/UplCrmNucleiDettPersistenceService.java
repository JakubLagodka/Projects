package it.unipol.crm.anagrafica.gestione.service.entities;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmNucleiDett;
import it.unipol.crm.anagrafica.gestione.repository.UplCrmNucleiDettRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@Component
public class UplCrmNucleiDettPersistenceService {
    @Autowired
    private UplCrmNucleiDettRepository repository;

  
    public UplCrmNucleiDett insertNucleiDett(UplCrmNucleiDett nucleiDett){

        var now = new Timestamp(System.currentTimeMillis());
        if (nucleiDett.getDataInserimento() == null) {
            nucleiDett.setDataInserimento(now);
        }
        nucleiDett.setDataAggiornamento(now);

        if (nucleiDett.getUtenteInserimento() == null || nucleiDett.getDataInizio() == null ||
                nucleiDett.getIdSoggetto() == null || nucleiDett.getIdnucleo() == null) {
            throw new IllegalArgumentException("One of the following not-null fields in insert object is null: " +
                    "nucleiDett = " + nucleiDett.getIdnucleo());
        }

        repository.save(nucleiDett);

        log.debug("Inserted new nucleiDett, id = {}", nucleiDett.getIdnucleo());

        return nucleiDett;
    }
}

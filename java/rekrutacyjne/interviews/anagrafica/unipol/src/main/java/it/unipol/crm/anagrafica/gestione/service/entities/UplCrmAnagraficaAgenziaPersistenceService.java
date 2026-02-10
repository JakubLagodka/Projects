package it.unipol.crm.anagrafica.gestione.service.entities;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmAnagraficaAgenzia;
import it.unipol.crm.anagrafica.gestione.repository.UplCrmAnagraficaAgenziaRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@Component
@Getter
public class UplCrmAnagraficaAgenziaPersistenceService {
    @Autowired
    private UplCrmAnagraficaAgenziaRepository repository;

    public UplCrmAnagraficaAgenzia insertAnagraficaAgenzia(UplCrmAnagraficaAgenzia anagraficaAgenzia) {
        var nowTimestamp = new Timestamp(System.currentTimeMillis());

        if (anagraficaAgenzia.getDataInserimento() == null) {
            anagraficaAgenzia.setDataInserimento(nowTimestamp);
        }
        anagraficaAgenzia.setDataAggiornamento(nowTimestamp);

        if (anagraficaAgenzia.getIdSoggetto() == null) {
            throw new IllegalArgumentException("One of the following not-null fields in insert object is null: " +
                    "anagraficaAgenzia = " + anagraficaAgenzia.getIdAnagraficaAgenzia());
        }
        repository.save(anagraficaAgenzia);

        log.debug("Inserted new anagraficaAgenzia");

        return anagraficaAgenzia;
    }

}

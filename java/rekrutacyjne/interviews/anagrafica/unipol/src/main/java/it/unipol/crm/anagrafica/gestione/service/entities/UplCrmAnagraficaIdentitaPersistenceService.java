package it.unipol.crm.anagrafica.gestione.service.entities;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmAnagraficaIdentita;
import it.unipol.crm.anagrafica.gestione.repository.UplCrmAnagraficaIdentitaRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@Component @Getter
public class UplCrmAnagraficaIdentitaPersistenceService {
    @Autowired
    private UplCrmAnagraficaIdentitaRepository repository;

  
    public UplCrmAnagraficaIdentita insertAnagraficaIdentita(UplCrmAnagraficaIdentita anagraficaIdentita){

        var now = new Timestamp(System.currentTimeMillis());
        if (anagraficaIdentita.getDataInserimento() == null) {
            anagraficaIdentita.setDataInserimento(now);
        }
        anagraficaIdentita.setDataAggiornamento(now);

        if (anagraficaIdentita.getCodicetipo() == null || anagraficaIdentita.getIdSoggetto() == null ||
                anagraficaIdentita.getUtenteInserimento() == null)  {
            throw new IllegalArgumentException("One of the following not-null fields in insert object is null: " +
                    "anagraficaIdentita = " + anagraficaIdentita.getIdSoggetto());
        }

        repository.save(anagraficaIdentita);

        log.debug("Inserted new anagraficaIdentita, id = {}", anagraficaIdentita.getIdSoggetto());

        return anagraficaIdentita;
    }
}

package it.unipol.crm.anagrafica.gestione.service.entities;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmAnagrafichePf;
import it.unipol.crm.anagrafica.gestione.repository.UplCrmAnagrafichePfRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@Component
@AllArgsConstructor
@Getter
public class UplCrmAnagrafichePfPersistenceService {
    @Autowired
    private UplCrmAnagrafichePfRepository repository;

  
    public UplCrmAnagrafichePf insertAnagrafichePf(UplCrmAnagrafichePf anagrafichePf){

        var now = new Timestamp(System.currentTimeMillis());
        if (anagrafichePf.getDataInserimento() == null) {
            anagrafichePf.setDataInserimento(now);
        }
        anagrafichePf.setDataAggiornamento(now);

        if (anagrafichePf.getCognome() == null ||
                anagrafichePf.getUtenteInserimento() == null ||   anagrafichePf.getDataInserimento() == null) {
            throw new IllegalArgumentException("One of the following not-null fields in insert object is null: " +
                    "anagrafichePf = " + anagrafichePf.getIdSoggetto());
        }
        repository.save(anagrafichePf);

        log.debug("Inserted new anagrafichePf, id = {}", anagrafichePf.getIdSoggetto());

        return anagrafichePf;
    }
}

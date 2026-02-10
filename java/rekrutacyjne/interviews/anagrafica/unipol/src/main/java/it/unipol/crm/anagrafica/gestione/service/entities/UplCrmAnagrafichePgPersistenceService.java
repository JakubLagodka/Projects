package it.unipol.crm.anagrafica.gestione.service.entities;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmAnagrafichePg;
import it.unipol.crm.anagrafica.gestione.repository.UplCrmAnagrafichePgRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@Component @Getter
public class UplCrmAnagrafichePgPersistenceService {
    @Autowired
    private UplCrmAnagrafichePgRepository repository;

  
    public UplCrmAnagrafichePg insertAnagrafichePg(UplCrmAnagrafichePg anagrafichePg){

        var now = new Timestamp(System.currentTimeMillis());
        if (anagrafichePg.getDataInserimento() == null) {
            anagrafichePg.setDataInserimento(now);
            anagrafichePg.setUtenteInserimento("CRMSETUP");
        }

        anagrafichePg.setDataAggiornamento(now);

        if (anagrafichePg.getCodiceramo() == null || anagrafichePg.getCodicesettore() == null ||
        anagrafichePg.getDatacostituzione() == null || anagrafichePg.getCodicemercatopreferenziale() == null ||
                anagrafichePg.getUtenteInserimento() == null ||   anagrafichePg.getDataInserimento() == null) {
            throw new IllegalArgumentException("One of the following not-null fields in insert object is null: " +
                    "anagrafichePg = " + anagrafichePg.getIdSoggetto());
        }
        repository.save(anagrafichePg);

        log.debug("Inserted new anagrafichePg, id = {}", anagrafichePg.getIdSoggetto());

        return anagrafichePg;
    }
}

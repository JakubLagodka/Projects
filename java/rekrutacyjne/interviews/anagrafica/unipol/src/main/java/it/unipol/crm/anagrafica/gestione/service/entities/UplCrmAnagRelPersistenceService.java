package it.unipol.crm.anagrafica.gestione.service.entities;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmAnagRel;
import it.unipol.crm.anagrafica.gestione.repository.UplCrmAnagRelRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@Component @Getter
public class UplCrmAnagRelPersistenceService {
    @Autowired
    private UplCrmAnagRelRepository repository;

  
    public UplCrmAnagRel insertAnagRel(UplCrmAnagRel anagRel){

        var now = new Timestamp(System.currentTimeMillis());
        if (anagRel.getDataInserimento() == null) {
            anagRel.setDataInserimento(now);
        }
        anagRel.setDataAggiornamento(now);

        if (anagRel.getCodicetiporelazione() == null ||  anagRel.getContIdarrivo() == null ||
                anagRel.getContIdpartenza() == null || anagRel.getDataInizio() == null ||
                anagRel.getUtenteInserimento() == null) {
            throw new IllegalArgumentException("One of the following not-null fields in insert object is null: " +
                    "anagRel = " + anagRel.getDescrizione());
        }

        repository.save(anagRel);

        log.debug("Inserted new anagRel, id = {}", anagRel.getIdAnagRel());

        return anagRel;
    }
}

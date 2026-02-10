package it.unipol.crm.anagrafica.gestione.service.entities;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmDatiSocioeconomiciPfErrori;
import it.unipol.crm.anagrafica.gestione.repository.UplCrmDatiSocioeconomiciPfErroriRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@Component @Getter
public class UplCrmDatiSocioeconomiciPfErroriPersistenceService {
    @Autowired
    private UplCrmDatiSocioeconomiciPfErroriRepository repository;

  
    public UplCrmDatiSocioeconomiciPfErrori insertDatiSocioeconomiciPfErrori(UplCrmDatiSocioeconomiciPfErrori datiSocioeconomiciPfErrori){

        var now = new Timestamp(System.currentTimeMillis());
        if (datiSocioeconomiciPfErrori.getDataInserimento() == null) {
            datiSocioeconomiciPfErrori.setDataInserimento(now);
        }
        datiSocioeconomiciPfErrori.setDataAggiornamento(now);
        if (datiSocioeconomiciPfErrori.getIdSoggetto() == null ||
                datiSocioeconomiciPfErrori.getDataAggiornamento() == null ||
                datiSocioeconomiciPfErrori.getDataInserimento() == null || datiSocioeconomiciPfErrori.getUtenteInserimento() == null) {
            throw new IllegalArgumentException("One of the following not-null fields in insert object is null: " +
                    "datiSocioeconomiciPfErrori = " + datiSocioeconomiciPfErrori.getIdDatiSocioeconomiciPfErrori());
        }
        repository.save(datiSocioeconomiciPfErrori);

        log.debug("Inserted new datiSocioeconomiciPfErrori, id = {}", datiSocioeconomiciPfErrori.getIdDatiSocioeconomiciPfErrori());

        return datiSocioeconomiciPfErrori;
    }
}

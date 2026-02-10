package it.unipol.crm.anagrafica.gestione.service.entities;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmDatiSocioeconomiciPf;
import it.unipol.crm.anagrafica.gestione.repository.UplCrmDatiSocioeconomiciPfRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@Component @Getter
public class UplCrmDatiSocioeconomiciPfPersistenceService {
    @Autowired
    private UplCrmDatiSocioeconomiciPfRepository repository;

  
    public UplCrmDatiSocioeconomiciPf insertDatiSocioeconomiciPf(UplCrmDatiSocioeconomiciPf datiSocioeconomiciPf){

        var now = new Timestamp(System.currentTimeMillis());
        if (datiSocioeconomiciPf.getDataInserimento() == null) {
            datiSocioeconomiciPf.setDataInserimento(now);
        }

        if (datiSocioeconomiciPf.getIdSoggetto() == null ||
              datiSocioeconomiciPf.getDataAggiornamento() == null ||
                datiSocioeconomiciPf.getDataInserimento() == null || datiSocioeconomiciPf.getUtenteInserimento() == null) {
            throw new IllegalArgumentException("One of the following not-null fields in insert object is null: " +
                    "datiSocioeconomiciPfErrori = " + datiSocioeconomiciPf.getIdDatiSocioeconomiciPf());
        }
        repository.save(datiSocioeconomiciPf);

        log.debug("Inserted new datiSocioeconomiciPfErrori, id = {}", datiSocioeconomiciPf.getIdDatiSocioeconomiciPf());

        return datiSocioeconomiciPf;
    }
}

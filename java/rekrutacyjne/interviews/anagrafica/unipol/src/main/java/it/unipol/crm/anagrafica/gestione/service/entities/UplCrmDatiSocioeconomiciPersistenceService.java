package it.unipol.crm.anagrafica.gestione.service.entities;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmDatiSocioeconomici;
import it.unipol.crm.anagrafica.gestione.repository.UplCrmDatiSocioeconomiciRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@Component @Getter
public class UplCrmDatiSocioeconomiciPersistenceService {
    @Autowired
    private UplCrmDatiSocioeconomiciRepository repository;

  
    public UplCrmDatiSocioeconomici insertDatiSocioeconomici(UplCrmDatiSocioeconomici datiSocioeconomici){

        var now = new Timestamp(System.currentTimeMillis());
        if (datiSocioeconomici.getDataInserimento() == null) {
            datiSocioeconomici.setDataInserimento(now);
        }

        if (datiSocioeconomici.getIdSoggetto() == null ||
        datiSocioeconomici.getIdentitariferita() == null || datiSocioeconomici.getDataAggiornamento() == null ||
        datiSocioeconomici.getDataInserimento() == null || datiSocioeconomici.getUtenteInserimento() == null) {
            throw new IllegalArgumentException("One of the following not-null fields in insert object is null: " +
                    "datiSocioeconomiciPfErrori = " + datiSocioeconomici.getIdDatiSocioeconomici());
        }

        repository.save(datiSocioeconomici);

        log.debug("Inserted new datiSocioeconomiciPfErrori, id = {}", datiSocioeconomici.getIdDatiSocioeconomici());

        return datiSocioeconomici;
    }
}

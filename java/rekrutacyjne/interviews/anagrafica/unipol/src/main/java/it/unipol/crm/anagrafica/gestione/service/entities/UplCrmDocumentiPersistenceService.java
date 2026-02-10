package it.unipol.crm.anagrafica.gestione.service.entities;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmDocumenti;
import it.unipol.crm.anagrafica.gestione.repository.UplCrmDocumentiRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@Component @Getter
public class UplCrmDocumentiPersistenceService {
    @Autowired
    private UplCrmDocumentiRepository repository;

  
    public UplCrmDocumenti insertDocumenti(UplCrmDocumenti documenti){

        var now = new Timestamp(System.currentTimeMillis());
        if (documenti.getDataInserimento() == null) {
            documenti.setDataInserimento(now);
        }
        if (documenti.getDataInizio() == null) {
            documenti.setDataInizio(now);
        }
        documenti.setDataAggiornamento(now);

        if (documenti.getCodicetipodocumento() == null || documenti.getIdSoggetto() == null ||
        documenti.getCodicestatodocumento() == null || documenti.getDataInizio() == null ||
        documenti.getDatascadenza() == null || documenti.getUtenteInserimento() == null) {
            throw new IllegalArgumentException("One of the following not-null fields in insert object is null: " +
                    "documenti = " + documenti.getIdDocumento());
        }

        repository.save(documenti);

        log.debug("Inserted new documenti, id = {}", documenti.getIdDocumento());

        return documenti;
    }
}

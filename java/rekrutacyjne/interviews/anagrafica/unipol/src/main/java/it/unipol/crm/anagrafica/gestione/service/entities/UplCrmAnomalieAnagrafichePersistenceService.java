package it.unipol.crm.anagrafica.gestione.service.entities;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmAnomalieAnagrafiche;
import it.unipol.crm.anagrafica.gestione.repository.UplCrmAnomalieAnagraficheRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@Component @Getter
public class UplCrmAnomalieAnagrafichePersistenceService {
    @Autowired
    private UplCrmAnomalieAnagraficheRepository repository;

  
    public UplCrmAnomalieAnagrafiche insertAnomaleAnagrafiche(UplCrmAnomalieAnagrafiche anomaleAnagrafiche){

        var now = new Timestamp(System.currentTimeMillis());
        if (anomaleAnagrafiche.getDataInserimento() == null) {
            anomaleAnagrafiche.setDataInserimento(now);
        }
        anomaleAnagrafiche.setDataAggiornamento(now);

        if (anomaleAnagrafiche.getIdSoggetto() == null || anomaleAnagrafiche.getDataInizio() == null ||
                anomaleAnagrafiche.getUtenteInserimento() == null || anomaleAnagrafiche.getCodicetipoanomalia() == null ||
                anomaleAnagrafiche.getDataAggiornamento() == null || anomaleAnagrafiche.getDataInserimento() == null ) {
            throw new IllegalArgumentException("One of the following not-null fields in insert object is null: " +
                    "anomaleAnagrafiche = " + anomaleAnagrafiche.getIdAnomalia());
        }

        repository.save(anomaleAnagrafiche);

        log.debug("Inserted new anomaleAnagrafiche, id = {}", anomaleAnagrafiche.getIdAnomalia());

        return anomaleAnagrafiche;
    }
}

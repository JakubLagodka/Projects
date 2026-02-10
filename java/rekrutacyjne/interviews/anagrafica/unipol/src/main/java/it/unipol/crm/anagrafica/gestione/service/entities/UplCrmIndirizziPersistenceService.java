package it.unipol.crm.anagrafica.gestione.service.entities;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmIndirizzi;
import it.unipol.crm.anagrafica.gestione.repository.UplCrmIndirizziRepository;
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
public class UplCrmIndirizziPersistenceService {
    @Autowired
    private UplCrmIndirizziRepository repository;

  
    public UplCrmIndirizzi insertIndirizzi(UplCrmIndirizzi indirizzi){

        var now = new Timestamp(System.currentTimeMillis());
        if (indirizzi.getDataInserimento() == null) {
            indirizzi.setDataInserimento(now);
        }
        indirizzi.setDataAggiornamento(now);
        if (indirizzi.getTipoaddress() == null) {
            indirizzi.setTipoaddress("A");
        }
        if (indirizzi.getIdSoggetto() == null || indirizzi.getNazione() == null ||
        indirizzi.getFlagProvenienzaBanca() == null || indirizzi.getSiglaProvincia() == null ||
        indirizzi.getTipoindirizzo() == null || indirizzi.getDataInizio() == null ||
        indirizzi.getUtenteInserimento() == null) {
            throw new IllegalArgumentException("One of the following not-null fields in insert object is null: " +
                    "indirizzi = " + indirizzi.getIdIndirizzo());
        }

        repository.save(indirizzi);

        log.debug("Inserted new indirizzi, id = {}", indirizzi.getIdIndirizzo());

        return indirizzi;
    }
}

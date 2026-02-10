package it.unipol.crm.anagrafica.gestione.service.entities;

import it.unipol.crm.anagrafica.gestione.entity.code.UplCrmAnagrafiche;
import it.unipol.crm.anagrafica.gestione.repository.UplCrmAnagraficheRepository;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Slf4j
@Component @Getter
public class UplCrmAnagrafichePersistenceService {
    @Autowired
    private UplCrmAnagraficheRepository repository;

  
    public UplCrmAnagrafiche insertAnagrafiche(UplCrmAnagrafiche anagrafiche){

        var now = new Timestamp(System.currentTimeMillis());
        if (anagrafiche.getDataInserimento() == null) {
            anagrafiche.setDataInserimento(now);
        }
        anagrafiche.setDataAggiornamento(now);

        if (anagrafiche.getTipondg() == null || anagrafiche.getCodicelinguapreferita() == null ||
                anagrafiche.getDatacreazione() == null || anagrafiche.getCodicesegmentoclientela() == null ||
                anagrafiche.getCodicestatocliente() == null || anagrafiche.getCodicetipoanagrafe() == null ||
                anagrafiche.getCodiceprofessione() == null || anagrafiche.getCodicetiposofferenza() == null ||
        anagrafiche.getDataregistrazione() == null || anagrafiche.getConsensobanca() == null ||
        anagrafiche.getConsensoassic() == null || anagrafiche.getIncagliosofferenza() == null ||
        anagrafiche.getConstpcd() == null || anagrafiche.getCanaletpcd() == null ||
        anagrafiche.getDataregconsensoassicts() == null || anagrafiche.getDatarevocaconsensoassicts() == null ||
        anagrafiche.getDataconsensoassicts() == null || anagrafiche.getDatarifiutoloyaltyprogram() == null ||
        anagrafiche.getUtenteInserimento() == null) {
            throw new IllegalArgumentException("One of the following not-null fields in insert object is null: " +
                    "anagrafiche = " + anagrafiche.getIdSoggetto());
        }

        repository.save(anagrafiche);

        log.debug("Inserted new anagrafiche, id = {}", anagrafiche.getIdSoggetto());

        return anagrafiche;
    }
}

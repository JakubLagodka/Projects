package it.unipol.crm.anagrafica.gestione.service;

import it.unipol.crm.anagrafica.gestione.config.mapper.AnagraficaEntitiesUpdateMapper;
import it.unipol.crm.anagrafica.gestione.entity.code.*;
import it.unipol.crm.anagrafica.gestione.model.UplCrmAnagraficaContainer;
import it.unipol.crm.anagrafica.gestione.service.entities.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@Slf4j
@Component
@Getter
@AllArgsConstructor
public class AnagraficaPersistenceServiceGettingData {
    @Autowired
    private UplCrmAnagraficaAgenziaPersistenceService anagraficaAgenziaPersistenceService;
    @Autowired
    private UplCrmAnagrafichePersistenceService anagrafichePersistenceService;
    @Autowired
    private UplCrmAnagrafichePfPersistenceService anagrafichePfPersistenceService;
    @Autowired
    private UplCrmAnagrafichePgPersistenceService anagrafichePgPersistenceService;
    @Autowired
    private UplCrmAnomalieAnagrafichePersistenceService anomaleAnagrafichePersistenceService;
    @Autowired
    private UplCrmAnagRelPersistenceService anagRelPersistenceService;
    @Autowired
    private UplCrmDatiSocioeconomiciPersistenceService datiSocioeconomiciPersistenceService;
    @Autowired
    private UplCrmDatiSocioeconomiciPfPersistenceService datiSocioeconomiciPfPersistenceService;
    @Autowired
    private UplCrmDatiSocioeconomiciPfErroriPersistenceService datiSocioeconomiciPfErroriPersistenceService;
    @Autowired
    private UplCrmDocumentiPersistenceService documentiPersistenceService;
    @Autowired
    private UplCrmIndirizziPersistenceService indirizziPersistenceService;
    @Autowired
    private UplCrmRecapitiPersistenceService recapitiPersistenceService;
    @Autowired
    private UplCrmAnagraficaIdentitaPersistenceService anagraficaIdentitaPersistenceService;

    @Autowired
    private AnagraficaEntitiesUpdateMapper anagraficaEntitiesUpdateMapper;

    public UplCrmAnagraficaIdentita updateIdentita(UplCrmAnagraficaContainer container) {
        if (container.getUplCrmAnagraficaIdentita() == null) {
            return null;
        }
        var uplCrmAnagraficaIdentita = anagraficaIdentitaPersistenceService.getRepository().findById(container.getUplCrmAnagraficaIdentita().getIdAnagraficaIdentita())
                .orElseThrow(() -> new NoSuchElementException("UplCrmAnagraficaIdentita with id = " + container.getUplCrmAnagraficaIdentita().getIdAnagraficaIdentita() + " is not present in DataBase!"));

        anagraficaEntitiesUpdateMapper.uplCrmAnagraficaIdentitaUpdate(uplCrmAnagraficaIdentita,container.getUplCrmAnagraficaIdentita());
        return uplCrmAnagraficaIdentita;
    }

    public UplCrmRecapiti updateRecapiti(UplCrmAnagraficaContainer container) {
        if (container.getUplCrmRecapiti() == null) {
            return null;
        }
        var uplCrmRecapiti = recapitiPersistenceService.getRepository().findById(container.getUplCrmRecapiti().getIdRecapito())
                .orElseThrow(() -> new NoSuchElementException("UplCrmRecapiti with id = " + container.getUplCrmRecapiti().getIdRecapito() + " is not present in DataBase!"));

        anagraficaEntitiesUpdateMapper.uplCrmRecapitiUpdate(uplCrmRecapiti,container.getUplCrmRecapiti());
        return uplCrmRecapiti;
    }

    public UplCrmIndirizzi updateIndirizzi(UplCrmAnagraficaContainer container) {
        if (container.getUplCrmIndirizzi() == null) {
            return null;
        }
        var uplCrmIndirizzi = indirizziPersistenceService.getRepository().findById(container.getUplCrmIndirizzi().getIdIndirizzo())
                .orElseThrow(() -> new NoSuchElementException("UplCrmIndirizzi with id = " + container.getUplCrmIndirizzi().getIdIndirizzo() + " is not present in DataBase!"));

        anagraficaEntitiesUpdateMapper.uplCrmIndirizziUpdate(uplCrmIndirizzi,container.getUplCrmIndirizzi());
        return uplCrmIndirizzi;
    }

    public UplCrmDocumenti updateDocumenti(UplCrmAnagraficaContainer container) {
        if (container.getUplCrmDocumenti() == null) {
            return null;
        }
        var uplCrmDocumenti = documentiPersistenceService.getRepository().findById(container.getUplCrmDocumenti().getIdDocumento())
                .orElseThrow(() -> new NoSuchElementException("uplCrmDocumenti with id = " + container.getUplCrmDocumenti().getIdDocumento() + " is not present in DataBase!"));

        anagraficaEntitiesUpdateMapper.uplCrmDocumentiUpdate(uplCrmDocumenti,container.getUplCrmDocumenti());
        return uplCrmDocumenti;
    }

    public UplCrmDatiSocioeconomiciPfErrori updateDatiSocioeconomiciPfErrori(UplCrmAnagraficaContainer container) {
        if (container.getUplCrmDatiSocioeconomiciPfErrori() == null) {
            return null;
        }
        var uplCrmDatiSocioeconomiciPfErrori = datiSocioeconomiciPfErroriPersistenceService.getRepository().findById(container.getUplCrmDatiSocioeconomiciPfErrori().getIdDatiSocioeconomiciPfErrori())
                .orElseThrow(() -> new NoSuchElementException("UplCrmDatiSocioeconomiciPfErrori with id = " + container.getUplCrmDatiSocioeconomiciPfErrori().getIdDatiSocioeconomiciPfErrori() + " is not present in DataBase!"));

        anagraficaEntitiesUpdateMapper.uplCrmDatiSocioeconomiciPfErroriUpdate(uplCrmDatiSocioeconomiciPfErrori,container.getUplCrmDatiSocioeconomiciPfErrori());
        return uplCrmDatiSocioeconomiciPfErrori;
    }

    public UplCrmDatiSocioeconomiciPf updateDatiSocioeconomiciPf(UplCrmAnagraficaContainer container) {
        if (container.getUplCrmDatiSocioeconomiciPf() == null) {
            return null;
        }
        var uplCrmDatiSocioeconomiciPf = datiSocioeconomiciPfPersistenceService.getRepository().findById(container.getUplCrmDatiSocioeconomiciPf().getIdDatiSocioeconomiciPf())
                .orElseThrow(() -> new NoSuchElementException("UplCrmDatiSocioeconomiciPf with id = " + container.getUplCrmDatiSocioeconomiciPf().getIdDatiSocioeconomiciPf() + " is not present in DataBase!"));
        anagraficaEntitiesUpdateMapper.uplCrmDatiSocioeconomiciPfUpdate(uplCrmDatiSocioeconomiciPf,container.getUplCrmDatiSocioeconomiciPf());
        return uplCrmDatiSocioeconomiciPf;
    }

    public UplCrmAnomalieAnagrafiche updateAnomaleAnagrafiche(UplCrmAnagraficaContainer container) {
        if (container.getUplCrmAnomaleAnagrafiche() == null) {
            return null;
        }

        var uplCrmAnomalieAnagrafiche = anomaleAnagrafichePersistenceService.getRepository().findById(container.getUplCrmAnomaleAnagrafiche().getIdAnomalia())
                .orElseThrow(() -> new NoSuchElementException("UplCrmAnomaleAnagrafiche with id = " + container.getUplCrmAnomaleAnagrafiche().getIdAnomalia() + " is not present in DataBase!"));
        anagraficaEntitiesUpdateMapper.uplCrmAnomalieAnagraficheUpdate(uplCrmAnomalieAnagrafiche,container.getUplCrmAnomaleAnagrafiche());
        return uplCrmAnomalieAnagrafiche;
    }

    public UplCrmAnagRel updateAnagRel(UplCrmAnagraficaContainer container) {
        if (container.getUplCrmAnagRel() == null) {
            return null;
        }
        var uplCrmAnagRel = anagRelPersistenceService.getRepository().findById(container.getUplCrmAnagRel().getIdAnagRel())
                .orElseThrow(() -> new NoSuchElementException("UplCrmAnagRel with id = " + container.getUplCrmAnagRel().getIdAnagRel() + " is not present in DataBase!"));
        anagraficaEntitiesUpdateMapper.uplCrmAnagRelUpdate(uplCrmAnagRel,container.getUplCrmAnagRel());
        return uplCrmAnagRel;
    }
    public UplCrmAnagrafichePg updateAnagrafichePg(UplCrmAnagraficaContainer container) {
        if (container.getUplCrmAnagrafichePg() == null) {
            return null;
        }
        var uplCrmAnagrafichePg = anagrafichePgPersistenceService.getRepository().findById(container.getUplCrmAnagrafichePg().getIdSoggetto())
                .orElseThrow(() -> new NoSuchElementException("UplCrmAnagrafichePg with id = " + container.getUplCrmAnagrafichePg().getIdSoggetto() + " is not present in DataBase!"));
       anagraficaEntitiesUpdateMapper.uplCrmAnagrafichePgUpdate(uplCrmAnagrafichePg,container.getUplCrmAnagrafichePg());
        return uplCrmAnagrafichePg;
    }

    public UplCrmAnagrafichePf updateAnagrafichePf(UplCrmAnagraficaContainer container) {
        if (container.getUplCrmAnagrafichePf() == null) {
            return null;
        }
        var uplCrmAnagrafichePf = anagrafichePfPersistenceService.getRepository().findById(container.getUplCrmAnagrafichePf().getIdSoggetto())
                .orElseThrow(() -> new NoSuchElementException("UplCrmAnagrafichePf with id = " + container.getUplCrmAnagrafichePf().getIdSoggetto() + " is not present in DataBase!"));
        anagraficaEntitiesUpdateMapper.uplCrmAnagrafichePfUpdate(uplCrmAnagrafichePf,container.getUplCrmAnagrafichePf());
        return uplCrmAnagrafichePf;
    }

    public UplCrmAnagrafiche updateAnagrafiche(UplCrmAnagraficaContainer container) {
        if (container.getUplCrmAnagrafiche() == null) {
            return null;
        }
        var uplCrmAnagrafiche = anagrafichePersistenceService.getRepository().findById(container.getUplCrmAnagrafiche().getIdSoggetto())
                .orElseThrow(() -> new NoSuchElementException("UplCrmAnagrafiche with id = " + container.getUplCrmAnagrafiche().getIdSoggetto() + " is not present in DataBase!"));
        anagraficaEntitiesUpdateMapper.uplCrmAnagraficheUpdate(uplCrmAnagrafiche,container.getUplCrmAnagrafiche());
        return uplCrmAnagrafiche;
    }

    public UplCrmDatiSocioeconomici updateDatiSocioeconomici(UplCrmAnagraficaContainer container) {
        if (container.getUplCrmDatiSocioeconomici() == null) {
            return null;
        }
        var uplCrmDatiSocioeconomici = datiSocioeconomiciPersistenceService.getRepository().findById(container.getUplCrmDatiSocioeconomici().getIdDatiSocioeconomici())
                .orElseThrow(() -> new NoSuchElementException("datiSocioEconomici with id = " + container.getUplCrmDatiSocioeconomici().getIdDatiSocioeconomici() + " is not present in DataBase!"));
        anagraficaEntitiesUpdateMapper.uplCrmDatiSocioeconomiciUpdate(uplCrmDatiSocioeconomici,container.getUplCrmDatiSocioeconomici());
        return uplCrmDatiSocioeconomici;
    }

    public UplCrmAnagraficaAgenzia updateAgenzia(UplCrmAnagraficaContainer container) {
        if (container.getUplCrmAnagraficaAgenzia() == null) {
            return null;
        }
        var uplCrmAnagraficaAgenzia = anagraficaAgenziaPersistenceService.getRepository().findById(container.getUplCrmAnagraficaAgenzia().getIdAnagraficaAgenzia())
                .orElseThrow(() -> new NoSuchElementException("AnagraficaAgenzia with id = " + container.getUplCrmAnagraficaAgenzia().getIdAnagraficaAgenzia() + " is not present in DataBase!"));
        anagraficaEntitiesUpdateMapper.uplCrmAnagraficaAgenziaUpdate(uplCrmAnagraficaAgenzia,container.getUplCrmAnagraficaAgenzia());
        return uplCrmAnagraficaAgenzia;
    }
}

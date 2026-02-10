package it.unipol.crm.anagrafica.gestione.service;

import it.unipol.crm.anagrafica.gestione.model.UplCrmAnagraficaContainer;
import it.unipol.crm.anagrafica.gestione.service.entities.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.MissingResourceException;

@Slf4j
@Component
@Getter
@AllArgsConstructor
@Transactional(value = "anagraficaTransactionManager", propagation = Propagation.REQUIRES_NEW)
public class AnagraficaPersistenceServiceModifingData {
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
    private AnagraficaPersistenceServiceGettingData anagraficaPersistenceServiceGettingData;

    public UplCrmAnagraficaContainer insertDataFromCreaAnagraficaRequestIntoDatabaseTables(UplCrmAnagraficaContainer container) {
        anagrafichePersistenceService.insertAnagrafiche(container.getUplCrmAnagrafiche());

        container.getUplCrmAnagraficaAgenzia().setIdSoggetto(container.getUplCrmIndirizzi().getIdSoggetto());
        container.getUplCrmAnagrafichePf().setIdSoggetto(container.getUplCrmAnagrafiche().getIdSoggetto());
        container.getUplCrmAnagrafichePg().setIdSoggetto(container.getUplCrmAnagrafiche().getIdSoggetto());
        container.getUplCrmAnomaleAnagrafiche().setIdSoggetto(container.getUplCrmIndirizzi().getIdSoggetto());
        container.getUplCrmDatiSocioeconomici().setIdSoggetto(container.getUplCrmIndirizzi().getIdSoggetto());
        container.getUplCrmDatiSocioeconomiciPf().setIdSoggetto(container.getUplCrmIndirizzi().getIdSoggetto());
        container.getUplCrmDatiSocioeconomiciPfErrori().setIdSoggetto(container.getUplCrmIndirizzi().getIdSoggetto());
        container.getUplCrmDocumenti().setIdSoggetto(container.getUplCrmIndirizzi().getIdSoggetto());
        container.getUplCrmRecapiti().setIdSoggetto(container.getUplCrmIndirizzi().getIdSoggetto());
        container.getUplCrmAnagraficaIdentita().setIdSoggetto(container.getUplCrmIndirizzi().getIdSoggetto());

        indirizziPersistenceService.insertIndirizzi(container.getUplCrmIndirizzi());
        anagraficaAgenziaPersistenceService.insertAnagraficaAgenzia(container.getUplCrmAnagraficaAgenzia());
        anagRelPersistenceService.insertAnagRel(container.getUplCrmAnagRel());
        datiSocioeconomiciPersistenceService.insertDatiSocioeconomici(container.getUplCrmDatiSocioeconomici());
        datiSocioeconomiciPfPersistenceService.insertDatiSocioeconomiciPf(container.getUplCrmDatiSocioeconomiciPf());
        datiSocioeconomiciPfErroriPersistenceService.insertDatiSocioeconomiciPfErrori(container.getUplCrmDatiSocioeconomiciPfErrori());
        documentiPersistenceService.insertDocumenti(container.getUplCrmDocumenti());
        recapitiPersistenceService.insertRecapiti(container.getUplCrmRecapiti());
        anagraficaIdentitaPersistenceService.insertAnagraficaIdentita(container.getUplCrmAnagraficaIdentita());
        anagrafichePfPersistenceService.insertAnagrafichePf(container.getUplCrmAnagrafichePf());
        anomaleAnagrafichePersistenceService.insertAnomaleAnagrafiche(container.getUplCrmAnomaleAnagrafiche());
        anagrafichePgPersistenceService.insertAnagrafichePg(container.getUplCrmAnagrafichePg());

        return container;
    }
    public UplCrmAnagraficaContainer insertDataFromUpdateAnagraficaRequestIntoDatabaseTables(UplCrmAnagraficaContainer container) {
        checkAndInsertAnagrafiche(container);

        checkAndInsertAnagraficaAgenzia(container);

        checkAndInsertAnagrafichePf(container);

        checkAndInsertAnagrafichePg(container);

        checkAndInsertAnagRel(container);

        checkAndInsertAnomalieAnagrafiche(container);

        checkAndInsertDatiSocioeconomici(container);
        checkAndInsertDatiSocioeconomiciPf(container);
        checkAndInsertDocumenti(container);
        checkAndInsertIndirizzi(container);

        checkAndInsertRecapiti(container);

        checkAndInsertAnagraficaIdentita(container);

        return container;
    }

     void checkAndInsertAnagraficaIdentita(UplCrmAnagraficaContainer container) {
        if(container.getUplCrmAnagraficaIdentita() != null){
            if (container.getUplCrmAnagraficaIdentita().getIdAnagraficaIdentita() != null) {
                container.setUplCrmAnagraficaIdentita((anagraficaPersistenceServiceGettingData.updateIdentita(container)));
            }
            this.getAnagraficaIdentitaPersistenceService().insertAnagraficaIdentita(container.getUplCrmAnagraficaIdentita());
        }
    }

     void checkAndInsertRecapiti(UplCrmAnagraficaContainer container) {
        if(container.getUplCrmRecapiti() != null){
            if (container.getUplCrmRecapiti().getIdRecapito() != null) {
                container.setUplCrmRecapiti((anagraficaPersistenceServiceGettingData.updateRecapiti(container)));
            }
            this.getRecapitiPersistenceService().insertRecapiti(container.getUplCrmRecapiti());
        }
    }

     void checkAndInsertIndirizzi(UplCrmAnagraficaContainer container) {
        if(container.getUplCrmIndirizzi() != null){
            if (container.getUplCrmIndirizzi().getIdIndirizzo() != null) {
                container.setUplCrmIndirizzi((anagraficaPersistenceServiceGettingData.updateIndirizzi(container)));
            }
            this.getIndirizziPersistenceService().insertIndirizzi(container.getUplCrmIndirizzi());
        }
    }

     void checkAndInsertDocumenti(UplCrmAnagraficaContainer container) {
        checkAndInsertDatiSocioeconomiciPfErrori(container);
        if(container.getUplCrmDocumenti() != null){
            if (container.getUplCrmDocumenti().getIdDocumento() != null) {
                container.setUplCrmDocumenti((anagraficaPersistenceServiceGettingData.updateDocumenti(container)));
            }
            this.getDocumentiPersistenceService().insertDocumenti(container.getUplCrmDocumenti());
        }
    }

     void checkAndInsertDatiSocioeconomiciPfErrori(UplCrmAnagraficaContainer container) {
        if(container.getUplCrmDatiSocioeconomiciPfErrori() != null){
            if (container.getUplCrmDatiSocioeconomiciPfErrori().getIdDatiSocioeconomiciPfErrori() != null) {
                container.setUplCrmDatiSocioeconomiciPfErrori((anagraficaPersistenceServiceGettingData.updateDatiSocioeconomiciPfErrori(container)));
            }
            this.getDatiSocioeconomiciPfErroriPersistenceService().insertDatiSocioeconomiciPfErrori(container.getUplCrmDatiSocioeconomiciPfErrori());
        }
    }

     void checkAndInsertDatiSocioeconomiciPf(UplCrmAnagraficaContainer container) {
        if(container.getUplCrmDatiSocioeconomiciPf() != null){
            if (container.getUplCrmDatiSocioeconomiciPf().getIdDatiSocioeconomiciPf() != null) {
                container.setUplCrmDatiSocioeconomiciPf((anagraficaPersistenceServiceGettingData.updateDatiSocioeconomiciPf(container)));
            }
            this.getDatiSocioeconomiciPfPersistenceService().insertDatiSocioeconomiciPf(container.getUplCrmDatiSocioeconomiciPf());
        }
    }

     void checkAndInsertDatiSocioeconomici(UplCrmAnagraficaContainer container) {
        if(container.getUplCrmDatiSocioeconomici() != null){
            if (container.getUplCrmDatiSocioeconomici().getIdDatiSocioeconomici() != null) {
                container.setUplCrmDatiSocioeconomici((anagraficaPersistenceServiceGettingData.updateDatiSocioeconomici(container)));
            }
            this.getDatiSocioeconomiciPersistenceService().insertDatiSocioeconomici(container.getUplCrmDatiSocioeconomici());
        }
    }

     void checkAndInsertAnomalieAnagrafiche(UplCrmAnagraficaContainer container) {
        if(container.getUplCrmAnomaleAnagrafiche() != null){
            if (container.getUplCrmAnomaleAnagrafiche().getIdAnomalia() != null) {
                container.setUplCrmAnomaleAnagrafiche((anagraficaPersistenceServiceGettingData.updateAnomaleAnagrafiche(container)));
            }
            this.getAnomaleAnagrafichePersistenceService().insertAnomaleAnagrafiche(container.getUplCrmAnomaleAnagrafiche());
        }
    }

     void checkAndInsertAnagRel(UplCrmAnagraficaContainer container) {
        if(container.getUplCrmAnagRel() != null){
            if (container.getUplCrmAnagRel().getIdAnagRel() != null) {
                container.setUplCrmAnagRel((anagraficaPersistenceServiceGettingData.updateAnagRel(container)));
            }
            this.getAnagRelPersistenceService().insertAnagRel(container.getUplCrmAnagRel());
        }
    }

     void checkAndInsertAnagrafichePg(UplCrmAnagraficaContainer container) {
        if(container.getUplCrmAnagrafichePg() != null){
            if (container.getUplCrmAnagrafichePg().getIdSoggetto() != null) {
                container.setUplCrmAnagrafichePg((anagraficaPersistenceServiceGettingData.updateAnagrafichePg(container)));
            }
            this.getAnagrafichePgPersistenceService().insertAnagrafichePg(container.getUplCrmAnagrafichePg());
        }
        else throw new MissingResourceException("AnagrafichePg resource must be always present in request","PersonaGiuridica","");
    }

     void checkAndInsertAnagrafichePf(UplCrmAnagraficaContainer container) {
        if(container.getUplCrmAnagrafichePf() != null){
            if (container.getUplCrmAnagrafichePf().getIdSoggetto() != null) {
                container.setUplCrmAnagrafichePf((anagraficaPersistenceServiceGettingData.updateAnagrafichePf(container)));
            }
            this.getAnagrafichePfPersistenceService().insertAnagrafichePf(container.getUplCrmAnagrafichePf());
        }
        else throw new MissingResourceException("AnagrafichePf resource must be always present in request","PersonaFisica","");
    }

     void checkAndInsertAnagraficaAgenzia(UplCrmAnagraficaContainer container) {
        if(container.getUplCrmAnagraficaAgenzia() != null){
            if(container.getUplCrmAnagraficaAgenzia().getIdAnagraficaAgenzia() != null) {

                container.setUplCrmAnagraficaAgenzia((anagraficaPersistenceServiceGettingData.updateAgenzia(container)));
            }
            this.getAnagraficaAgenziaPersistenceService().insertAnagraficaAgenzia(container.getUplCrmAnagraficaAgenzia());
        }
    }

     void checkAndInsertAnagrafiche(UplCrmAnagraficaContainer container) {
        if(container.getUplCrmAnagrafiche() != null) {
            if (container.getUplCrmAnagrafiche().getIdSoggetto() != null) {
                container.setUplCrmAnagrafiche(anagraficaPersistenceServiceGettingData.updateAnagrafiche(container));
            }
            this.getAnagrafichePersistenceService().insertAnagrafiche(container.getUplCrmAnagrafiche());
        }
        else throw new MissingResourceException("Anagrafiche resource must be always present in request","DatiAnagrafici","");
    }
}

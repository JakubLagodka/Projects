package it.unipol.crm.anagrafica.gestione.service;

import it.unipol.crm.anagrafica.gestione.config.mapper.AnagraficaResponseMapper;
import it.unipol.crm.anagrafica.gestione.config.mapper.CreaAnagraficaRequestMapper;
import it.unipol.crm.anagrafica.gestione.config.mapper.UpdateAnagraficaRequestMapper;
import it.unipol.crm.anagrafica.gestione.model.AnagraficaResponse;
import it.unipol.crm.anagrafica.gestione.model.UplCrmAnagraficaContainer;
import it.unipol.crm.anagrafica.gestione.model.definitions.CreaAnagraficaRequest;
import it.unipol.crm.anagrafica.gestione.model.definitions.UpdateAnagraficaRequest;
import it.unipol.crm.anagrafica.gestione.util.HeaderParameters;
import it.unipol.crm.anagrafica.gestione.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
@Slf4j
public class AnagraficaService {

    @Autowired
    private AnagraficaResponseMapper mapper;
    @Autowired
    private CreaAnagraficaRequestMapper creaAnagraficaRequestMapper;
    @Autowired
    private UpdateAnagraficaRequestMapper updateAnagraficaRequestMapper;
    @Autowired
    private AnagraficaPersistenceServiceModifingData anagraficaPersistenceService;
    @Autowired
    private UplCrmAnagraficaContainer container;
    @Autowired
    private UserUtil userUtil;

    public AnagraficaResponse insertAnagrafica(String userName, CreaAnagraficaRequest anagrafica, HeaderParameters headerParameters) {
        anagraficaPersistenceService.insertDataFromCreaAnagraficaRequestIntoDatabaseTables(loadContainer(anagrafica));
        setUtente(anagrafica, userName, headerParameters);
        return mapper.convertCreaAnagraficaRequestToAnagraficaResponse(anagrafica);
    }
    public AnagraficaResponse updateAnagrafica(String userName, BigInteger idSoggetto, UpdateAnagraficaRequest anagrafica, HeaderParameters headerParameters) {
        anagrafica.setIdSoggetto(idSoggetto);
        UplCrmAnagraficaContainer container = loadContainer(anagrafica);
        container.getUplCrmAnagraficaAgenzia().setIdSoggetto(container.getIdSoggetto());
        container.getUplCrmAnagrafichePf().setIdSoggetto(container.getIdSoggetto());
        container.getUplCrmAnagrafichePg().setIdSoggetto(container.getIdSoggetto());
        container.getUplCrmAnomaleAnagrafiche().setIdSoggetto(container.getIdSoggetto());
        container.getUplCrmDatiSocioeconomici().setIdSoggetto(container.getIdSoggetto());
        container.getUplCrmDatiSocioeconomiciPf().setIdSoggetto(container.getIdSoggetto());
        container.getUplCrmDatiSocioeconomiciPfErrori().setIdSoggetto(container.getIdSoggetto());
        container.getUplCrmDocumenti().setIdSoggetto(container.getIdSoggetto());
        container.getUplCrmRecapiti().setIdSoggetto(container.getIdSoggetto());
        container.getUplCrmAnagraficaIdentita().setIdSoggetto(container.getIdSoggetto());
        container.getUplCrmAnagrafiche().setIdSoggetto(container.getIdSoggetto());

        anagraficaPersistenceService.insertDataFromUpdateAnagraficaRequestIntoDatabaseTables(container);
        setUtente(anagrafica, userName, headerParameters);
        return mapper.convertUpdateAnagraficaRequestToAnagraficaResponse(anagrafica);
    }
    UplCrmAnagraficaContainer loadContainer(UpdateAnagraficaRequest anagrafica) {
        container.setIdSoggetto(anagrafica.getIdSoggetto());
        container.setUplCrmAnagraficaAgenzia(updateAnagraficaRequestMapper.convertUpdateAnagraficaRequestToUplCrmAnagraficaAgenzia(anagrafica));
        container.setUplCrmAnagrafiche(updateAnagraficaRequestMapper.convertUpdateAnagraficaRequestToUplCrmAnagrafiche(anagrafica));
        container.setUplCrmAnagrafichePf(updateAnagraficaRequestMapper.convertUpdateAnagraficaRequestToUplCrmAnagrafichePf(anagrafica));
        container.setUplCrmAnagrafichePg(updateAnagraficaRequestMapper.convertUpdateAnagraficaRequestToUplCrmAnagrafichePg(anagrafica));
        container.setUplCrmAnomaleAnagrafiche(updateAnagraficaRequestMapper.convertUpdateAnagraficaRequestToUplCrmAnomalieAnagrafiche(anagrafica));
        container.setUplCrmAnagRel(updateAnagraficaRequestMapper.convertUpdateAnagraficaRequestToUplCrmAnagRel(anagrafica));
        container.setUplCrmDatiSocioeconomici(updateAnagraficaRequestMapper.convertUpdateAnagraficaRequestToUplCrmDatiSocioeconomici(anagrafica));
        container.setUplCrmDatiSocioeconomiciPf(updateAnagraficaRequestMapper.convertUpdateAnagraficaRequestToUplCrmDatiSocioeconomiciPf(anagrafica));
        container.setUplCrmDatiSocioeconomiciPfErrori(updateAnagraficaRequestMapper.convertUpdateAnagraficaRequestToUplCrmDatiSocioeconomiciPfErrori(anagrafica));
        container.setUplCrmDocumenti(updateAnagraficaRequestMapper.convertUpdateAnagraficaRequestToUplCrmDocumenti(anagrafica));
        container.setUplCrmIndirizzi(updateAnagraficaRequestMapper.convertUpdateAnagraficaRequestToUplCrmIndirizzi(anagrafica));
        container.setUplCrmRecapiti(updateAnagraficaRequestMapper.convertUpdateAnagraficaRequestToUplCrmRecapiti(anagrafica));
        container.setUplCrmAnagraficaIdentita(updateAnagraficaRequestMapper.convertUpdateAnagraficaRequestToUplCrmIdentita(anagrafica));
        return container;
    }
    private UplCrmAnagraficaContainer loadContainer(CreaAnagraficaRequest anagrafica) {
        container.setUplCrmAnagraficaAgenzia(creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmAnagraficaAgenzia(anagrafica));
        container.setUplCrmAnagrafiche(creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmAnagrafiche(anagrafica));
        container.setUplCrmAnagrafichePf(creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmAnagrafichePf(anagrafica));
        container.setUplCrmAnagrafichePg(creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmAnagrafichePg(anagrafica));
        container.setUplCrmAnomaleAnagrafiche(creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmAnomalieAnagrafiche(anagrafica));
        container.setUplCrmAnagRel(creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmAnagRel(anagrafica));
        container.setUplCrmDatiSocioeconomici(creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmDatiSocioeconomici(anagrafica));
        container.setUplCrmDatiSocioeconomiciPf(creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmDatiSocioeconomiciPf(anagrafica));
        container.setUplCrmDatiSocioeconomiciPfErrori(creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmDatiSocioeconomiciPfErrori(anagrafica));
        container.setUplCrmDocumenti(creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmDocumenti(anagrafica));
        container.setUplCrmIndirizzi(creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmIndirizzi(anagrafica));
        container.setUplCrmRecapiti(creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmRecapiti(anagrafica));
        container.setUplCrmAnagraficaIdentita(creaAnagraficaRequestMapper.convertCreaAnagraficaRequestToUplCrmIdentita(anagrafica));
        return container;
    }
    private void setUtente(CreaAnagraficaRequest anagrafica, String userName, HeaderParameters headerParameters) {
        anagrafica.getDatiAnagrafici().setUtenteAggiornamento(getUtente(userName, headerParameters));
        anagrafica.getDatiAnagrafici().setUtenteInserimento(getUtente(userName, headerParameters));
        anagrafica.getDatiSocioEconomiciPersoneFisiche().setUtenteAggiornamento(getUtente(userName, headerParameters));
        anagrafica.getDatiSocioEconomiciPersoneFisiche().setUtenteInserimento(getUtente(userName, headerParameters));
        anagrafica.getDatiSocioEconomici().setUtenteAggiornamento(getUtente(userName, headerParameters));
        anagrafica.getDatiSocioEconomici().setUtenteInserimento(getUtente(userName, headerParameters));
        anagrafica.getDatiSocioEconomiciPersoneFisicheErrori().setUtenteAggiornamento(getUtente(userName, headerParameters));
        anagrafica.getDatiSocioEconomiciPersoneFisicheErrori().setUtenteInserimento(getUtente(userName, headerParameters));
        anagrafica.getIndirizzi().setUtenteAggiornamento(getUtente(userName, headerParameters));
        anagrafica.getIndirizzi().setUtenteInserimento(getUtente(userName, headerParameters));
        anagrafica.getDocumenti().setUtenteAggiornamento(getUtente(userName, headerParameters));
        anagrafica.getDocumenti().setUtenteInserimento(getUtente(userName, headerParameters));
        anagrafica.getAgenzia().setUtenteAggiornamento(getUtente(userName, headerParameters));
        anagrafica.getAgenzia().setUtenteInserimento(getUtente(userName, headerParameters));
        anagrafica.getPersonaFisica().setUtenteAggiornamento(getUtente(userName, headerParameters));
        anagrafica.getPersonaFisica().setUtenteInserimento(getUtente(userName, headerParameters));
        anagrafica.getRecapiti().setUtenteAggiornamento(getUtente(userName, headerParameters));
        anagrafica.getRecapiti().setUtenteInserimento(getUtente(userName, headerParameters));
        anagrafica.getAnagRel().setUtenteAggiornamento(getUtente(userName, headerParameters));
        anagrafica.getAnagRel().setUtenteInserimento(getUtente(userName, headerParameters));
        anagrafica.getAnomalieAnagrafiche().setUtenteAggiornamento(getUtente(userName, headerParameters));
        anagrafica.getAnomalieAnagrafiche().setUtenteInserimento(getUtente(userName, headerParameters));
        anagrafica.getPersonaGiuridica().setUtenteAggiornamento(getUtente(userName, headerParameters));
        anagrafica.getPersonaGiuridica().setUtenteInserimento(getUtente(userName, headerParameters));
        anagrafica.getPrivacyProspect().setUtenteAggiornamento(getUtente(userName, headerParameters));
        anagrafica.getPrivacyProspect().setUtenteInserimento(getUtente(userName, headerParameters));
    }
    private String getUtente(String userName, HeaderParameters headerParameters) {
        return userUtil.calculateUpdateUser(
               userName,
                headerParameters.getApplicationId());
    }
}
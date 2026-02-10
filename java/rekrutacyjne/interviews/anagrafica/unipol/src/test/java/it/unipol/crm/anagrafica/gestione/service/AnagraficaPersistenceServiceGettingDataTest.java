package it.unipol.crm.anagrafica.gestione.service;

import it.unipol.crm.anagrafica.gestione.config.DatabaseConfiguration;
import it.unipol.crm.anagrafica.gestione.config.mapper.AnagraficaEntitiesUpdateMapper;
import it.unipol.crm.anagrafica.gestione.entity.code.*;
import it.unipol.crm.anagrafica.gestione.model.UplCrmAnagraficaContainer;
import it.unipol.crm.anagrafica.gestione.repository.*;
import it.unipol.crm.anagrafica.gestione.service.entities.*;
import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = DatabaseConfiguration.class)
@EnableAutoConfiguration
@Getter
public class AnagraficaPersistenceServiceGettingDataTest {
    @Mock
    private UplCrmAnagraficaAgenziaPersistenceService anagraficaAgenziaPersistenceService;
    @Mock
    private UplCrmAnagrafichePersistenceService anagrafichePersistenceService;
    @Mock
    private UplCrmAnagrafichePfPersistenceService anagrafichePfPersistenceService;
    @Mock
    private UplCrmAnagrafichePgPersistenceService anagrafichePgPersistenceService;
    @Mock
    private UplCrmAnomalieAnagrafichePersistenceService anomaleAnagrafichePersistenceService;
    @Mock
    private UplCrmAnagRelPersistenceService anagRelPersistenceService;
    @Mock
    private UplCrmDatiSocioeconomiciPersistenceService datiSocioeconomiciPersistenceService;
    @Mock
    private UplCrmDatiSocioeconomiciPfPersistenceService datiSocioeconomiciPfPersistenceService;
    @Mock
    private UplCrmDatiSocioeconomiciPfErroriPersistenceService datiSocioeconomiciPfErroriPersistenceService;
    @Mock
    private UplCrmDocumentiPersistenceService documentiPersistenceService;
    @Mock
    private UplCrmIndirizziPersistenceService indirizziPersistenceService;
    @Mock
    private UplCrmRecapitiPersistenceService recapitiPersistenceService;
    @Mock
    private UplCrmAnagraficaIdentitaPersistenceService anagraficaIdentitaPersistenceService;
    @InjectMocks
    private AnagraficaPersistenceServiceGettingData anagraficaPersistenceService;
    @Autowired
    private UplCrmAnagraficaAgenziaRepository uplCrmAnagraficaAgenziaRepository;
    @Autowired
    private UplCrmDatiSocioeconomiciRepository uplCrmDatiSocioeconomiciRepository;
    @Autowired
    private UplCrmAnagraficheRepository uplCrmAnagraficheRepository;
    @Autowired
    private UplCrmAnagrafichePfRepository uplCrmAnagrafichePfRepository;
    @Autowired
    private UplCrmAnagrafichePgRepository uplCrmAnagrafichePgRepository;
    @Autowired
    private UplCrmAnagRelRepository uplCrmAnagRelRepository;
    @Autowired
    private UplCrmAnomalieAnagraficheRepository uplCrmAnomaleAnagraficheRepository;
    @Autowired
    private UplCrmDatiSocioeconomiciPfRepository uplCrmDatiSocioeconomiciPfRepository;
    @Autowired
    private UplCrmDatiSocioeconomiciPfErroriRepository uplCrmDatiSocioeconomiciPfErroriRepository;
    @Autowired
    private UplCrmDocumentiRepository uplCrmDocumentiRepository;
    @Autowired
    private UplCrmIndirizziRepository uplCrmIndirizziRepository;
    @Autowired
    private UplCrmRecapitiRepository uplCrmRecapitiRepository;
    @Autowired
    private UplCrmAnagraficaIdentitaRepository anagraficaIdentitaRepository;
    @Mock
    private UplCrmAnagraficaContainer uplCrmAnagraficaContainer;
    @Mock
    public AnagraficaEntitiesUpdateMapper anagraficaEntitiesUpdateMapper;
    @Test
    public void shouldNotUpdateAnagraficaAgenziaEmptyInput() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateAgenzia(uplCrmAnagraficaContainer);
        //then
        assertNull(result, "inserted object shouldn't be null");
    }

    @Test
    public void shouldUpdateAnagrafiche() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();
        container.setUplCrmAnagrafiche(new UplCrmAnagrafiche());
        container.getUplCrmAnagrafiche().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmDocumenti(new UplCrmDocumenti());
        container.getUplCrmDocumenti().setIdDocumento(BigInteger.ONE);
        container.setUplCrmIndirizzi(new UplCrmIndirizzi());
        container.getUplCrmIndirizzi().setIdIndirizzo(BigInteger.ONE);
        container.setUplCrmAnagRel(new UplCrmAnagRel());
        container.getUplCrmAnagRel().setIdAnagRel(BigInteger.ONE);
        container.setUplCrmRecapiti(new UplCrmRecapiti());
        container.getUplCrmRecapiti().setIdRecapito(BigInteger.ONE);
        container.setUplCrmAnagraficaAgenzia(new UplCrmAnagraficaAgenzia());
        container.getUplCrmAnagraficaAgenzia().setIdAnagraficaAgenzia(BigInteger.ONE);
        container.setUplCrmAnagraficaIdentita(new UplCrmAnagraficaIdentita());
        container.getUplCrmAnagraficaIdentita().setIdAnagraficaIdentita(BigInteger.ONE);
        container.setUplCrmAnagrafichePf(new UplCrmAnagrafichePf());
        container.getUplCrmAnagrafichePf().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnagrafichePg(new UplCrmAnagrafichePg());
        container.getUplCrmAnagrafichePg().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnomaleAnagrafiche(new UplCrmAnomalieAnagrafiche());
        container.getUplCrmAnomaleAnagrafiche().setIdAnomalia(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomici(new UplCrmDatiSocioeconomici());
        container.getUplCrmDatiSocioeconomici().setIdDatiSocioeconomici(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPf(new UplCrmDatiSocioeconomiciPf());
        container.getUplCrmDatiSocioeconomiciPf().setIdDatiSocioeconomiciPf(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPfErrori(new UplCrmDatiSocioeconomiciPfErrori());
        container.getUplCrmDatiSocioeconomiciPfErrori().setIdDatiSocioeconomiciPfErrori(BigInteger.ONE);
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateAnagrafiche(uplCrmAnagraficaContainer);
        //then
        assertNotNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldUpdateAnagrafichePf() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();
        container.setUplCrmAnagrafiche(new UplCrmAnagrafiche());
        container.getUplCrmAnagrafiche().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmDocumenti(new UplCrmDocumenti());
        container.getUplCrmDocumenti().setIdDocumento(BigInteger.ONE);
        container.setUplCrmIndirizzi(new UplCrmIndirizzi());
        container.getUplCrmIndirizzi().setIdIndirizzo(BigInteger.ONE);
        container.setUplCrmAnagRel(new UplCrmAnagRel());
        container.getUplCrmAnagRel().setIdAnagRel(BigInteger.ONE);
        container.setUplCrmRecapiti(new UplCrmRecapiti());
        container.getUplCrmRecapiti().setIdRecapito(BigInteger.ONE);
        container.setUplCrmAnagraficaAgenzia(new UplCrmAnagraficaAgenzia());
        container.getUplCrmAnagraficaAgenzia().setIdAnagraficaAgenzia(BigInteger.ONE);
        container.setUplCrmAnagraficaIdentita(new UplCrmAnagraficaIdentita());
        container.getUplCrmAnagraficaIdentita().setIdAnagraficaIdentita(BigInteger.ONE);
        container.setUplCrmAnagrafichePf(new UplCrmAnagrafichePf());
        container.getUplCrmAnagrafichePf().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnagrafichePg(new UplCrmAnagrafichePg());
        container.getUplCrmAnagrafichePg().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnomaleAnagrafiche(new UplCrmAnomalieAnagrafiche());
        container.getUplCrmAnomaleAnagrafiche().setIdAnomalia(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomici(new UplCrmDatiSocioeconomici());
        container.getUplCrmDatiSocioeconomici().setIdDatiSocioeconomici(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPf(new UplCrmDatiSocioeconomiciPf());
        container.getUplCrmDatiSocioeconomiciPf().setIdDatiSocioeconomiciPf(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPfErrori(new UplCrmDatiSocioeconomiciPfErrori());
        container.getUplCrmDatiSocioeconomiciPfErrori().setIdDatiSocioeconomiciPfErrori(BigInteger.ONE);
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateAnagrafichePf(uplCrmAnagraficaContainer);
        //then
        assertNotNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldUpdateAnagrafichePg() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();
        container.setUplCrmAnagrafiche(new UplCrmAnagrafiche());
        container.getUplCrmAnagrafiche().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmDocumenti(new UplCrmDocumenti());
        container.getUplCrmDocumenti().setIdDocumento(BigInteger.ONE);
        container.setUplCrmIndirizzi(new UplCrmIndirizzi());
        container.getUplCrmIndirizzi().setIdIndirizzo(BigInteger.ONE);
        container.setUplCrmAnagRel(new UplCrmAnagRel());
        container.getUplCrmAnagRel().setIdAnagRel(BigInteger.ONE);
        container.setUplCrmRecapiti(new UplCrmRecapiti());
        container.getUplCrmRecapiti().setIdRecapito(BigInteger.ONE);
        container.setUplCrmAnagraficaAgenzia(new UplCrmAnagraficaAgenzia());
        container.getUplCrmAnagraficaAgenzia().setIdAnagraficaAgenzia(BigInteger.ONE);
        container.setUplCrmAnagraficaIdentita(new UplCrmAnagraficaIdentita());
        container.getUplCrmAnagraficaIdentita().setIdAnagraficaIdentita(BigInteger.ONE);
        container.setUplCrmAnagrafichePf(new UplCrmAnagrafichePf());
        container.getUplCrmAnagrafichePf().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnagrafichePg(new UplCrmAnagrafichePg());
        container.getUplCrmAnagrafichePg().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnomaleAnagrafiche(new UplCrmAnomalieAnagrafiche());
        container.getUplCrmAnomaleAnagrafiche().setIdAnomalia(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomici(new UplCrmDatiSocioeconomici());
        container.getUplCrmDatiSocioeconomici().setIdDatiSocioeconomici(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPf(new UplCrmDatiSocioeconomiciPf());
        container.getUplCrmDatiSocioeconomiciPf().setIdDatiSocioeconomiciPf(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPfErrori(new UplCrmDatiSocioeconomiciPfErrori());
        container.getUplCrmDatiSocioeconomiciPfErrori().setIdDatiSocioeconomiciPfErrori(BigInteger.ONE);
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateAnagrafichePg(uplCrmAnagraficaContainer);
        //then
        assertNotNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldUpdateAnomalieAnagrafiche() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();
        container.setUplCrmAnagrafiche(new UplCrmAnagrafiche());
        container.getUplCrmAnagrafiche().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmDocumenti(new UplCrmDocumenti());
        container.getUplCrmDocumenti().setIdDocumento(BigInteger.ONE);
        container.setUplCrmIndirizzi(new UplCrmIndirizzi());
        container.getUplCrmIndirizzi().setIdIndirizzo(BigInteger.ONE);
        container.setUplCrmAnagRel(new UplCrmAnagRel());
        container.getUplCrmAnagRel().setIdAnagRel(BigInteger.ONE);
        container.setUplCrmRecapiti(new UplCrmRecapiti());
        container.getUplCrmRecapiti().setIdRecapito(BigInteger.ONE);
        container.setUplCrmAnagraficaAgenzia(new UplCrmAnagraficaAgenzia());
        container.getUplCrmAnagraficaAgenzia().setIdAnagraficaAgenzia(BigInteger.ONE);
        container.setUplCrmAnagraficaIdentita(new UplCrmAnagraficaIdentita());
        container.getUplCrmAnagraficaIdentita().setIdAnagraficaIdentita(BigInteger.ONE);
        container.setUplCrmAnagrafichePf(new UplCrmAnagrafichePf());
        container.getUplCrmAnagrafichePf().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnagrafichePg(new UplCrmAnagrafichePg());
        container.getUplCrmAnagrafichePg().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnomaleAnagrafiche(new UplCrmAnomalieAnagrafiche());
        container.getUplCrmAnomaleAnagrafiche().setIdAnomalia(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomici(new UplCrmDatiSocioeconomici());
        container.getUplCrmDatiSocioeconomici().setIdDatiSocioeconomici(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPf(new UplCrmDatiSocioeconomiciPf());
        container.getUplCrmDatiSocioeconomiciPf().setIdDatiSocioeconomiciPf(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPfErrori(new UplCrmDatiSocioeconomiciPfErrori());
        container.getUplCrmDatiSocioeconomiciPfErrori().setIdDatiSocioeconomiciPfErrori(BigInteger.ONE);
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateAnomaleAnagrafiche(uplCrmAnagraficaContainer);
        //then
        assertNotNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldUpdateAnagRel() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();
        container.setUplCrmAnagrafiche(new UplCrmAnagrafiche());
        container.getUplCrmAnagrafiche().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmDocumenti(new UplCrmDocumenti());
        container.getUplCrmDocumenti().setIdDocumento(BigInteger.ONE);
        container.setUplCrmIndirizzi(new UplCrmIndirizzi());
        container.getUplCrmIndirizzi().setIdIndirizzo(BigInteger.ONE);
        container.setUplCrmAnagRel(new UplCrmAnagRel());
        container.getUplCrmAnagRel().setIdAnagRel(BigInteger.ONE);
        container.setUplCrmRecapiti(new UplCrmRecapiti());
        container.getUplCrmRecapiti().setIdRecapito(BigInteger.ONE);
        container.setUplCrmAnagraficaAgenzia(new UplCrmAnagraficaAgenzia());
        container.getUplCrmAnagraficaAgenzia().setIdAnagraficaAgenzia(BigInteger.ONE);
        container.setUplCrmAnagraficaIdentita(new UplCrmAnagraficaIdentita());
        container.getUplCrmAnagraficaIdentita().setIdAnagraficaIdentita(BigInteger.ONE);
        container.setUplCrmAnagrafichePf(new UplCrmAnagrafichePf());
        container.getUplCrmAnagrafichePf().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnagrafichePg(new UplCrmAnagrafichePg());
        container.getUplCrmAnagrafichePg().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnomaleAnagrafiche(new UplCrmAnomalieAnagrafiche());
        container.getUplCrmAnomaleAnagrafiche().setIdAnomalia(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomici(new UplCrmDatiSocioeconomici());
        container.getUplCrmDatiSocioeconomici().setIdDatiSocioeconomici(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPf(new UplCrmDatiSocioeconomiciPf());
        container.getUplCrmDatiSocioeconomiciPf().setIdDatiSocioeconomiciPf(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPfErrori(new UplCrmDatiSocioeconomiciPfErrori());
        container.getUplCrmDatiSocioeconomiciPfErrori().setIdDatiSocioeconomiciPfErrori(BigInteger.ONE);
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateAnagRel(uplCrmAnagraficaContainer);
        //then
        assertNotNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldUpdateAnagraficaIdentita() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();
        container.setUplCrmAnagrafiche(new UplCrmAnagrafiche());
        container.getUplCrmAnagrafiche().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmDocumenti(new UplCrmDocumenti());
        container.getUplCrmDocumenti().setIdDocumento(BigInteger.ONE);
        container.setUplCrmIndirizzi(new UplCrmIndirizzi());
        container.getUplCrmIndirizzi().setIdIndirizzo(BigInteger.ONE);
        container.setUplCrmAnagRel(new UplCrmAnagRel());
        container.getUplCrmAnagRel().setIdAnagRel(BigInteger.ONE);
        container.setUplCrmRecapiti(new UplCrmRecapiti());
        container.getUplCrmRecapiti().setIdRecapito(BigInteger.ONE);
        container.setUplCrmAnagraficaAgenzia(new UplCrmAnagraficaAgenzia());
        container.getUplCrmAnagraficaAgenzia().setIdAnagraficaAgenzia(BigInteger.ONE);
        container.setUplCrmAnagraficaIdentita(new UplCrmAnagraficaIdentita());
        container.getUplCrmAnagraficaIdentita().setIdAnagraficaIdentita(BigInteger.ONE);
        container.setUplCrmAnagrafichePf(new UplCrmAnagrafichePf());
        container.getUplCrmAnagrafichePf().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnagrafichePg(new UplCrmAnagrafichePg());
        container.getUplCrmAnagrafichePg().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnomaleAnagrafiche(new UplCrmAnomalieAnagrafiche());
        container.getUplCrmAnomaleAnagrafiche().setIdAnomalia(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomici(new UplCrmDatiSocioeconomici());
        container.getUplCrmDatiSocioeconomici().setIdDatiSocioeconomici(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPf(new UplCrmDatiSocioeconomiciPf());
        container.getUplCrmDatiSocioeconomiciPf().setIdDatiSocioeconomiciPf(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPfErrori(new UplCrmDatiSocioeconomiciPfErrori());
        container.getUplCrmDatiSocioeconomiciPfErrori().setIdDatiSocioeconomiciPfErrori(BigInteger.ONE);
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateIdentita(uplCrmAnagraficaContainer);
        //then
        assertNotNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldUpdateIndirizzi() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();
        container.setUplCrmAnagrafiche(new UplCrmAnagrafiche());
        container.getUplCrmAnagrafiche().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmDocumenti(new UplCrmDocumenti());
        container.getUplCrmDocumenti().setIdDocumento(BigInteger.ONE);
        container.setUplCrmIndirizzi(new UplCrmIndirizzi());
        container.getUplCrmIndirizzi().setIdIndirizzo(BigInteger.ONE);
        container.setUplCrmAnagRel(new UplCrmAnagRel());
        container.getUplCrmAnagRel().setIdAnagRel(BigInteger.ONE);
        container.setUplCrmRecapiti(new UplCrmRecapiti());
        container.getUplCrmRecapiti().setIdRecapito(BigInteger.ONE);
        container.setUplCrmAnagraficaAgenzia(new UplCrmAnagraficaAgenzia());
        container.getUplCrmAnagraficaAgenzia().setIdAnagraficaAgenzia(BigInteger.ONE);
        container.setUplCrmAnagraficaIdentita(new UplCrmAnagraficaIdentita());
        container.getUplCrmAnagraficaIdentita().setIdAnagraficaIdentita(BigInteger.ONE);
        container.setUplCrmAnagrafichePf(new UplCrmAnagrafichePf());
        container.getUplCrmAnagrafichePf().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnagrafichePg(new UplCrmAnagrafichePg());
        container.getUplCrmAnagrafichePg().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnomaleAnagrafiche(new UplCrmAnomalieAnagrafiche());
        container.getUplCrmAnomaleAnagrafiche().setIdAnomalia(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomici(new UplCrmDatiSocioeconomici());
        container.getUplCrmDatiSocioeconomici().setIdDatiSocioeconomici(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPf(new UplCrmDatiSocioeconomiciPf());
        container.getUplCrmDatiSocioeconomiciPf().setIdDatiSocioeconomiciPf(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPfErrori(new UplCrmDatiSocioeconomiciPfErrori());
        container.getUplCrmDatiSocioeconomiciPfErrori().setIdDatiSocioeconomiciPfErrori(BigInteger.ONE);
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateIndirizzi(uplCrmAnagraficaContainer);
        //then
        assertNotNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldUpdateDocumenti() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();
        container.setUplCrmAnagrafiche(new UplCrmAnagrafiche());
        container.getUplCrmAnagrafiche().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmDocumenti(new UplCrmDocumenti());
        container.getUplCrmDocumenti().setIdDocumento(BigInteger.ONE);
        container.setUplCrmIndirizzi(new UplCrmIndirizzi());
        container.getUplCrmIndirizzi().setIdIndirizzo(BigInteger.ONE);
        container.setUplCrmAnagRel(new UplCrmAnagRel());
        container.getUplCrmAnagRel().setIdAnagRel(BigInteger.ONE);
        container.setUplCrmRecapiti(new UplCrmRecapiti());
        container.getUplCrmRecapiti().setIdRecapito(BigInteger.ONE);
        container.setUplCrmAnagraficaAgenzia(new UplCrmAnagraficaAgenzia());
        container.getUplCrmAnagraficaAgenzia().setIdAnagraficaAgenzia(BigInteger.ONE);
        container.setUplCrmAnagraficaIdentita(new UplCrmAnagraficaIdentita());
        container.getUplCrmAnagraficaIdentita().setIdAnagraficaIdentita(BigInteger.ONE);
        container.setUplCrmAnagrafichePf(new UplCrmAnagrafichePf());
        container.getUplCrmAnagrafichePf().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnagrafichePg(new UplCrmAnagrafichePg());
        container.getUplCrmAnagrafichePg().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnomaleAnagrafiche(new UplCrmAnomalieAnagrafiche());
        container.getUplCrmAnomaleAnagrafiche().setIdAnomalia(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomici(new UplCrmDatiSocioeconomici());
        container.getUplCrmDatiSocioeconomici().setIdDatiSocioeconomici(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPf(new UplCrmDatiSocioeconomiciPf());
        container.getUplCrmDatiSocioeconomiciPf().setIdDatiSocioeconomiciPf(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPfErrori(new UplCrmDatiSocioeconomiciPfErrori());
        container.getUplCrmDatiSocioeconomiciPfErrori().setIdDatiSocioeconomiciPfErrori(BigInteger.ONE);
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateDocumenti(uplCrmAnagraficaContainer);
        //then
        assertNotNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldUpdateRecapiti() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();
        container.setUplCrmAnagrafiche(new UplCrmAnagrafiche());
        container.getUplCrmAnagrafiche().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmDocumenti(new UplCrmDocumenti());
        container.getUplCrmDocumenti().setIdDocumento(BigInteger.ONE);
        container.setUplCrmIndirizzi(new UplCrmIndirizzi());
        container.getUplCrmIndirizzi().setIdIndirizzo(BigInteger.ONE);
        container.setUplCrmAnagRel(new UplCrmAnagRel());
        container.getUplCrmAnagRel().setIdAnagRel(BigInteger.ONE);
        container.setUplCrmRecapiti(new UplCrmRecapiti());
        container.getUplCrmRecapiti().setIdRecapito(BigInteger.ONE);
        container.setUplCrmAnagraficaAgenzia(new UplCrmAnagraficaAgenzia());
        container.getUplCrmAnagraficaAgenzia().setIdAnagraficaAgenzia(BigInteger.ONE);
        container.setUplCrmAnagraficaIdentita(new UplCrmAnagraficaIdentita());
        container.getUplCrmAnagraficaIdentita().setIdAnagraficaIdentita(BigInteger.ONE);
        container.setUplCrmAnagrafichePf(new UplCrmAnagrafichePf());
        container.getUplCrmAnagrafichePf().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnagrafichePg(new UplCrmAnagrafichePg());
        container.getUplCrmAnagrafichePg().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnomaleAnagrafiche(new UplCrmAnomalieAnagrafiche());
        container.getUplCrmAnomaleAnagrafiche().setIdAnomalia(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomici(new UplCrmDatiSocioeconomici());
        container.getUplCrmDatiSocioeconomici().setIdDatiSocioeconomici(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPf(new UplCrmDatiSocioeconomiciPf());
        container.getUplCrmDatiSocioeconomiciPf().setIdDatiSocioeconomiciPf(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPfErrori(new UplCrmDatiSocioeconomiciPfErrori());
        container.getUplCrmDatiSocioeconomiciPfErrori().setIdDatiSocioeconomiciPfErrori(BigInteger.ONE);
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateRecapiti(uplCrmAnagraficaContainer);
        //then
        assertNotNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldUpdateDatiSocioeconomici() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();
        container.setUplCrmAnagrafiche(new UplCrmAnagrafiche());
        container.getUplCrmAnagrafiche().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmDocumenti(new UplCrmDocumenti());
        container.getUplCrmDocumenti().setIdDocumento(BigInteger.ONE);
        container.setUplCrmIndirizzi(new UplCrmIndirizzi());
        container.getUplCrmIndirizzi().setIdIndirizzo(BigInteger.ONE);
        container.setUplCrmAnagRel(new UplCrmAnagRel());
        container.getUplCrmAnagRel().setIdAnagRel(BigInteger.ONE);
        container.setUplCrmRecapiti(new UplCrmRecapiti());
        container.getUplCrmRecapiti().setIdRecapito(BigInteger.ONE);
        container.setUplCrmAnagraficaAgenzia(new UplCrmAnagraficaAgenzia());
        container.getUplCrmAnagraficaAgenzia().setIdAnagraficaAgenzia(BigInteger.ONE);
        container.setUplCrmAnagraficaIdentita(new UplCrmAnagraficaIdentita());
        container.getUplCrmAnagraficaIdentita().setIdAnagraficaIdentita(BigInteger.ONE);
        container.setUplCrmAnagrafichePf(new UplCrmAnagrafichePf());
        container.getUplCrmAnagrafichePf().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnagrafichePg(new UplCrmAnagrafichePg());
        container.getUplCrmAnagrafichePg().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnomaleAnagrafiche(new UplCrmAnomalieAnagrafiche());
        container.getUplCrmAnomaleAnagrafiche().setIdAnomalia(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomici(new UplCrmDatiSocioeconomici());
        container.getUplCrmDatiSocioeconomici().setIdDatiSocioeconomici(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPf(new UplCrmDatiSocioeconomiciPf());
        container.getUplCrmDatiSocioeconomiciPf().setIdDatiSocioeconomiciPf(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPfErrori(new UplCrmDatiSocioeconomiciPfErrori());
        container.getUplCrmDatiSocioeconomiciPfErrori().setIdDatiSocioeconomiciPfErrori(BigInteger.ONE);
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateDatiSocioeconomici(uplCrmAnagraficaContainer);
        //then
        assertNotNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldUpdateDatiSocioeconomiciPf() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();
        container.setUplCrmAnagrafiche(new UplCrmAnagrafiche());
        container.getUplCrmAnagrafiche().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmDocumenti(new UplCrmDocumenti());
        container.getUplCrmDocumenti().setIdDocumento(BigInteger.ONE);
        container.setUplCrmIndirizzi(new UplCrmIndirizzi());
        container.getUplCrmIndirizzi().setIdIndirizzo(BigInteger.ONE);
        container.setUplCrmAnagRel(new UplCrmAnagRel());
        container.getUplCrmAnagRel().setIdAnagRel(BigInteger.ONE);
        container.setUplCrmRecapiti(new UplCrmRecapiti());
        container.getUplCrmRecapiti().setIdRecapito(BigInteger.ONE);
        container.setUplCrmAnagraficaAgenzia(new UplCrmAnagraficaAgenzia());
        container.getUplCrmAnagraficaAgenzia().setIdAnagraficaAgenzia(BigInteger.ONE);
        container.setUplCrmAnagraficaIdentita(new UplCrmAnagraficaIdentita());
        container.getUplCrmAnagraficaIdentita().setIdAnagraficaIdentita(BigInteger.ONE);
        container.setUplCrmAnagrafichePf(new UplCrmAnagrafichePf());
        container.getUplCrmAnagrafichePf().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnagrafichePg(new UplCrmAnagrafichePg());
        container.getUplCrmAnagrafichePg().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnomaleAnagrafiche(new UplCrmAnomalieAnagrafiche());
        container.getUplCrmAnomaleAnagrafiche().setIdAnomalia(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomici(new UplCrmDatiSocioeconomici());
        container.getUplCrmDatiSocioeconomici().setIdDatiSocioeconomici(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPf(new UplCrmDatiSocioeconomiciPf());
        container.getUplCrmDatiSocioeconomiciPf().setIdDatiSocioeconomiciPf(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPfErrori(new UplCrmDatiSocioeconomiciPfErrori());
        container.getUplCrmDatiSocioeconomiciPfErrori().setIdDatiSocioeconomiciPfErrori(BigInteger.ONE);
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateDatiSocioeconomiciPf(uplCrmAnagraficaContainer);
        //then
        assertNotNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldUpdateDatiSocioeconomiciPfErrori() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();
        container.setUplCrmAnagrafiche(new UplCrmAnagrafiche());
        container.getUplCrmAnagrafiche().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmDocumenti(new UplCrmDocumenti());
        container.getUplCrmDocumenti().setIdDocumento(BigInteger.ONE);
        container.setUplCrmIndirizzi(new UplCrmIndirizzi());
        container.getUplCrmIndirizzi().setIdIndirizzo(BigInteger.ONE);
        container.setUplCrmAnagRel(new UplCrmAnagRel());
        container.getUplCrmAnagRel().setIdAnagRel(BigInteger.ONE);
        container.setUplCrmRecapiti(new UplCrmRecapiti());
        container.getUplCrmRecapiti().setIdRecapito(BigInteger.ONE);
        container.setUplCrmAnagraficaAgenzia(new UplCrmAnagraficaAgenzia());
        container.getUplCrmAnagraficaAgenzia().setIdAnagraficaAgenzia(BigInteger.ONE);
        container.setUplCrmAnagraficaIdentita(new UplCrmAnagraficaIdentita());
        container.getUplCrmAnagraficaIdentita().setIdAnagraficaIdentita(BigInteger.ONE);
        container.setUplCrmAnagrafichePf(new UplCrmAnagrafichePf());
        container.getUplCrmAnagrafichePf().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnagrafichePg(new UplCrmAnagrafichePg());
        container.getUplCrmAnagrafichePg().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnomaleAnagrafiche(new UplCrmAnomalieAnagrafiche());
        container.getUplCrmAnomaleAnagrafiche().setIdAnomalia(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomici(new UplCrmDatiSocioeconomici());
        container.getUplCrmDatiSocioeconomici().setIdDatiSocioeconomici(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPf(new UplCrmDatiSocioeconomiciPf());
        container.getUplCrmDatiSocioeconomiciPf().setIdDatiSocioeconomiciPf(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPfErrori(new UplCrmDatiSocioeconomiciPfErrori());
        container.getUplCrmDatiSocioeconomiciPfErrori().setIdDatiSocioeconomiciPfErrori(BigInteger.ONE);
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateDatiSocioeconomiciPfErrori(uplCrmAnagraficaContainer);
        //then
        assertNotNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldUpdateAnagraficaAgenzia() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();
        container.setUplCrmAnagrafiche(new UplCrmAnagrafiche());
        container.getUplCrmAnagrafiche().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmDocumenti(new UplCrmDocumenti());
        container.getUplCrmDocumenti().setIdDocumento(BigInteger.ONE);
        container.setUplCrmIndirizzi(new UplCrmIndirizzi());
        container.getUplCrmIndirizzi().setIdIndirizzo(BigInteger.ONE);
        container.setUplCrmAnagRel(new UplCrmAnagRel());
        container.getUplCrmAnagRel().setIdAnagRel(BigInteger.ONE);
        container.setUplCrmRecapiti(new UplCrmRecapiti());
        container.getUplCrmRecapiti().setIdRecapito(BigInteger.ONE);
        container.setUplCrmAnagraficaAgenzia(new UplCrmAnagraficaAgenzia());
        container.getUplCrmAnagraficaAgenzia().setIdAnagraficaAgenzia(BigInteger.ONE);
        container.setUplCrmAnagraficaIdentita(new UplCrmAnagraficaIdentita());
        container.getUplCrmAnagraficaIdentita().setIdAnagraficaIdentita(BigInteger.ONE);
        container.setUplCrmAnagrafichePf(new UplCrmAnagrafichePf());
        container.getUplCrmAnagrafichePf().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnagrafichePg(new UplCrmAnagrafichePg());
        container.getUplCrmAnagrafichePg().setIdSoggetto(BigInteger.ONE);
        container.setUplCrmAnomaleAnagrafiche(new UplCrmAnomalieAnagrafiche());
        container.getUplCrmAnomaleAnagrafiche().setIdAnomalia(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomici(new UplCrmDatiSocioeconomici());
        container.getUplCrmDatiSocioeconomici().setIdDatiSocioeconomici(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPf(new UplCrmDatiSocioeconomiciPf());
        container.getUplCrmDatiSocioeconomiciPf().setIdDatiSocioeconomiciPf(BigInteger.ONE);
        container.setUplCrmDatiSocioeconomiciPfErrori(new UplCrmDatiSocioeconomiciPfErrori());
        container.getUplCrmDatiSocioeconomiciPfErrori().setIdDatiSocioeconomiciPfErrori(BigInteger.ONE);
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateAgenzia(uplCrmAnagraficaContainer);
        //then
        assertNotNull(result, "inserted object shouldn't be null");
    }

    @Test
    public void shouldNotUpdateAnagraficheEmptyInput() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateAnagrafiche(uplCrmAnagraficaContainer);
        //then
        assertNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldNotUpdateAnagrafichePfEmptyData() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateAnagrafichePf(uplCrmAnagraficaContainer);
        //then
        assertNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldNotUpdateAnagrafichePgEmptyInput() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateAnagrafichePg(uplCrmAnagraficaContainer);
        //then
        assertNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldNotUpdateAnomalieAnagraficheEmptyInput() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateAnomaleAnagrafiche(uplCrmAnagraficaContainer);
        //then
        assertNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldNotUpdateAnagRelEmptyInput() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateAnagRel(uplCrmAnagraficaContainer);
        //then
        assertNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldNotUpdateAnagraficaIdentitaEmptyInput() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateIdentita(uplCrmAnagraficaContainer);
        //then
        assertNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldNotUpdateIndirizziEmptyInput() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateIndirizzi(uplCrmAnagraficaContainer);
        //then
        assertNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldNotUpdateDocumentiEmptyInput() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateDocumenti(uplCrmAnagraficaContainer);
        //then
        assertNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldNotUpdateRecapitiEmptyInput() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateRecapiti(uplCrmAnagraficaContainer);
        //then
        assertNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldNotUpdateDatiSocioeconomiciEmptyInput() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateDatiSocioeconomici(uplCrmAnagraficaContainer);
        //then
        assertNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldNotUpdateDatiSocioeconomiciPfEmptyInput() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateDatiSocioeconomiciPf(uplCrmAnagraficaContainer);
        //then
        assertNull(result, "inserted object shouldn't be null");
    }
    @Test
    public void shouldNotUpdateDatiSocioeconomiciPfErroriEmptyInput() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        BDDMockito.when(anagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficheRepository());
        BDDMockito.when(anagrafichePfPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePfRepository());
        BDDMockito.when(anagrafichePgPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagrafichePgRepository());
        BDDMockito.when(anomaleAnagrafichePersistenceService.getRepository()).thenReturn(this.getUplCrmAnomaleAnagraficheRepository());
        BDDMockito.when(anagraficaAgenziaPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagraficaAgenziaRepository());
        BDDMockito.when(anagraficaIdentitaPersistenceService.getRepository()).thenReturn(this.getAnagraficaIdentitaRepository());
        BDDMockito.when(anagRelPersistenceService.getRepository()).thenReturn(this.getUplCrmAnagRelRepository());
        BDDMockito.when(recapitiPersistenceService.getRepository()).thenReturn(this.getUplCrmRecapitiRepository());
        BDDMockito.when(indirizziPersistenceService.getRepository()).thenReturn(this.getUplCrmIndirizziRepository());
        BDDMockito.when(documentiPersistenceService.getRepository()).thenReturn(this.getUplCrmDocumentiRepository());
        BDDMockito.when(datiSocioeconomiciPfErroriPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfErroriRepository());
        BDDMockito.when(datiSocioeconomiciPfPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciPfRepository());
        BDDMockito.when(datiSocioeconomiciPersistenceService.getRepository()).thenReturn(this.getUplCrmDatiSocioeconomiciRepository());

        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn((container.getUplCrmAnagraficaAgenzia()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn((container.getUplCrmAnagrafichePf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn((container.getUplCrmAnagrafichePg()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn((container.getUplCrmAnagRel()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn((container.getUplCrmAnagraficaIdentita()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn((container.getUplCrmAnomaleAnagrafiche()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn((container.getUplCrmDatiSocioeconomici()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn((container.getUplCrmDatiSocioeconomiciPf()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn((container.getUplCrmDatiSocioeconomiciPfErrori()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn((container.getUplCrmDocumenti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn((container.getUplCrmRecapiti()));
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn((container.getUplCrmIndirizzi()));

        // when
        var result = anagraficaPersistenceService.updateDatiSocioeconomiciPfErrori(uplCrmAnagraficaContainer);
        //then
        assertNull(result, "inserted object shouldn't be null");
    }
}

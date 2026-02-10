package it.unipol.crm.anagrafica.gestione.service;

import it.unipol.crm.anagrafica.gestione.config.DatabaseConfiguration;
import it.unipol.crm.anagrafica.gestione.config.mapper.AnagraficaEntitiesUpdateMapper;
import it.unipol.crm.anagrafica.gestione.entity.code.*;
import it.unipol.crm.anagrafica.gestione.model.UplCrmAnagraficaContainer;
import it.unipol.crm.anagrafica.gestione.service.entities.*;
import lombok.Getter;
import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.MissingResourceException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = DatabaseConfiguration.class)
@EnableAutoConfiguration
@Getter
public class AnagraficaPersistenceServiceModifyingDataTest {
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
    private AnagraficaPersistenceServiceModifingData anagraficaPersistenceService;
    @Mock
    private UplCrmAnagraficaContainer uplCrmAnagraficaContainer;
    @Mock
    public AnagraficaEntitiesUpdateMapper anagraficaEntitiesUpdateMapper;
    @Mock
    private AnagraficaPersistenceServiceGettingData anagraficaPersistenceServiceGettingData;

    @Test
    public void shouldInsertUpdateAnagraficaRequestContainerObjectIntoDatabaseTables() {

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
        UplCrmAnagraficaContainer result = anagraficaPersistenceService.insertDataFromUpdateAnagraficaRequestIntoDatabaseTables(uplCrmAnagraficaContainer);
        //then
        assertNotNull(result, "inserted object shouldn't be null");
    }

    @Test
    public void shouldInsertAnagraficaContainerObjectIntoDatabaseTables() {
        // given
        UplCrmAnagraficaContainer container = new UplCrmAnagraficaContainer();
        container.setUplCrmAnagrafiche(new UplCrmAnagrafiche());
        container.getUplCrmAnagrafiche().setIdSoggetto(BigInteger.ONE);
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafiche()).thenReturn(container.getUplCrmAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaAgenzia()).thenReturn(new UplCrmAnagraficaAgenzia());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePf()).thenReturn(new UplCrmAnagrafichePf());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagrafichePg()).thenReturn(new UplCrmAnagrafichePg());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagRel()).thenReturn(new UplCrmAnagRel());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnagraficaIdentita()).thenReturn(new UplCrmAnagraficaIdentita());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmAnomaleAnagrafiche()).thenReturn(new UplCrmAnomalieAnagrafiche());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomici()).thenReturn(new UplCrmDatiSocioeconomici());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPf()).thenReturn(new UplCrmDatiSocioeconomiciPf());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDatiSocioeconomiciPfErrori()).thenReturn(new UplCrmDatiSocioeconomiciPfErrori());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmDocumenti()).thenReturn(new UplCrmDocumenti());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmRecapiti()).thenReturn(new UplCrmRecapiti());
        BDDMockito.when(uplCrmAnagraficaContainer.getUplCrmIndirizzi()).thenReturn(new UplCrmIndirizzi());

        val expected = uplCrmAnagraficaContainer;
        expected.setUplCrmAnagrafiche(new UplCrmAnagrafiche());
        expected.getUplCrmAnagrafiche().setIdSoggetto(BigInteger.ONE);
        expected.setUplCrmRecapiti(new UplCrmRecapiti());
        expected.setUplCrmDocumenti(new UplCrmDocumenti());
        expected.setUplCrmAnagRel(new UplCrmAnagRel());

        // when
        UplCrmAnagraficaContainer result = anagraficaPersistenceService.insertDataFromCreaAnagraficaRequestIntoDatabaseTables(uplCrmAnagraficaContainer);
        //then
        assertNotNull(result, "inserted object shouldn't be null");
        Assertions.assertEquals(result, expected);
    }

    @Test
    public void shouldCheckAndInsertAnagraficaIdentitaEmptyInput() {
        anagraficaPersistenceService.checkAndInsertAnagraficaIdentita(uplCrmAnagraficaContainer);

    }

    @Test
    public void shouldCheckAndInsertAnagraficheEmptyInput() {
       Assertions.assertThrows(MissingResourceException.class,()->anagraficaPersistenceService.checkAndInsertAnagrafiche(uplCrmAnagraficaContainer));

    }

    @Test
    public void shouldCheckAndInsertAnagrafichePfEmptyInput() {
        Assertions.assertThrows(MissingResourceException.class,()->anagraficaPersistenceService.checkAndInsertAnagrafichePf(uplCrmAnagraficaContainer));

    }

    @Test
    public void shouldCheckAndInsertAnagrafichePgEmptyInput() {
        Assertions.assertThrows(MissingResourceException.class,()->anagraficaPersistenceService.checkAndInsertAnagrafichePg(uplCrmAnagraficaContainer));

    }

    @Test
    public void shouldCheckAndInsertAnagRelEmptyInput() {
        anagraficaPersistenceService.checkAndInsertAnagRel(uplCrmAnagraficaContainer);

    }

    @Test
    public void shouldCheckAndInsertAnagraficaAgenziaEmptyInput() {
        anagraficaPersistenceService.checkAndInsertAnagraficaAgenzia(uplCrmAnagraficaContainer);

    }

    @Test
    public void shouldCheckAndInsertIndirizziEmptyInput() {
        anagraficaPersistenceService.checkAndInsertIndirizzi(uplCrmAnagraficaContainer);

    }

    @Test
    public void shouldCheckAndInsertRecapitiEmptyInput() {
        anagraficaPersistenceService.checkAndInsertRecapiti(uplCrmAnagraficaContainer);

    }

    @Test
    public void shouldCheckAndInsertDocumentiEmptyInput() {
        anagraficaPersistenceService.checkAndInsertDocumenti(uplCrmAnagraficaContainer);

    }

    @Test
    public void shouldCheckAndInsertDatiSocioeconomiciEmptyInput() {
        anagraficaPersistenceService.checkAndInsertDatiSocioeconomici(uplCrmAnagraficaContainer);

    }

    @Test
    public void shouldCheckAndInsertDatiSocioeconomiciPfEmptyInput() {
        anagraficaPersistenceService.checkAndInsertDatiSocioeconomiciPf(uplCrmAnagraficaContainer);

    }

    @Test
    public void shouldCheckAndInsertDatiSocioeconomiciPfErroriEmptyInput() {
        anagraficaPersistenceService.checkAndInsertDatiSocioeconomiciPfErrori(uplCrmAnagraficaContainer);

    }
}

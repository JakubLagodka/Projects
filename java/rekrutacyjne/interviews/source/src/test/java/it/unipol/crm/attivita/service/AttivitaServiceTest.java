package it.unipol.crm.attivita.service;

import it.unipol.crm.attivita.config.ModelMapperConfiguration;
import it.unipol.crm.attivita.persistence.entity.attivita.UplCrmAttivita;
import it.unipol.crm.attivita.persistence.entity.attivita.UplCrmAttivitaRepository;
import it.unipol.crm.attivita.persistence.exceptions.NuovaAttivitaException;
import it.unipol.crm.attivita.persistence.exceptions.NuovaAttivitaValidationException;
import it.unipol.crm.attivita.persistence.model.Attivita;
import it.unipol.crm.attivita.persistence.model.NuovaAttivita;
import it.unipol.crm.attivita.persistence.service.UplCrmAttivitaPersistenceService;
import it.unipol.crm.attivita.util.UserUtil;
import lombok.val;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.security.oauth2.jwt.Jwt;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AttivitaServiceTest {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Mock
    private UplCrmAttivitaRepository repository;

    @Mock
    private UplCrmAttivitaPersistenceService persistenceService;

    @Spy
    private ModelMapper modelMapper = new ModelMapper();

    @Spy
    private UserUtil userUtil;

    @InjectMocks
    private AttivitaService fixture = new AttivitaService();

    @Before
    public void init(){
        reset(repository, persistenceService);

        ModelMapperConfiguration.configureMappings(modelMapper);
    }

    @Test
    public void shouldReturnAttivitaWhenFound() throws ParseException {
        //given
        val attivita = new UplCrmAttivita();
        setUplCrmAttivitaFields(attivita, BigInteger.ONE);

        given(repository.findById(BigInteger.ONE)).willReturn(Optional.of(attivita));

        //when
        val actualOptional = fixture.getAttivita(BigInteger.ONE);

        //then
        assertNotNull(actualOptional);
        assertTrue("Actual should be present", actualOptional.isPresent());
        val actual = actualOptional.get();
        assertAttivitaFields(attivita, actual);
    }

    @Test
    public void shouldReturnEmptyWhenNotFound(){
        //given
        given(repository.findById(BigInteger.valueOf(404))).willReturn(Optional.empty());

        //when
        val actualOptional = fixture.getAttivita(BigInteger.valueOf(404));

        //then
        assertNotNull(actualOptional);
        assertTrue("Optional should be empty", actualOptional.isEmpty());
    }

    @Test
    public void shouldDeleteAttivita() throws ParseException {
        //given
        val attivita = new UplCrmAttivita();
        setUplCrmAttivitaFields(attivita, BigInteger.valueOf(100));

        given(repository.findById(BigInteger.valueOf(100))).willReturn(Optional.of(attivita));

        //when
        fixture.deleteAttivita(BigInteger.valueOf(100));

        //then
        verify(repository, times(1)).delete(attivita);
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementWhenDeleteAttivitaWithNoId() {

        // when
        fixture.deleteAttivita(new BigInteger("0"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentWhenUpdateAttivitaWithNoId(){

        //when
        fixture.updateAttivita(new Attivita(), "test", "test");
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementExceptionWhenUpdateAttivitaNotFound(){
        //given
        val request = new Attivita();
        request.setId(405l);

        given(repository.findById(BigInteger.valueOf(405))).willReturn(Optional.empty());

        //when
        fixture.updateAttivita(request, "test", "test");
    }

    @Test
    public void shouldUpdateAttivita() throws ParseException {
        //given
        val request = new Attivita();
        request.setId(1000l);
        request.setFlussoChiusura(1001);
        request.setCompagnia("new compagnia");

        val uplCrmAttivita = setUplCrmAttivitaFields(new UplCrmAttivita(), BigInteger.valueOf(1000));

        given(repository.findById(BigInteger.valueOf(1000))).willReturn(Optional.of(uplCrmAttivita));
        given(repository.save((any()))).willAnswer(a -> a.getArgument(0));

        //when
        val actual = fixture.updateAttivita(request, "test", "test");

        //then
        assertAttivitaFields(uplCrmAttivita, actual);
        assertEquals(Integer.valueOf(1001), actual.getFlussoChiusura());
        assertEquals("new compagnia", actual.getCompagnia());
        assertNotNull(actual.getDataUltimoAggiornamento());
    }

    @Test
    public void shouldReturnNullWhenAddingAttivitaWithNullRequest() throws NuovaAttivitaValidationException, NuovaAttivitaException, ParseException {
        assertEquals(0, fixture.addAttivita(null, null, null, null).size());
    }

    @Test
    public void shouldReturnEmptyListWhenAddingAttivitaWithConfiguratoreWithNullRequest() throws NuovaAttivitaValidationException, NuovaAttivitaException, ParseException {
        assertEquals(0, fixture.addAttivita(null, null, null, null).size());
    }

    @Test
    public void shouldAddAttivita() throws NuovaAttivitaValidationException {

        UplCrmAttivita crmAttivita = new UplCrmAttivita();
        crmAttivita.setAttivitaId(new BigInteger("1000"));

        List<UplCrmAttivita> createdList = new ArrayList<>();
        createdList.add(crmAttivita);

        Jwt jwt = mock(Jwt.class);

        when(persistenceService.insertNuovaAttivita(any(),  anyString(), anyString(), anyString())).thenReturn(createdList);

        val actual = fixture.addAttivita(new NuovaAttivita(), "", "", "token");

        assertEquals(Long.valueOf("1000"), actual.get(0).getId());
    }

    @Test
    public void shouldAddAttivitaList() throws NuovaAttivitaValidationException {

        UplCrmAttivita crmAttivita = new UplCrmAttivita();
        crmAttivita.setAttivitaId(new BigInteger("1000"));
        when(persistenceService.insertNuovaAttivita(any(),  anyString(), anyString(), anyString())).thenReturn(List.of(crmAttivita));

        Jwt jwt = mock(Jwt.class);

        val actual = fixture.addAttivita(new NuovaAttivita(), "", "", "token");

        assertEquals(1, actual.size());
    }

    private void assertAttivitaFields(UplCrmAttivita attivita, Attivita actual) {
        assertEquals(BigInteger.valueOf(actual.getId()), attivita.getAttivitaId());
        assertEquals(actual.getSistemaId(), attivita.getSistemaId());
        assertEquals(actual.getTipoAttivitaId(), (Long) attivita.getTipoAttivitaId().longValue());
        assertEquals(actual.getDominio(), (Long) attivita.getDominio().longValue());
        assertEquals(actual.getCodice(), (Long) attivita.getCodice().longValue());
        assertEquals(actual.getAttivitaCliente(), attivita.getAttivitaCliente());
        assertEquals(actual.getDataCreazione(), attivita.getCreazioneDt().toLocalDateTime());
        assertEquals(actual.getCreatoDaTipo(), attivita.getCreatoDaTipo());
        assertEquals(actual.getCreatoDaUtente(), attivita.getCreatoDaUtente());
        assertEquals(actual.getCreatoDaNominativo(), attivita.getCreatoDaNominativo());
        assertEquals(actual.getCompagnia(), attivita.getCompagnia());
        assertEquals(actual.getAgenziaMadre(), attivita.getAgenziaMadre());
        assertEquals(actual.getAgenziaFiglia(), attivita.getAgenziaFiglia());
        assertEquals(actual.getCodiceFiscaleCliente(), attivita.getCfpivaCliente());
        assertEquals(actual.getContId(), (Long) attivita.getContId().longValue());
        assertEquals(actual.getContestoIdentificativo(), attivita.getContextId());
        assertEquals(actual.getContestoEntita(), attivita.getContextEntity());
        assertEquals(actual.getContestoChiavePrimaria(), (Long) attivita.getContextInstancePk().longValue());
        assertEquals(actual.getTipoIntegrazione(), attivita.getTipoIntegrazione());
        assertEquals(actual.getFlussoChiusura(), attivita.getFlussoChiusura());
        assertEquals(actual.getCancellazioneUtente(), attivita.getCancellazioneUtente());
        assertEquals(actual.getCancellazioneCreatore(), attivita.getCancellazioneCreatore());
        assertEquals(actual.getCancellazioneResponsabile(), attivita.getCancellazioneResponsabile());
        assertEquals(actual.getTipologiaBloccabile(), attivita.getTipologiaBloccabile());
        assertEquals(actual.getRegolaAssegnazione(), attivita.getRegolaAssegnazione());
        assertEquals(actual.getPriorita(), attivita.getPriorita());
        assertEquals(actual.getCodiceStatoAttivita(), (Long) attivita.getAttivitaStTpCd().longValue());
        assertEquals(actual.getDataAvvio(), attivita.getAvvioDt().toLocalDateTime());
        assertEquals(actual.getDataScadenza(), attivita.getScadenzaDt().toLocalDateTime());
        assertEquals(actual.getDataCompletamento(), attivita.getCompletataDt().toLocalDateTime());
        assertEquals(actual.getDataFine(), attivita.getFineDt().toLocalDateTime());
        assertEquals(actual.getRiapertura(), attivita.getRiapertura());
        assertEquals(actual.getDataRiapertura(), attivita.getRiaperturaDt().toLocalDateTime());
        assertEquals(actual.getEscalation(), attivita.getEscalation());
        assertEquals(actual.getDataEscalation(), attivita.getEscalationDt().toLocalDateTime());
        assertEquals(actual.getAssegnatore(), attivita.getAssegnatore());
        assertEquals(actual.getAssegnatoreDescrizione(), attivita.getAssegnatoreDesc());
        assertEquals(actual.getAssegnazione(), attivita.getAssegnazione());
        assertEquals(actual.getAssegnatarioDescrizione(), attivita.getAssegnatarioDesc());
        assertEquals(actual.getInLavorazioneDaCF(), attivita.getInLavorazioneDaCF());
        assertEquals(actual.getInLavorazioneDaNominativo(), attivita.getInLavorazioneDaNominativo());
        assertEquals(actual.getInLavorazioneDaData(), attivita.getInLavorazioneDaDt().toLocalDateTime());
        assertEquals(actual.getFlagAnnotazione(), attivita.getFlagAnnotazione());
        assertEquals(actual.getAnnotazione(), attivita.getAnnotazione());
        assertEquals(actual.getChiusaScaduta(), attivita.getChiusaScaduta());
        assertEquals(actual.getCipSubagente(), attivita.getCipSub());
        assertEquals(actual.getCipProduttore(), attivita.getCipProd());
        assertEquals(actual.getGruppo(), attivita.getGruppo());
        assertEquals(actual.getDelegaContactCentre(), attivita.getDelegaCc());
        assertEquals(actual.getDelegaContactCentreAbilitata(), attivita.getDelegaCcAbilitata());
        assertEquals(actual.getDelegaContactCentreIniziale(), attivita.getDelegaCcIniziale());
        assertEquals(actual.getGestioneMulticanale(), attivita.getGestioneMc());
        assertEquals(actual.getIdProcesso(), (Long) attivita.getIdProcesso().longValue());
        assertEquals(actual.getIndicatoreIcona(), attivita.getIndicatoreIcona());
        assertEquals(actual.getChiusuraBatch(), attivita.getChiusuraBatch());
        assertEquals(actual.getRicontattoNumero(), attivita.getNumRicontatto());
        assertEquals(actual.getRicontattoFasciaOraria(), attivita.getFasciaOrariaRicontatto());
        assertEquals(actual.getMotivoRichiestaRiscatto(), attivita.getMotivRichiestaRiscatto());
        assertEquals(actual.getDataSospensioneRiattivazionePolizza(), attivita.getDataSospRiattPolizza().toLocalDateTime());
        assertEquals(actual.getUtenteUltimoAggiornamento(), attivita.getLastUpdateUser());
        assertEquals(actual.getDataUltimoAggiornamento(), attivita.getLastUpdateDt().toLocalDateTime());
    }

    private UplCrmAttivita setUplCrmAttivitaFields(UplCrmAttivita attivita, BigInteger attivitaId) throws ParseException {
        attivita.setAttivitaId(attivitaId);
        attivita.setSistemaId("2");
        attivita.setTipoAttivitaId(BigInteger.valueOf(3));
        attivita.setDominio(BigInteger.valueOf(4));
        attivita.setCodice(BigInteger.valueOf(5));
        attivita.setAttivitaCliente("Attivita Cliente");
        attivita.setCreazioneDt(new Timestamp(sdf.parse("2001-01-01 01:01:01").getTime()));
        attivita.setCreatoDaTipo("Creato Da Tipo");
        attivita.setCreatoDaUtente("Creato Da Utente");
        attivita.setCreatoDaNominativo("Creato Da Nominativo");
        attivita.setCompagnia("Compagnia");
        attivita.setAgenziaMadre("Agenzia Madre");
        attivita.setAgenziaFiglia("Agenzia Figlia");
        attivita.setCfpivaCliente("Cfpiva Cliente");
        attivita.setContId(BigInteger.valueOf(6));
        attivita.setContextId("Context Id");
        attivita.setContextEntity("Context Entity");
        attivita.setContextInstancePk(BigInteger.valueOf(7));
        attivita.setTipoIntegrazione(8);
        attivita.setFlussoChiusura(9);
        attivita.setCancellazioneUtente("Cancellazione Utente");
        attivita.setCancellazioneCreatore("Cancellazione Creatore");
        attivita.setCancellazioneResponsabile("ancellazione Responsabile");
        attivita.setTipologiaBloccabile("Tipologia Bloccabile");
        attivita.setRegolaAssegnazione("Regola Assegnazione");
        attivita.setPriorita("Priorita");
        attivita.setAttivitaStTpCd(BigInteger.TEN);
        attivita.setAvvioDt(new Timestamp(sdf.parse("2002-02-02 02:02:02").getTime()));
        attivita.setScadenzaDt(new Timestamp(sdf.parse("2003-03-03 03:03:03").getTime()));
        attivita.setCompletataDt(new Timestamp(sdf.parse("2004-04-04 04:04:04").getTime()));
        attivita.setFineDt(new Timestamp(sdf.parse("2005-05-05 05:05:05").getTime()));
        attivita.setRiapertura(11);
        attivita.setRiaperturaDt(new Timestamp(sdf.parse("2006-06-06 06:06:06").getTime()));
        attivita.setEscalation("Escalation");
        attivita.setEscalationDt(new Timestamp(sdf.parse("2007-07-07 07:07:07").getTime()));
        attivita.setAssegnatore("Assegnatore");
        attivita.setAssegnatoreDesc("Assegnatore desc");
        attivita.setAssegnazione("Assegnazione");
        attivita.setAssegnatario("Assegnatario");
        attivita.setAssegnatarioDesc("Assegnatario desc");
        attivita.setInLavorazioneDaCF("In Lavorazione Da CF");
        attivita.setInLavorazioneDaNominativo("In Lavorazione Da Nominativo");
        attivita.setInLavorazioneDaDt(new Timestamp(sdf.parse("2008-08-08 08:08:08").getTime()));
        attivita.setFlagAnnotazione("Flag Annotazione");
        attivita.setAnnotazione("Annotazione");
        attivita.setChiusaScaduta("Chiusa Scaduta");
        attivita.setCipSub("Cip Sub");
        attivita.setCipProd("Cip Prod");
        attivita.setGruppo("Gruppo");
        attivita.setDelegaCc("Delega Cc");
        attivita.setDelegaCcAbilitata("Delega Cc Abilitata");
        attivita.setDelegaCcIniziale("Delega Cc Iniziale");
        attivita.setGestioneMc("Gestione Mc");
        attivita.setIdProcesso(BigInteger.valueOf(12));
        attivita.setIndicatoreIcona(13);
        attivita.setChiusuraBatch("Chiusura Batch");
        attivita.setNumRicontatto("Num Ricontatto");
        attivita.setFasciaOrariaRicontatto("Fascia Oraria Ricontatto");
        attivita.setMotivRichiestaRiscatto("Motiv Richiesta Riscatto");
        attivita.setDataSospRiattPolizza(new Timestamp(sdf.parse("2009-09-09 09:09:09").getTime()));
        attivita.setLastUpdateUser("Last Update User");
        attivita.setLastUpdateDt(new Timestamp(sdf.parse("2010-10-10 10:10:10").getTime()));

        return attivita;
    }
}

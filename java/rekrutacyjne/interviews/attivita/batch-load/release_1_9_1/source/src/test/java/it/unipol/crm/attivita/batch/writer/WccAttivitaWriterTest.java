package it.unipol.crm.attivita.batch.writer;

import it.unipol.crm.attivita.batch.config.ModelMapperConfig;
import it.unipol.crm.attivita.batch.model.WccAttivita;
import it.unipol.crm.attivita.batch.model.WccAttivitaRepository;
import it.unipol.crm.attivita.batch.stsclient.model.StsResponse;
import it.unipol.crm.attivita.batch.stsclient.service.StsTokenService;
import it.unipol.crm.attivita.persistence.entity.attivita.UplCrmAttivita;
import it.unipol.crm.attivita.persistence.entity.attivita.UplCrmAttivitaRepository;
import it.unipol.crm.attivita.persistence.exceptions.NuovaAttivitaValidationException;
import it.unipol.crm.attivita.persistence.model.NuovaAttivita;
import it.unipol.crm.attivita.persistence.service.UplCrmAttivitaPersistenceService;
import lombok.val;
import org.assertj.core.util.Lists;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WccAttivitaWriterTest {

    private String updateUser = "test-batch";

    @Mock
    private UplCrmAttivitaPersistenceService persistenceService;

    @Mock
    private UplCrmAttivitaRepository uplCrmAttivitaRepository;

    @Mock
    private WccAttivitaRepository wccAttivitaRepository;

    @Mock
    private StsTokenService stsTokenService;

    @Spy
    protected ModelMapper mapper;

    @InjectMocks
    private WccAttivitaWriter fixture;

    @Before
    public void init(){
        Mockito.reset(persistenceService, uplCrmAttivitaRepository, wccAttivitaRepository, stsTokenService);

        fixture.setMapper(ModelMapperConfig.configureMapper(new ModelMapper()));
        fixture.setUpdateUser(updateUser);
    }

    @Test
    public void shouldInsertAttivita() throws Exception {
        //given
        WccAttivita wccAttivita = new WccAttivita();
        wccAttivita.setRequestId(new BigInteger("1"));
        wccAttivita.setTipoOperazione("I");
        wccAttivita.setFlgCaricato(0);
        wccAttivita.setTipoAttivitaId(BigInteger.ONE);
        wccAttivita.setCreatoDaTipo("T");
        wccAttivita.setCreatoDaUtente("Test");
        wccAttivita.setCreatoDaNominativo("JUnit");
        wccAttivita.setCompagnia("1");
        wccAttivita.setAgenziaMadre("1");
        wccAttivita.setAgenziaFiglia("1");
        wccAttivita.setContextId("ContextId");

        UplCrmAttivita uplCrmAttivita = mapper.map(wccAttivita, UplCrmAttivita.class);
        uplCrmAttivita.setAttivitaId(BigInteger.ONE);

        List<UplCrmAttivita> createdAttList = new ArrayList<>();
        createdAttList.add(uplCrmAttivita);

        given(persistenceService.insertNuovaAttivita(any(), any(), any(), any())).willReturn(createdAttList);

        val stsResp = new StsResponse();
        stsResp.setToken("test_token");
        given(stsTokenService.getToken(any())).willReturn(stsResp);

        //when
        fixture.write(Lists.newArrayList(wccAttivita));

        //then
        ArgumentCaptor<NuovaAttivita> nuovaAttivitaArgumentCaptor = ArgumentCaptor.forClass(NuovaAttivita.class);
        verify(persistenceService, times(1)).insertNuovaAttivita(nuovaAttivitaArgumentCaptor.capture(), any(), any(), any());
        NuovaAttivita actual = nuovaAttivitaArgumentCaptor.getValue();
        Assert.assertNotNull(actual);
        assertEquals("ContextId", actual.getContestoIdentificativo());

        verify(wccAttivitaRepository, times(1)).save(any());
        assertEquals(Integer.valueOf(2), wccAttivita.getFlgCaricato());
        assertNotNull(wccAttivita.getUpdTimestamp());
        assertEquals(new BigInteger("1"), wccAttivita.getAttivitaId());
        assertNull(actual.getIdProcesso());
    }

    @Test
    public void shouldUpdateAttivita() throws Exception {
        //given

        Timestamp updTimestamp = new Timestamp(new Date().getTime());

        WccAttivita wccAttivita = new WccAttivita();
        wccAttivita.setRequestId(new BigInteger("2"));
        wccAttivita.setTipoOperazione("U");
        wccAttivita.setFlgCaricato(0);
        wccAttivita.setTipoAttivitaId(BigInteger.TWO);
        wccAttivita.setCreatoDaTipo("T");
        wccAttivita.setCreatoDaUtente("Test 2");
        wccAttivita.setCreatoDaNominativo("JUnit 2");
        wccAttivita.setCompagnia("2");
        wccAttivita.setAgenziaMadre("2");
        wccAttivita.setAgenziaFiglia("2");
        wccAttivita.setAttivitaId(BigInteger.TWO);
        wccAttivita.setUpdTimestamp(updTimestamp);

        UplCrmAttivita oldUplCrmAttivita = mapper.map(wccAttivita, UplCrmAttivita.class);
        oldUplCrmAttivita.setCreatoDaTipo("not T");
        wccAttivita.setCreatoDaUtente("not Test 2");
        wccAttivita.setCreatoDaNominativo("not JUnit 2");
        wccAttivita.setCompagnia("not 2");
        wccAttivita.setAgenziaMadre("not 2");
        wccAttivita.setAgenziaFiglia("not 2");

        given(uplCrmAttivitaRepository.findById(BigInteger.TWO)).willReturn(Optional.of(oldUplCrmAttivita));
        given(uplCrmAttivitaRepository.save(any())).willAnswer(a -> a.getArgument(0));

        //when
        fixture.write(Lists.newArrayList(wccAttivita));

        //then
        verify(uplCrmAttivitaRepository, times(1)).save(oldUplCrmAttivita);
        assertEquals(updateUser, oldUplCrmAttivita.getLastUpdateUser());
        assertEquals(wccAttivita.getCreatoDaUtente(), oldUplCrmAttivita.getCreatoDaUtente());
        assertEquals(wccAttivita.getCreatoDaNominativo(), oldUplCrmAttivita.getCreatoDaNominativo());
        assertEquals(wccAttivita.getCompagnia(), oldUplCrmAttivita.getCompagnia());
        assertEquals(wccAttivita.getAgenziaMadre(), oldUplCrmAttivita.getAgenziaMadre());
        assertEquals(wccAttivita.getAgenziaFiglia(), oldUplCrmAttivita.getAgenziaFiglia());

        verify(wccAttivitaRepository, times(1)).save(any());
        assertEquals(Integer.valueOf(2), wccAttivita.getFlgCaricato());
        assertNotNull(wccAttivita.getUpdTimestamp());
        assertEquals(new BigInteger("2"), wccAttivita.getAttivitaId());
    }

    @Test
    public void shouldNotUpdateAttivitaWhenDifferentUpdateDates() throws Exception {
        //given
        WccAttivita wccAttivita = new WccAttivita();
        wccAttivita.setRequestId(new BigInteger("3"));
        wccAttivita.setTipoOperazione("U");
        wccAttivita.setFlgCaricato(0);
        wccAttivita.setTipoAttivitaId(new BigInteger("3"));
        wccAttivita.setCreatoDaTipo("T");
        wccAttivita.setCreatoDaUtente("Test 3");
        wccAttivita.setCreatoDaNominativo("JUnit 3");
        wccAttivita.setCompagnia("3");
        wccAttivita.setAgenziaMadre("3");
        wccAttivita.setAgenziaFiglia("3");
        wccAttivita.setAttivitaId(new BigInteger("3"));
        wccAttivita.setUpdTimestamp(new Timestamp(new Date().getTime()));

        UplCrmAttivita oldUplCrmAttivita = mapper.map(wccAttivita, UplCrmAttivita.class);
        oldUplCrmAttivita.setLastUpdateDt(new Timestamp(0));

        given(uplCrmAttivitaRepository.findById(new BigInteger("3"))).willReturn(Optional.of(oldUplCrmAttivita));

        //when
        fixture.write(Lists.newArrayList(wccAttivita));

        //then
        verify(uplCrmAttivitaRepository, times(0)).save(oldUplCrmAttivita);

        verify(wccAttivitaRepository, times(1)).save(any());
        assertEquals(Integer.valueOf(5), wccAttivita.getFlgCaricato());
        assertNotNull(wccAttivita.getUpdTimestamp());
        assertEquals(new BigInteger("3"), wccAttivita.getAttivitaId());
    }


    @Test
    public void shouldNotUpdateAttivitaWhenNotFound() throws Exception {
        //given
        WccAttivita wccAttivita = new WccAttivita();
        wccAttivita.setRequestId(new BigInteger("4"));
        wccAttivita.setTipoOperazione("U");
        wccAttivita.setFlgCaricato(0);
        wccAttivita.setTipoAttivitaId(new BigInteger("4"));
        wccAttivita.setCreatoDaTipo("T");
        wccAttivita.setCreatoDaUtente("Test 4");
        wccAttivita.setCreatoDaNominativo("JUnit 4");
        wccAttivita.setCompagnia("4");
        wccAttivita.setAgenziaMadre("4");
        wccAttivita.setAgenziaFiglia("4");
        wccAttivita.setAttivitaId(new BigInteger("4"));
        Timestamp lastUpdateDt = new Timestamp(new Date().getTime());
        wccAttivita.setUpdTimestamp(lastUpdateDt);

        UplCrmAttivita oldUplCrmAttivita = mapper.map(wccAttivita, UplCrmAttivita.class);
        oldUplCrmAttivita.setLastUpdateDt(lastUpdateDt);

        given(uplCrmAttivitaRepository.findById(new BigInteger("4"))).willReturn(Optional.empty());

        //when
        fixture.write(Lists.newArrayList(wccAttivita));

        //then
        verify(uplCrmAttivitaRepository, times(0)).save(oldUplCrmAttivita);

        verify(wccAttivitaRepository, times(1)).save(any());
        assertEquals(Integer.valueOf(3), wccAttivita.getFlgCaricato());
        assertNotNull(wccAttivita.getUpdTimestamp());
        assertEquals(new BigInteger("4"), wccAttivita.getAttivitaId());
    }

    @Test
    public void shouldSetCustomErrorCodeWhenBatchAttivitaException() throws Exception {
        //given
        WccAttivita wccAttivita = new WccAttivita();
        wccAttivita.setRequestId(new BigInteger("1"));
        wccAttivita.setTipoOperazione("I");
        wccAttivita.setFlgCaricato(0);
        wccAttivita.setTipoAttivitaId(BigInteger.ONE);
        wccAttivita.setCreatoDaTipo("T");
        wccAttivita.setCreatoDaUtente("Test");
        wccAttivita.setCreatoDaNominativo("JUnit");
        wccAttivita.setCompagnia("1");
        wccAttivita.setAgenziaMadre("1");
        wccAttivita.setAgenziaFiglia("1");
        wccAttivita.setContextId("ContextId");

        UplCrmAttivita uplCrmAttivita = mapper.map(wccAttivita, UplCrmAttivita.class);
        uplCrmAttivita.setAttivitaId(BigInteger.ONE);

        val stsResp = new StsResponse();
        stsResp.setToken("test_token");
        given(stsTokenService.getToken(any())).willReturn(stsResp);

        given(persistenceService.insertNuovaAttivita(any(), any(), any(), any())).willThrow(
                new NuovaAttivitaValidationException("Cutom exception", 1234));

        //when
        fixture.write(Lists.newArrayList(wccAttivita));

        //then
        verify(uplCrmAttivitaRepository, times(0)).save(any());

        verify(wccAttivitaRepository, times(1)).save(any());
        assertEquals(Integer.valueOf(1234), wccAttivita.getFlgCaricato());
        assertNotNull(wccAttivita.getUpdTimestamp());
    }
}
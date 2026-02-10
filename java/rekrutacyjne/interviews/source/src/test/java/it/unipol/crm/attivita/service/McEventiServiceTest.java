package it.unipol.crm.attivita.service;

import it.unipol.crm.attivita.config.ModelMapperConfiguration;
import it.unipol.crm.attivita.model.McEventi;
import it.unipol.crm.attivita.persistence.entity.mceventi.UplCrmMcEventi;
import it.unipol.crm.attivita.persistence.entity.mceventi.UplCrmMcEventiRepository;
import it.unipol.crm.attivita.persistence.service.UplCrmMcEventiPersistenceService;
import it.unipol.crm.attivita.util.UserUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class McEventiServiceTest {

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    McEventi mcEventiNewValues;
    McEventi existing;

    @Mock
    UplCrmMcEventiRepository repository;

    @Mock
    UplCrmMcEventiPersistenceService persistenceService;

    @Spy
    UserUtil userUtil;

    @InjectMocks
    McEventiService service;

    @Spy
    ModelMapper modelMapper;

    @Before
    public void init(){
        reset(repository, persistenceService);

        ModelMapperConfiguration.configureMappings(modelMapper);
    }

    private void prepareVariables() throws ParseException {

        mcEventiNewValues = new McEventi();
        mcEventiNewValues.setMcEventiId(BigInteger.valueOf(723952095513575335l));
        mcEventiNewValues.setEntityName("CAMPAIGNASSOCIATtest");
        mcEventiNewValues.setNota("CONTATTATO-test");
        mcEventiNewValues.setCanaleTpCd(BigInteger.ONE);
        mcEventiNewValues.setLastUpdateUser("junit");

        existing = new McEventi();
        existing.setMcEventiId(BigInteger.valueOf(723952095513575335l));
        existing.setEntityName("CAMPAIGNASSOCIAT");
        existing.setIdProcesso(null);
        existing.setIdAttivita(BigInteger.valueOf(418852093423861702l));
        existing.setDataOperazione(new Timestamp(sdf.parse("2018-03-13 00:00:00").getTime()));
        existing.setEsitoContattoTpCd(BigInteger.TWO);
        existing.setNota("CONTATTATO");
        existing.setSottoEsitoContattoTpCd(null);
        existing.setCreatoDaUtente("139214AI");
        existing.setCreatoDaNominativo("CITTADINO SILVIA");
        existing.setCanaleTpCd(BigInteger.TWO);
        existing.setDataRecall(null);
        existing.setEntityId(BigInteger.valueOf(359552089749407135l));
        existing.setAgeEvento(null);
        existing.setLastUpdateUser("CRMMULTICANALITA");
    }

    @Test
    public void shouldUpdateMcEventi() throws ParseException {

        // given
        prepareVariables();

        final UplCrmMcEventi existingUplCrmMcEventi = modelMapper.map(existing, UplCrmMcEventi.class);

        BDDMockito.given(repository.findById(BigInteger.valueOf(723952095513575335l))).willReturn(Optional.of(existingUplCrmMcEventi));

        // when
        final McEventi updatedMcEventi = service.updateMcEventi(mcEventiNewValues, "test", "test");

        // then
        Assert.assertEquals("value of this field should NOT be updated", updatedMcEventi.getMcEventiId(), existing.getMcEventiId());
        Assert.assertEquals("value of this field should be updated", updatedMcEventi.getEntityName(), mcEventiNewValues.getEntityName());
        Assert.assertEquals("value of this field should NOT be updated", updatedMcEventi.getIdProcesso(), existing.getIdProcesso());
        Assert.assertEquals("value of this field should NOT be updated", updatedMcEventi.getIdAttivita(), existing.getIdAttivita());
        Assert.assertEquals("value of this field should NOT be updated", updatedMcEventi.getDataOperazione(), existing.getDataOperazione());
        Assert.assertEquals("value of this field should NOT be updated", updatedMcEventi.getEsitoContattoTpCd(), existing.getEsitoContattoTpCd());
        Assert.assertEquals("value of this field should be updated", updatedMcEventi.getNota(), mcEventiNewValues.getNota());
        Assert.assertEquals("value of this field should NOT be updated", updatedMcEventi.getSottoEsitoContattoTpCd(), existing.getSottoEsitoContattoTpCd());
        Assert.assertEquals("value of this field should NOT be updated", updatedMcEventi.getCreatoDaUtente(), existing.getCreatoDaUtente());
        Assert.assertEquals("value of this field should NOT be updated", updatedMcEventi.getCreatoDaNominativo(), existing.getCreatoDaNominativo());
        Assert.assertEquals("value of this field should be updated", updatedMcEventi.getCanaleTpCd(), mcEventiNewValues.getCanaleTpCd());
        Assert.assertEquals("value of this field should NOT be updated", updatedMcEventi.getDataRecall(), existing.getDataRecall());
        Assert.assertEquals("value of this field should NOT be updated", updatedMcEventi.getEntityId(), existing.getEntityId());
        Assert.assertEquals("value of this field should NOT be updated", updatedMcEventi.getAgeEvento(), existing.getAgeEvento());
        Assert.assertEquals("value of this field should be updated", updatedMcEventi.getLastUpdateUser(), userUtil.calculateUpdateUser("test", "test"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForMcEventiWithNullId() throws ParseException {

        // given
        prepareVariables();
        mcEventiNewValues.setMcEventiId(null);

        // when
        final McEventi updatedMcEventi = service.updateMcEventi(mcEventiNewValues, "test", "test");
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementExceptionForMcEventiWithNullId() throws ParseException {

        // given
        prepareVariables();
        BDDMockito.given(repository.findById(mcEventiNewValues.getMcEventiId())).willReturn(Optional.empty());

        // when
        final McEventi updatedMcEventi = service.updateMcEventi(mcEventiNewValues, "test", "test");
    }

    @Test
    public void shouldCreateMcEventi() throws ParseException {

        // given
        McEventi newMcEventi = new McEventi();
        newMcEventi.setIdAttivita(BigInteger.valueOf(564456486841891635l));
        newMcEventi.setNota("testNota");

        final UplCrmMcEventi objToSave = modelMapper.map(newMcEventi, UplCrmMcEventi.class);

        BDDMockito.given(persistenceService.insertMcEventi(objToSave)).willReturn(objToSave);

        // when
        final McEventi insertedMcEventi = service.insertMcEventi(newMcEventi);

        // then
        Assert.assertNotNull(insertedMcEventi);
        Assert.assertEquals(newMcEventi.getIdAttivita(), insertedMcEventi.getIdAttivita());
        Assert.assertEquals(newMcEventi.getNota(), insertedMcEventi.getNota());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionForMcEventiWithNotNullIdWhenCreateMcEventi() throws ParseException {

        // given
        McEventi newMcEventi = new McEventi();
        newMcEventi.setMcEventiId(BigInteger.TEN);
        newMcEventi.setIdAttivita(BigInteger.valueOf(564456486841891635l));
        newMcEventi.setNota("testNota");

        // when
        final McEventi insertedMcEventi = service.insertMcEventi(newMcEventi);
    }

    @Test
    public void shouldDeleteMcEventi() throws ParseException {

        // given
        prepareVariables();

        final UplCrmMcEventi existingUplCrmMcEventi = modelMapper.map(existing, UplCrmMcEventi.class);

        BDDMockito.given(repository.findById(BigInteger.valueOf(723952095513575335l))).willReturn(Optional.of(existingUplCrmMcEventi));

        // when
        service.deleteMcEventi(existing);

        //then
        BDDMockito.verify(repository, times(1)).delete(existingUplCrmMcEventi);
    }
}

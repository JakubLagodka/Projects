package it.unipol.crm.sinistro.config;

import it.unipol.crm.sinistro.ModelPopulator;
import it.unipol.crm.sinistro.model.contratto.ContrattoAssociato;
import it.unipol.crm.sinistro.model.ruolo.CodRuolo;
import it.unipol.crm.sinistro.model.ruolo.RuoloSinistro;
import it.unipol.crm.sinistro.model.sinistro.Sinistro;
import it.unipol.crm.sinistro.model.sinistro.SinistroRisp;
import it.unipol.crm.sinistro.persistence.entity.claim.UplCrmClaim;
import it.unipol.crm.sinistro.persistence.entity.claimcontract.UplCrmClaimContract;
import it.unipol.crm.sinistro.persistence.entity.claimrole.UplCrmClaimRole;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ModelMapperTest {

    @Autowired
    ModelMapper modelMapper;

    LocalDateTime now;

    @BeforeEach
    public void setUp() {
        now = LocalDateTime.now();
    }

    @Test
    void shouldConvertUplCrmClaimToSinistro() {

        // given
        UplCrmClaim input = new UplCrmClaim();
        input.setClaimId(BigInteger.TEN);
        input.setAdminRefNum("120160890000247340");
        input.setClaimNumber("10129001290080");
        input.setClaimDetailAmt(null);
        input.setClaimPaidAmt(BigDecimal.valueOf(123.45));
        input.setOutstandingAmt(BigDecimal.valueOf(123456789));
        input.setBenefitClaimAmt(BigDecimal.valueOf(1234));
        input.setClaimTpCd(BigInteger.valueOf(24));
        input.setLobTpCd(BigInteger.TEN);
        input.setClaimStatusTpCd(BigInteger.ONE);
        input.setClaimCode("AAABBB11A22C345F");
        input.setStatusDt(Timestamp.valueOf(now));
        input.setClaimIncurredDt(Timestamp.valueOf(now));
        input.setReportedDt(Timestamp.valueOf(now));
        input.setDescription("Condominio ABC");
        input.setLastUpdateDt(Timestamp.valueOf(now));
        input.setLastUpdateUser("testUser");

        Sinistro expected = new Sinistro();
        expected.setChiaveSinistro("120160890000247340");
        expected.setNumero("10129001290080");
        expected.setImporto(null);
        expected.setImportoLiquidato(BigDecimal.valueOf(123.45));
        expected.setNumeroPolizza(BigInteger.valueOf(123456789));
        expected.setAgenzia(BigInteger.valueOf(1234));
        expected.setRamo(BigInteger.valueOf(24));
        expected.setCodStato(BigInteger.ONE);
        expected.setCodFiscControparte("AAABBB11A22C345F");
        expected.setDataUltimaLiquidazione(now.toLocalDate());
        expected.setDataAvvenimento(now.toLocalDate());
        expected.setDataDenuncia(now.toLocalDate());
        expected.setRagioneSocialeControparte("Condominio ABC");

        // when
        final Sinistro given = modelMapper.convertUplCrmClaimToSinistro(input);
        final Sinistro givenNull = modelMapper.convertUplCrmClaimToSinistro(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void shouldConvertSinistroToUplCrmClaim() {

        // given
        Sinistro input = new Sinistro();
        input.setChiaveSinistro("120160890000247340");
        input.setNumero("10129001290080");
        input.setImporto(null);
        input.setImportoLiquidato(BigDecimal.valueOf(123.45));
        input.setNumeroPolizza(BigInteger.valueOf(123456789));
        input.setAgenzia(BigInteger.valueOf(1234));
        input.setRamo(BigInteger.valueOf(24));
        input.setCodStato(BigInteger.ONE);
        input.setCodFiscControparte("AAABBB11A22C345F");
        input.setDataUltimaLiquidazione(now.toLocalDate());
        input.setDataAvvenimento(now.toLocalDate());
        input.setDataDenuncia(now.toLocalDate());
        input.setRagioneSocialeControparte("Condominio ABC");

        UplCrmClaim expected = new UplCrmClaim();
        expected.setAdminRefNum("120160890000247340");
        expected.setClaimNumber("10129001290080");
        expected.setClaimDetailAmt(null);
        expected.setClaimPaidAmt(BigDecimal.valueOf(123.45));
        expected.setOutstandingAmt(BigDecimal.valueOf(123456789));
        expected.setBenefitClaimAmt(BigDecimal.valueOf(1234));
        expected.setClaimTpCd(BigInteger.valueOf(24));
        expected.setClaimStatusTpCd(BigInteger.ONE);
        expected.setClaimCode("AAABBB11A22C345F");
        expected.setStatusDt(Timestamp.valueOf(now.toLocalDate().atStartOfDay()));
        expected.setClaimIncurredDt(Timestamp.valueOf(now.toLocalDate().atStartOfDay()));
        expected.setReportedDt(Timestamp.valueOf(now.toLocalDate().atStartOfDay()));
        expected.setDescription("Condominio ABC");

        // when
        final UplCrmClaim given = modelMapper.convertSinistroToUplCrmClaim(input);
        final UplCrmClaim givenNull = modelMapper.convertSinistroToUplCrmClaim(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void shouldConvertUplCrmClaimToSinistroRisp() {

        // given
        UplCrmClaim input = new UplCrmClaim();
        input.setClaimId(BigInteger.TEN);
        input.setAdminRefNum("120160890000247340");
        input.setClaimNumber("10129001290080");
        input.setClaimDetailAmt(BigDecimal.valueOf(123.45));
        input.setClaimPaidAmt(BigDecimal.valueOf(123.45));
        input.setOutstandingAmt(BigDecimal.valueOf(123456789));
        input.setBenefitClaimAmt(BigDecimal.valueOf(1234));
        input.setClaimTpCd(BigInteger.valueOf(24));
        input.setLobTpCd(BigInteger.TEN);
        input.setClaimStatusTpCd(BigInteger.ONE);
        input.setClaimCode("AAABBB11A22C345F");
        input.setStatusDt(Timestamp.valueOf(now));
        input.setClaimIncurredDt(Timestamp.valueOf(now));
        input.setReportedDt(Timestamp.valueOf(now));
        input.setDescription("Condominio ABC");
        input.setLastUpdateDt(Timestamp.valueOf(now));
        input.setLastUpdateUser("testUser");

        SinistroRisp expected = new SinistroRisp();
        expected.setChiaveSinistro("120160890000247340");
        expected.setNumero("10129001290080");
        expected.setImporto(BigDecimal.valueOf(123.45));
        expected.setImportoLiquidato(BigDecimal.valueOf(123.45));
        expected.setNumeroPolizza(BigInteger.valueOf(123456789));
        expected.setAgenzia(BigInteger.valueOf(1234));
        expected.setRamo(BigInteger.valueOf(24));
        expected.setCodStato(BigInteger.ONE);
        expected.setCodFiscControparte("AAABBB11A22C345F");
        expected.setDataUltimaLiquidazione(now.toLocalDate());
        expected.setDataAvvenimento(now.toLocalDate());
        expected.setDataDenuncia(now.toLocalDate());
        expected.setRagioneSocialeControparte("Condominio ABC");
        expected.setId(BigInteger.TEN);
        expected.setDataUltimoAggiornamento(now);

        // when
        final SinistroRisp given = modelMapper.convertUplCrmClaimToSinistroRisp(input);
        final SinistroRisp givenNull = modelMapper.convertUplCrmClaimToSinistroRisp(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void shouldConvertUplCrmClaimToFullSinistroRisp() {

        // given
        UplCrmClaimRole inputRole = new UplCrmClaimRole();
        inputRole.setClaimRoleTpCd(BigInteger.valueOf(1001));
        inputRole.setContId(BigInteger.TEN);
        inputRole.setEndDt(Timestamp.valueOf(now));
        inputRole.setClaimRoleId(BigInteger.TEN);
        inputRole.setClaimId(BigInteger.TEN);
        inputRole.setLastUpdateDt(Timestamp.valueOf(now));
        inputRole.setLastUpdateUser("testUser");

        RuoloSinistro expectedRuolo = new RuoloSinistro();
        expectedRuolo.setCodRuolo(CodRuolo.CONTRAENTE);
        expectedRuolo.setContattoId(BigInteger.TEN);
        expectedRuolo.setDataFine(now.toLocalDate());

        UplCrmClaimContract inputContract = new UplCrmClaimContract();
        inputContract.setContractId(BigInteger.TEN);
        inputContract.setEndDt(Timestamp.valueOf(now));
        inputContract.setClaimContrId(BigInteger.TEN);
        inputContract.setClaimId(BigInteger.TEN);
        inputContract.setLastUpdateDt(Timestamp.valueOf(now));
        inputContract.setLastUpdateUser("testUser");

        ContrattoAssociato expectedContratto = new ContrattoAssociato();
        expectedContratto.setContrattoId(BigInteger.TEN);
        expectedContratto.setDataFine(now.toLocalDate());

        UplCrmClaim input = new UplCrmClaim();
        input.setClaimId(BigInteger.TEN);
        input.setAdminRefNum("120160890000247340");
        input.setClaimNumber("10129001290080");
        input.setClaimDetailAmt(BigDecimal.valueOf(123.45));
        input.setClaimPaidAmt(BigDecimal.valueOf(123.45));
        input.setOutstandingAmt(BigDecimal.valueOf(123456789));
        input.setBenefitClaimAmt(BigDecimal.valueOf(1234));
        input.setClaimTpCd(BigInteger.valueOf(24));
        input.setLobTpCd(BigInteger.TEN);
        input.setClaimStatusTpCd(BigInteger.ONE);
        input.setClaimCode("AAABBB11A22C345F");
        input.setStatusDt(Timestamp.valueOf(now));
        input.setClaimIncurredDt(Timestamp.valueOf(now));
        input.setReportedDt(Timestamp.valueOf(now));
        input.setDescription("Condominio ABC");
        input.setLastUpdateDt(Timestamp.valueOf(now));
        input.setLastUpdateUser("testUser");

        SinistroRisp expected = new SinistroRisp();
        expected.setChiaveSinistro("120160890000247340");
        expected.setNumero("10129001290080");
        expected.setImporto(BigDecimal.valueOf(123.45));
        expected.setImportoLiquidato(BigDecimal.valueOf(123.45));
        expected.setNumeroPolizza(BigInteger.valueOf(123456789));
        expected.setAgenzia(BigInteger.valueOf(1234));
        expected.setRamo(BigInteger.valueOf(24));
        expected.setCodStato(BigInteger.ONE);
        expected.setCodFiscControparte("AAABBB11A22C345F");
        expected.setDataUltimaLiquidazione(now.toLocalDate());
        expected.setDataAvvenimento(now.toLocalDate());
        expected.setDataDenuncia(now.toLocalDate());
        expected.setRagioneSocialeControparte("Condominio ABC");
        expected.setId(BigInteger.TEN);
        expected.setDataUltimoAggiornamento(now);
        expected.setRuoli(List.of(expectedRuolo));
        expected.setContrattoAssociato(expectedContratto);

        // when
        final SinistroRisp given = modelMapper.convertUplCrmClaimToFullSinistroRisp(input, inputContract, List.of(inputRole));
        final SinistroRisp givenNull = modelMapper.convertUplCrmClaimToFullSinistroRisp(null, null, null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void shouldConvertSinistroRispToUplCrmClaim() {

        // given
        SinistroRisp input = new SinistroRisp();
        input.setChiaveSinistro("120160890000247340");
        input.setNumero("10129001290080");
        input.setImporto(BigDecimal.valueOf(123.45));
        input.setImportoLiquidato(BigDecimal.valueOf(123.45));
        input.setNumeroPolizza(BigInteger.valueOf(123456789));
        input.setAgenzia(BigInteger.valueOf(1234));
        input.setRamo(BigInteger.valueOf(24));
        input.setCodStato(BigInteger.ONE);
        input.setCodFiscControparte("AAABBB11A22C345F");
        input.setDataUltimaLiquidazione(now.toLocalDate());
        input.setDataAvvenimento(now.toLocalDate());
        input.setDataDenuncia(now.toLocalDate());
        input.setRagioneSocialeControparte("Condominio ABC");
        input.setId(BigInteger.TEN);
        input.setDataUltimoAggiornamento(now);

        UplCrmClaim expected = new UplCrmClaim();
        expected.setAdminRefNum("120160890000247340");
        expected.setClaimNumber("10129001290080");
        expected.setClaimDetailAmt(BigDecimal.valueOf(123.45));
        expected.setClaimPaidAmt(BigDecimal.valueOf(123.45));
        expected.setOutstandingAmt(BigDecimal.valueOf(123456789));
        expected.setBenefitClaimAmt(BigDecimal.valueOf(1234));
        expected.setClaimTpCd(BigInteger.valueOf(24));
        expected.setClaimStatusTpCd(BigInteger.ONE);
        expected.setClaimCode("AAABBB11A22C345F");
        expected.setStatusDt(Timestamp.valueOf(now.toLocalDate().atStartOfDay()));
        expected.setClaimIncurredDt(Timestamp.valueOf(now.toLocalDate().atStartOfDay()));
        expected.setReportedDt(Timestamp.valueOf(now.toLocalDate().atStartOfDay()));
        expected.setDescription("Condominio ABC");
        expected.setClaimId(BigInteger.TEN);
        expected.setLastUpdateDt(Timestamp.valueOf(now));

        // when
        final UplCrmClaim given = modelMapper.convertSinistroRispToUplCrmClaim(input);
        final UplCrmClaim givenNull = modelMapper.convertSinistroRispToUplCrmClaim(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void shouldConvertUplCrmClaimContractToContrattoAssociato() {

        // given
        UplCrmClaimContract input = new UplCrmClaimContract();
        input.setContractId(BigInteger.TEN);
        input.setEndDt(Timestamp.valueOf(now));
        input.setClaimContrId(BigInteger.TEN);
        input.setClaimId(BigInteger.TEN);
        input.setLastUpdateDt(Timestamp.valueOf(now));
        input.setLastUpdateUser("testUser");

        ContrattoAssociato expected = new ContrattoAssociato();
        expected.setContrattoId(BigInteger.TEN);
        expected.setDataFine(now.toLocalDate());

        // when
        final ContrattoAssociato given = modelMapper.convertUplCrmClaimContractToContrattoAssociato(input);
        final ContrattoAssociato givenNull = modelMapper.convertUplCrmClaimContractToContrattoAssociato(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void shouldConvertContrattoAssociatoToUplCrmClaimContract() {

        // given
        ContrattoAssociato input = new ContrattoAssociato();
        input.setContrattoId(BigInteger.TEN);
        input.setDataFine(now.toLocalDate());

        UplCrmClaimContract expected = new UplCrmClaimContract();
        expected.setContractId(BigInteger.TEN);
        expected.setEndDt(Timestamp.valueOf(now.toLocalDate().atStartOfDay()));
        expected.setClaimContrId(null);
        expected.setClaimId(null);
        expected.setLastUpdateDt(null);
        expected.setLastUpdateUser(null);

        // when
        final UplCrmClaimContract given = modelMapper.convertContrattoAssociatoToUplCrmClaimContract(input);
        final UplCrmClaimContract givenNull = modelMapper.convertContrattoAssociatoToUplCrmClaimContract(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void shouldConvertUplCrmClaimRoleToRuoloSinistro() {

        // given
        UplCrmClaimRole input = new UplCrmClaimRole();
        input.setClaimRoleTpCd(BigInteger.valueOf(1001));
        input.setContId(BigInteger.TEN);
        input.setEndDt(Timestamp.valueOf(now));
        input.setClaimRoleId(BigInteger.TEN);
        input.setClaimId(BigInteger.TEN);
        input.setLastUpdateDt(Timestamp.valueOf(now));
        input.setLastUpdateUser("testUser");

        RuoloSinistro expected = new RuoloSinistro();
        expected.setCodRuolo(CodRuolo.CONTRAENTE);
        expected.setContattoId(BigInteger.TEN);
        expected.setDataFine(now.toLocalDate());

        // when
        final RuoloSinistro given = modelMapper.convertUplCrmClaimRoleToRuoloSinistro(input);
        final RuoloSinistro givenNull = modelMapper.convertUplCrmClaimRoleToRuoloSinistro(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void shouldConvertRuoloSinistroToUplCrmClaimRole() {

        // given
        RuoloSinistro input = new RuoloSinistro();
        input.setCodRuolo(CodRuolo.CONTRAENTE);
        input.setContattoId(BigInteger.TEN);
        input.setDataFine(now.toLocalDate());

        UplCrmClaimRole expected = new UplCrmClaimRole();
        expected.setClaimRoleTpCd(BigInteger.valueOf(1001));
        expected.setContId(BigInteger.TEN);
        expected.setEndDt(Timestamp.valueOf(now.toLocalDate().atStartOfDay()));
        expected.setClaimRoleId(null);
        expected.setClaimId(null);
        expected.setLastUpdateDt(null);
        expected.setLastUpdateUser(null);

        // when
        final UplCrmClaimRole given = modelMapper.convertRuoloSinistroToUplCrmClaimRole(input);
        final UplCrmClaimRole givenNull = modelMapper.convertRuoloSinistroToUplCrmClaimRole(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void shouldConvertRuoloSinistroListToUplCrmClaimRoleList() {

        // given
        List<RuoloSinistro> input = ModelPopulator.prepareRuoliSinistro();
        List<UplCrmClaimRole> expected = ModelPopulator.prepareUplCrmClaimRoleList();

        // when
        final List<UplCrmClaimRole> given = modelMapper.convertRuoloSinistroListToUplCrmClaimRoleList(input);
        final List<UplCrmClaimRole> givenNull = modelMapper.convertRuoloSinistroListToUplCrmClaimRoleList(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void shouldConvertUplCrmClaimRoleListToRuoloSinistroList() {

        // given
        List<UplCrmClaimRole> input = ModelPopulator.prepareUplCrmClaimRoleList();
        List<RuoloSinistro> expected = ModelPopulator.prepareRuoliSinistro();

        // when
        final List<RuoloSinistro> given = modelMapper.convertUplCrmClaimRoleListToRuoloSinistroList(input);
        final List<RuoloSinistro> givenNull = modelMapper.convertUplCrmClaimRoleListToRuoloSinistroList(null);

        // then
        assertEquals(expected, given);
        assertNull(givenNull);
    }

    @Test
    void shouldConvertStringToCodRuolo() {

        // given
        CodRuolo expected = CodRuolo.CONTRAENTE;
        String value = "CONTRAENTE";

        // when
        final CodRuolo given = CodRuolo.fromString(value);

        // then
        assertEquals(expected, given);
    }

    @Test
    void shouldConvertBigIntegerToCodRuolo() {

        // given
        CodRuolo expected = CodRuolo.CONTRAENTE;
        BigInteger value = BigInteger.valueOf(1001);

        // when
        final CodRuolo given = modelMapper.bigIntegerToCodRuolo(value);

        // then
        assertEquals(expected, given);
    }

    @Test
    void shouldThrowExceptionForWrongRoleStringValue() {

        // then
        assertThrows(IllegalArgumentException.class, () -> CodRuolo.fromString("test"));
    }

    @Test
    void shouldThrowExceptionForWrongRoleBigIntegerValue() {

        // then
        assertThrows(IllegalArgumentException.class, () -> CodRuolo.fromBigInteger(BigInteger.ONE));
    }

    @Test
    void shouldConvertDates() {

        // given
        LocalDate localDate = LocalDate.of(2020,12,12);
        LocalDateTime localDateTime = LocalDateTime.of(2020,12,12,12,12,12);
        Timestamp timestampStart = Timestamp.valueOf("2020-12-12 0:00:00.000");
        Timestamp timestamp = Timestamp.valueOf("2020-12-12 12:12:12.000");

        // then
        assertEquals(timestampStart, modelMapper.localDateToTimestamp(localDate));
        assertEquals(timestamp, modelMapper.localDateTimeToTimestamp(localDateTime));
        assertEquals(localDate, modelMapper.timestampToLocalDate(timestamp));
        assertEquals(localDateTime, modelMapper.timestampToLocalDateTime(timestamp));

        assertNull(modelMapper.localDateToTimestamp(null));
        assertNull(modelMapper.localDateTimeToTimestamp(null));
        assertNull(modelMapper.timestampToLocalDate(null));
        assertNull(modelMapper.timestampToLocalDateTime(null));
    }
}
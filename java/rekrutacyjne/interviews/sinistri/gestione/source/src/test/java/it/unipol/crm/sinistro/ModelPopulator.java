package it.unipol.crm.sinistro;

import it.unipol.crm.sinistro.model.Paginazione;
import it.unipol.crm.sinistro.model.contratto.ContrattoAssociato;
import it.unipol.crm.sinistro.model.ruolo.CodRuolo;
import it.unipol.crm.sinistro.model.ruolo.RuoloSinistro;
import it.unipol.crm.sinistro.model.sinistro.Sinistro;
import it.unipol.crm.sinistro.model.sinistro.SinistroPaginatoRisp;
import it.unipol.crm.sinistro.model.sinistro.SinistroRisp;
import it.unipol.crm.sinistro.persistence.entity.claim.UplCrmClaim;
import it.unipol.crm.sinistro.persistence.entity.claimcontract.UplCrmClaimContract;
import it.unipol.crm.sinistro.persistence.entity.claimrole.UplCrmClaimRole;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ModelPopulator {
    public static ContrattoAssociato prepareContrattoAssociato() {

        ContrattoAssociato contrattoAssociato = new ContrattoAssociato();
        contrattoAssociato.setContrattoId(BigInteger.ONE);
        contrattoAssociato.setDataFine(LocalDate.of(2022, 12, 12));

        return contrattoAssociato;
    }

    public static List<RuoloSinistro> prepareRuoliSinistro() {

        RuoloSinistro ruoloSinistro1 = new RuoloSinistro();
        ruoloSinistro1.setCodRuolo(CodRuolo.CONTRAENTE);
        ruoloSinistro1.setContattoId(BigInteger.ONE);
        ruoloSinistro1.setDataFine(LocalDate.of(2022, 12, 12));

        RuoloSinistro ruoloSinistro2 = new RuoloSinistro();
        ruoloSinistro2.setCodRuolo(CodRuolo.PROPRIETARIO_AUTO_SINISTRATA);
        ruoloSinistro2.setContattoId(BigInteger.TWO);
        ruoloSinistro2.setDataFine(LocalDate.of(2020, 12, 12));

        return List.of(ruoloSinistro1, ruoloSinistro2);
    }

    public static Sinistro prepareSinistro() {

        Sinistro sinistro = new Sinistro();
        sinistro.setChiaveSinistro("120180890000419014");
        sinistro.setNumero("10129001290080");
        sinistro.setImporto(BigDecimal.valueOf(100.010));
        sinistro.setImportoLiquidato(BigDecimal.valueOf(100.010));
        sinistro.setNumeroPolizza(BigInteger.valueOf(781436310));
        sinistro.setAgenzia(BigInteger.valueOf(8101));
        sinistro.setRamo(BigInteger.valueOf(22));
        sinistro.setCodStato(BigInteger.valueOf(2));
        sinistro.setCodFiscControparte(null);
        sinistro.setDataUltimaLiquidazione(LocalDate.of(2022, 12, 12));
        sinistro.setDataAvvenimento(LocalDate.of(2022, 12, 15));
        sinistro.setDataDenuncia(LocalDate.of(2022, 12, 18));
        sinistro.setRagioneSocialeControparte("POMATI");
        sinistro.setRuoli(prepareRuoliSinistro());
        sinistro.setContrattoAssociato(prepareContrattoAssociato());

        return sinistro;
    }

    public static SinistroRisp prepareSinistroRisp() {

        SinistroRisp sinistroRisp = new SinistroRisp();
        sinistroRisp.setChiaveSinistro("120180890000419014");
        sinistroRisp.setNumero("10129001290080");
        sinistroRisp.setImporto(BigDecimal.valueOf(100.010));
        sinistroRisp.setImportoLiquidato(BigDecimal.valueOf(100.010));
        sinistroRisp.setNumeroPolizza(BigInteger.valueOf(781436310));
        sinistroRisp.setAgenzia(BigInteger.valueOf(8101));
        sinistroRisp.setRamo(BigInteger.valueOf(22));
        sinistroRisp.setCodStato(BigInteger.valueOf(2));
        sinistroRisp.setCodFiscControparte(null);
        sinistroRisp.setDataUltimaLiquidazione(LocalDate.of(2022, 12, 12));
        sinistroRisp.setDataAvvenimento(LocalDate.of(2022, 12, 15));
        sinistroRisp.setDataDenuncia(LocalDate.of(2022, 12, 18));
        sinistroRisp.setRagioneSocialeControparte("POMATI");
        sinistroRisp.setRuoli(prepareRuoliSinistro());
        sinistroRisp.setContrattoAssociato(prepareContrattoAssociato());
        sinistroRisp.setId(BigInteger.valueOf(1));
        sinistroRisp.setDataUltimoAggiornamento(LocalDateTime.of(2022, 12, 20, 12, 12, 0));

        return sinistroRisp;
    }

    public static SinistroPaginatoRisp prepareSinistroPaginatoRisp() {

        SinistroPaginatoRisp sinistroPaginatoRisp = new SinistroPaginatoRisp();
        Paginazione paginazione = new Paginazione(BigInteger.ONE, 10, 0);
        SinistroRisp sinistroRisp = prepareSinistroRisp();
        sinistroPaginatoRisp.setPaginazione(paginazione);
        sinistroPaginatoRisp.setSinistri(List.of(sinistroRisp));

        return sinistroPaginatoRisp;
    }

    public static UplCrmClaim prepareUplCrmClaim() {

        UplCrmClaim claim = new UplCrmClaim();
        claim.setAdminRefNum("120180890000419014");
        claim.setClaimNumber("10129001290080");
        claim.setClaimDetailAmt(BigDecimal.valueOf(100.010));
        claim.setClaimPaidAmt(BigDecimal.valueOf(100.010));
        claim.setOutstandingAmt(BigDecimal.valueOf(781436310));
        claim.setBenefitClaimAmt(BigDecimal.valueOf(8101));
        claim.setClaimTpCd(BigInteger.valueOf(22));
        claim.setClaimStatusTpCd(BigInteger.valueOf(2));
        claim.setClaimCode(null);
        claim.setStatusDt(Timestamp.valueOf(LocalDate.of(2022, 12, 12).atStartOfDay()));
        claim.setClaimIncurredDt(Timestamp.valueOf(LocalDate.of(2022, 12, 15).atStartOfDay()));
        claim.setReportedDt(Timestamp.valueOf(LocalDate.of(2022, 12, 18).atStartOfDay()));
        claim.setDescription("POMATI");

        return claim;
    }

    public static List<UplCrmClaimRole> prepareUplCrmClaimRoleList() {

        UplCrmClaimRole claimRole1 = new UplCrmClaimRole();
        claimRole1.setClaimRoleTpCd(BigInteger.valueOf(1001));
        claimRole1.setContId(BigInteger.ONE);
        claimRole1.setEndDt(Timestamp.valueOf(LocalDate.of(2022, 12, 12).atStartOfDay()));

        UplCrmClaimRole claimRole2 = new UplCrmClaimRole();
        claimRole2.setClaimRoleTpCd(BigInteger.valueOf(1002));
        claimRole2.setContId(BigInteger.TWO);
        claimRole2.setEndDt(Timestamp.valueOf(LocalDate.of(2020, 12, 12).atStartOfDay()));

        return List.of(claimRole1, claimRole2);
    }

    public static UplCrmClaimContract prepareUplCrmClaimContract() {

        UplCrmClaimContract claimContract = new UplCrmClaimContract();
        claimContract.setContractId(BigInteger.ONE);
        claimContract.setEndDt(Timestamp.valueOf(LocalDate.of(2022, 12, 12).atStartOfDay()));
        claimContract.setClaimContrId(BigInteger.valueOf(6));

        return claimContract;
    }
}
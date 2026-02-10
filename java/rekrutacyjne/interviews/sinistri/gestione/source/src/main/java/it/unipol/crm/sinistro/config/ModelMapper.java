package it.unipol.crm.sinistro.config;

import it.unipol.crm.sinistro.model.contratto.ContrattoAssociato;
import it.unipol.crm.sinistro.model.ruolo.CodRuolo;
import it.unipol.crm.sinistro.model.ruolo.RuoloSinistro;
import it.unipol.crm.sinistro.model.sinistro.Sinistro;
import it.unipol.crm.sinistro.model.sinistro.SinistroRisp;
import it.unipol.crm.sinistro.persistence.entity.claim.UplCrmClaim;
import it.unipol.crm.sinistro.persistence.entity.claimcontract.UplCrmClaimContract;
import it.unipol.crm.sinistro.persistence.entity.claimrole.UplCrmClaimRole;
import org.mapstruct.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ModelMapper {

    @Mapping(source = "adminRefNum", target = "chiaveSinistro")
    @Mapping(source = "claimNumber", target = "numero")
    @Mapping(source = "claimDetailAmt", target = "importo")
    @Mapping(source = "claimPaidAmt", target = "importoLiquidato")
    @Mapping(source = "outstandingAmt", target = "numeroPolizza")
    @Mapping(source = "benefitClaimAmt", target = "agenzia")
    @Mapping(source = "claimTpCd", target = "ramo")
    @Mapping(source = "claimStatusTpCd", target = "codStato")
    @Mapping(source = "claimCode", target = "codFiscControparte")
    @Mapping(source = "statusDt", target = "dataUltimaLiquidazione")
    @Mapping(source = "claimIncurredDt", target = "dataAvvenimento")
    @Mapping(source = "reportedDt", target = "dataDenuncia")
    @Mapping(source = "description", target = "ragioneSocialeControparte")
    Sinistro convertUplCrmClaimToSinistro(UplCrmClaim input);

    @InheritInverseConfiguration(name = "convertUplCrmClaimToSinistro")
    UplCrmClaim convertSinistroToUplCrmClaim(Sinistro input);

    @InheritConfiguration
    @Mapping(source = "claimId", target = "id")
    @Mapping(source = "lastUpdateDt", target = "dataUltimoAggiornamento")
    SinistroRisp convertUplCrmClaimToSinistroRisp(UplCrmClaim input);

    @InheritInverseConfiguration(name = "convertUplCrmClaimToSinistroRisp")
    UplCrmClaim convertSinistroRispToUplCrmClaim(SinistroRisp input);

    @Mapping(source = "input.adminRefNum", target = "chiaveSinistro")
    @Mapping(source = "input.claimNumber", target = "numero")
    @Mapping(source = "input.claimDetailAmt", target = "importo")
    @Mapping(source = "input.claimPaidAmt", target = "importoLiquidato")
    @Mapping(source = "input.outstandingAmt", target = "numeroPolizza")
    @Mapping(source = "input.benefitClaimAmt", target = "agenzia")
    @Mapping(source = "input.claimTpCd", target = "ramo")
    @Mapping(source = "input.claimStatusTpCd", target = "codStato")
    @Mapping(source = "input.claimCode", target = "codFiscControparte")
    @Mapping(source = "input.statusDt", target = "dataUltimaLiquidazione")
    @Mapping(source = "input.claimIncurredDt", target = "dataAvvenimento")
    @Mapping(source = "input.reportedDt", target = "dataDenuncia")
    @Mapping(source = "input.description", target = "ragioneSocialeControparte")
    @Mapping(source = "input.claimId", target = "id")
    @Mapping(source = "input.lastUpdateDt", target = "dataUltimoAggiornamento")
    @Mapping(source = "roles", target = "ruoli")
    @Mapping(source = "contract", target = "contrattoAssociato")
    SinistroRisp convertUplCrmClaimToFullSinistroRisp(UplCrmClaim input, UplCrmClaimContract contract, List<UplCrmClaimRole> roles);

    @Mapping(source = "contractId", target = "contrattoId")
    @Mapping(source = "endDt", target = "dataFine")
    ContrattoAssociato convertUplCrmClaimContractToContrattoAssociato(UplCrmClaimContract input);

    @InheritInverseConfiguration
    UplCrmClaimContract convertContrattoAssociatoToUplCrmClaimContract(ContrattoAssociato input);

    @Mapping(source = "contId", target = "contattoId")
    @Mapping(source = "endDt", target = "dataFine")
    @Mapping(source = "claimRoleTpCd", target = "codRuolo")
    RuoloSinistro convertUplCrmClaimRoleToRuoloSinistro(UplCrmClaimRole input);

    @InheritInverseConfiguration
    UplCrmClaimRole convertRuoloSinistroToUplCrmClaimRole(RuoloSinistro input);

    @IterableMapping(elementTargetType = RuoloSinistro.class)
    List<RuoloSinistro> convertUplCrmClaimRoleListToRuoloSinistroList(List<UplCrmClaimRole> input);

    @IterableMapping(elementTargetType = UplCrmClaimRole.class)
    List<UplCrmClaimRole> convertRuoloSinistroListToUplCrmClaimRoleList(List<RuoloSinistro> input);

    default Timestamp localDateToTimestamp(LocalDate input) {
        return input == null ? null : Timestamp.valueOf(input.atStartOfDay());
    }

    default LocalDate timestampToLocalDate(Timestamp input) {
        return input == null ? null : input.toLocalDateTime().toLocalDate();
    }

    default Timestamp localDateTimeToTimestamp(LocalDateTime input) {
        return input == null ? null : Timestamp.valueOf(input);
    }

    default LocalDateTime timestampToLocalDateTime(Timestamp input) {
        return input == null ? null : input.toLocalDateTime();
    }

    default BigDecimal toNoTrailingZerosBigDecimal(BigDecimal input) {
        return input == null ? null : new BigDecimal(input.stripTrailingZeros().toPlainString());
    }

    default CodRuolo bigIntegerToCodRuolo(BigInteger input) {
        return CodRuolo.fromBigInteger(input);
    }

    default BigInteger codRuoloToBigInteger(CodRuolo input) {
        return input == null ? null : input.getValue();
    }
}
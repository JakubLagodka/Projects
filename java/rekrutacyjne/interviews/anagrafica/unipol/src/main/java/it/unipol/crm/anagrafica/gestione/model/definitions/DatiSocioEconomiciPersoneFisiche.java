package it.unipol.crm.anagrafica.gestione.model.definitions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static it.unipol.crm.anagrafica.gestione.config.Constants.DATE_FORMAT;
import static it.unipol.crm.anagrafica.gestione.config.Constants.DATE_TIME_FORMAT;

@Data
public class DatiSocioEconomiciPersoneFisiche {
    private BigInteger idDatiSocioEconomiciPersoneFisiche	;
    private String compagnia	;
    private String statoCivile	;
    private String flagFigli	;
    private String annoFiglio1	;
    private String annoFiglio2	;
    private String annoFiglio3	;
    private String annoFiglio4	;
    private String titoloStudio	;
    private String interesseFaiDaTe	;
    private String interesseMusica	;
    private String interesseSalute	;
    private String interesseLettura	;
    private String interesseNatura	;
    private String interesseVolontariato	;
    private String interesseFoto	;
    private String interesseTecnologia	;
    private String interesseSport	;
    private String interesseViaggi	;
    private String interesseMotori	;
    private String interesseEnogastronomia	;
    private String inetLavoro	;
    private String inetSocial	;
    private String inetAcquisti	;
    private String inetApp	;
    private String casaPropr	;
    private String casaAffitto	;
    private String casaSeconda	;
    private String casaMutuo	;
    private String tipoRisparmiatore	;
    private String infoRispAuto	;
    private String infoIntPens	;
    private String infoRispNoRischi	;
    private String infoStudioFigli	;
    private String infoRendCap	;
    private String infoEredita	;
    private String infoAssistenza	;
    private String infoTerremoto	;
    private String infoDanni	;
    private String infoIndennizzo	;
    private String infoPerditaImpiego	;
    private String prevCambioAuto	;
    private String prevPensione	;
    private String prevMutuo	;
    private String prevNuovaAtt	;
    private String prevPromozione	;
    private String prevVacanza	;
    private String prevFineStudioFigli	;
    private String prevCambioCasa	;
    private String flagConiugeCarico	;
    private BigInteger numeroFigliCarico	;
    private BigInteger codiceProfessione	;
    private BigDecimal redditoNettoLav	;
    private BigDecimal redditoLavStimato	;
    private BigInteger evolRedditoLav	;
    private BigDecimal redditoNettoAltro	;
    private BigInteger evolRedditoAltro	;
    private BigDecimal speseIncomprimibili	;
    private BigDecimal speseIncomprimibiliStimato	;
    private BigDecimal speseComprimibili	;
    private BigDecimal speseComprimibiliStimato	;
    private Integer trendAttesoSpese	;
    private String tipoAttivita	;
    private String applicazione	;
    private Integer numeroNucleoFamiliari	;
    private String flagAnimaliDomestici	;
    private String flagCollaboratoriDomestici	;
    private String utenteAggiornamento	;
    private String utenteInserimento;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate dataInizioAttivitaLavorativa;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate dataNascitaFiglio1;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate dataNascitaFiglio2;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate dataNascitaFiglio3;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate dataNascitaFiglio4;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate dataNascitaConiuge;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataAggiornamento;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataInserimento;
}

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
public class DatiAnagrafici {
    private BigInteger tipoNdg	;
    private String codiceLinguaPreferita	;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataCreazione;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate dataInattivazione;
    private String luogoNascita	;
    private String tipoPersona	;
    private String flagAffidato	;
    private BigInteger codiceSegmentoClientela	;
    private BigInteger codiceStatoCliente	;
    private BigInteger codiceTipoAnagrafe	;
    private BigInteger codiceTipoProfessione	;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataAggiornamento;
    private String utenteAggiornamento	;
    private BigInteger codiceTipoSofferenza	;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataRegistrazione;
    private String cognomeNome_ragionesociale	;
    private String nome	;
    private BigInteger consensoBanca	;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate dataConsensoBanca;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate dataRevocaConsensoBanca;
    private BigInteger consensoAssic	;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate dataConsensoAssic;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate dataRevocaConsensoAssic;
    private String matricolaRespCliente	;
    private String cittadinanza	;
    private String datiCCIAA	;
    private BigInteger incaglioSofferenza	;
    private String flagCapoFamiglia	;
    private String flagCapoGruppo	;
    private BigDecimal premiAnnoCorrente	;
    private BigDecimal liquidatoAnnoCorrente	;
    private BigDecimal riservatoAnnoCorrente	;
    private BigDecimal premiAnnoPrecedente	;
    private BigDecimal liquidatoAnnoPrecedente	;
    private BigDecimal riservatoAnnoPrecedente	;
    private BigDecimal premiTotale	;
    private BigDecimal liquidatoTotale	;
    private BigDecimal riservatoTotale	;
    private String flagAutorizzazioneFea	;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate dataAutorizzazioneFea;
    private String tipoCodAteco	;
    private String codAteco	;
    private String flagCorporate	;
    private String numDipendentoAteco	;
    private String fatturatoAteco	;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate dataUltimoStorno;
    private String canalePrivacy	;
    private String canaleRevocaPrivacy	;
    private String codOptOut	;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate dataInizioOptOut;
    private String canaleInizioOptOut	;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate dataFineOptOut;
    private String canaleFineOptOut	;
    private BigInteger consTpCd	;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate dataModificaCons;
    private String canaleModificaCons	;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
    private LocalDate dataEstensionePrivacy;
    private String rifiutoLoyaltyProgram	;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataRifiutoLoyaltyProgram;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataConsensoAssicTs;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataRegConsensoAssicTs;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataRevocaConsensoAssicTs;
    private String atecoFSOC	;
    private String atecoAEGruppo	;
    private String atecoAESottoGruppo	;
    private String atecoAEUIC	;
    private BigInteger canaleTpCd	;
    private String valoreCliente	;
    private String indicePropensione	;
    private String clientevip	;
    private String utenteAutorizzazioneFEA	;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataInserimento;
    private String utenteInserimento;
}

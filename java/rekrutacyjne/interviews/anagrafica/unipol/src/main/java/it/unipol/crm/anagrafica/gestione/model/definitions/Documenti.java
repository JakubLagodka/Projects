package it.unipol.crm.anagrafica.gestione.model.definitions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

import static it.unipol.crm.anagrafica.gestione.config.Constants.DATE_TIME_FORMAT;

@Data
public class Documenti {
    private BigInteger idDocumento;
    private BigInteger codiceStatoDocumento;
    private BigInteger codiceTipoDocumento;
    private String numeroDocumento;
    private String utenteAggiornamento;
    private String descrizione;
    private String localitaRilascioDocumento;
    private String utenteInserimento;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataEmissione;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataAggiornamento;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataScadenza;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataInserimento;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataFine;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataInizio;
}

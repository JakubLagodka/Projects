package it.unipol.crm.anagrafica.gestione.model.definitions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

import static it.unipol.crm.anagrafica.gestione.config.Constants.DATE_TIME_FORMAT;

@Data
public class Recapiti {
    private BigInteger idRecapito	;
    private BigInteger codiceTipoRecapito	;
    private String recapito	;
    private String utenteAggiornamento	;
    private BigInteger codiceUsoRecapito	;
    private String provenienzaRecapito	;
    private String flagMembroFamiglia	;
    private String flagPreferito	;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataInserimento;
    private String utenteInserimento;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataAggiornamento;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataInizio;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataFine;
}

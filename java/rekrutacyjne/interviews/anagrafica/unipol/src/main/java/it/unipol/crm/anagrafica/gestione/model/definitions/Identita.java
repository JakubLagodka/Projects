package it.unipol.crm.anagrafica.gestione.model.definitions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

import static it.unipol.crm.anagrafica.gestione.config.Constants.DATE_TIME_FORMAT;

@Data
public class Identita {
    private BigInteger idAnagraficaIdentita	;
    private BigInteger codiceTipo	;
    private String valore	;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataAggiornamento;
    private String utenteAggiornamento	;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataInserimento;
    private String utenteInserimento;
}

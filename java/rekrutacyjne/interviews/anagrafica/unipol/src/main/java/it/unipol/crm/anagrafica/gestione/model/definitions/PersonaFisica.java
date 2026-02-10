package it.unipol.crm.anagrafica.gestione.model.definitions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

import static it.unipol.crm.anagrafica.gestione.config.Constants.DATE_TIME_FORMAT;

@Data
public class PersonaFisica {
    private BigInteger codiceStatoCivile	;
    private BigInteger codiceSettore	;
    private BigInteger codiceMercatoPreferenziale	;
    private String sesso	;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataAggiornamento;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataNascita;
    private String utenteAggiornamento	;
    private String nome	;
    private String cognome	;
    private String naturaNominativo	;
    private String flagStandardizzazione	;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataInserimento;
    private String utenteInserimento;
}

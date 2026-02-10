package it.unipol.crm.anagrafica.gestione.model.definitions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

import static it.unipol.crm.anagrafica.gestione.config.Constants.DATE_TIME_FORMAT;

@Data
public class PrivacyProspect {
    private BigInteger idPrivacyProspect	;
    private String compagnia	;
    private String agenziaMadreAssicurativa	;
    private String agenzia	;
    private String flagPrivacy	;
    private String canaleCreazione	;
    private String canaleRevoca	;
    private String utenteRevoca	;
    private String utenteAggiornamento	;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataAggiornamento;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataInserimento;
    private String utenteInserimento;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataRevoca;

}

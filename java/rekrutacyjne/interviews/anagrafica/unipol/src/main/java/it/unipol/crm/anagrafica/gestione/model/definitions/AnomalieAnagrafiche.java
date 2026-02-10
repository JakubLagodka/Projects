package it.unipol.crm.anagrafica.gestione.model.definitions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

import static it.unipol.crm.anagrafica.gestione.config.Constants.DATE_TIME_FORMAT;

@Data
public class AnomalieAnagrafiche {
    private BigInteger idAnomalia	;
    private BigInteger codiceTipoAnomalia	;
    private BigInteger codiceStatoAnomalia	;
    private String provenienzaAlert	;
    private String utenteCancellazione	;
    private String utenteAggiornamento	;
    private String utenteInserimento;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataInizio;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataFine;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataAggiornamento;
    @JsonFormat(pattern = DATE_TIME_FORMAT)
    private LocalDateTime dataInserimento;
}

package it.unipol.crm.anagrafica.gestione.model.definitions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static it.unipol.crm.anagrafica.gestione.config.Constants.DATE_FORMAT;
import static it.unipol.crm.anagrafica.gestione.config.Constants.DATE_TIME_FORMAT;

@Data
public class Agenzia {
   private BigInteger idAnagraficaAgenzia	;
   private String reteVenditaProvenienza	;
   private String agenziaMadreAssicurativa	;
   private String agenziaPrevalente	;
   private String statoClienteAgenzia	;
   private String flagClienteTop	;
   private String subagenzia	;
   private String produttore	;
   private String zonaTerritoriale	;
   private String modalitaIncasso	;
   private String tipologiaAvviso	;
   private String utenteAggiornamento	;
   private String utenteInserimento;
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
   private LocalDate dataCessazioneCliente;
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_FORMAT)
   private LocalDate dataClienteTop;
   @JsonFormat(pattern = DATE_TIME_FORMAT)
   private LocalDateTime dataAggiornamento;
   @JsonFormat(pattern = DATE_TIME_FORMAT)
   private LocalDateTime dataInserimento;
}

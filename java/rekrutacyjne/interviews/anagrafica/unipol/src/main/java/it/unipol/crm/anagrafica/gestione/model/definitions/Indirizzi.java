package it.unipol.crm.anagrafica.gestione.model.definitions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigInteger;
import java.time.LocalDateTime;

import static it.unipol.crm.anagrafica.gestione.config.Constants.DATE_TIME_FORMAT;

@Data
public class Indirizzi {
      private BigInteger idIndirizzo;
      private BigInteger codiceNazione;
      private BigInteger codiceProvenienza;
      private BigInteger codiceProvincia;
      private String indirizzo;
      private String CRC;
      private String comune;
      private String CAP;
      private String flagNormalizzato;
      private String flagNormalizzazioneIgnorata;
      private String latitudine;
      private String longitudine;
      @JsonFormat(pattern = DATE_TIME_FORMAT)
      private LocalDateTime dataAggiornamento;
      private String utenteAggiornamento;
      private String codiceComune;
      private String numero;
      private String via;
      private String codiceBelfiore;
      private String codiceISTAT;
      private String cellaCensuaria;
      private String prefissoStrada;
      private String provenienza;
      private BigInteger codiceTipoIndirizzo;
      private BigInteger idSoggetto;
      private String flagMembroFamiglia;
      private String flagIndirizzoPrincipale;
      @JsonFormat(pattern = DATE_TIME_FORMAT)
      private LocalDateTime dataInizio;
      @JsonFormat(pattern = DATE_TIME_FORMAT)
      private LocalDateTime dataFine;
      @JsonFormat(pattern = DATE_TIME_FORMAT)
      private LocalDateTime dataInserimento;
      private String utenteInserimento;
      private String nazione;
      private String localita;
      private String tipoAddress;
}

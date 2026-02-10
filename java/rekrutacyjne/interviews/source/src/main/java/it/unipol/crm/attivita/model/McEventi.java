package it.unipol.crm.attivita.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class McEventi {

    private BigInteger mcEventiId;
    private String entityName;
    private BigInteger idProcesso;
    private BigInteger idAttivita;
    private Timestamp dataOperazione;
    private BigInteger esitoContattoTpCd;
    private String nota;
    private BigInteger sottoEsitoContattoTpCd;
    private String creatoDaUtente;
    private String creatoDaNominativo;
    private BigInteger canaleTpCd;
    private Timestamp dataRecall;
    private BigInteger entityId;
    private String ageEvento;
    private String lastUpdateUser;
}

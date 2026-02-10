package it.unipol.crm.anagrafica.gestione.entity.code;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "UPL_CRM_ANAGRAFICHE_PG")
@NoArgsConstructor
@Data
public class UplCrmAnagrafichePg {
    @Id
    @Column(name = "ID_SOGGETTO")
    private BigInteger idSoggetto;
    
    @Column(name = "CODICE_RAMO")
    private BigInteger codiceramo;
    @Column(name = "CODICE_SETTORE")
    private BigInteger codicesettore;
    @Column(name = "DATA_COSTITUZIONE")
    private Timestamp datacostituzione;
    @Column(name = "CODICE_MERCATO_PREFERENZIALE")
    private BigInteger codicemercatopreferenziale;
    @Column(name = "DATA_AGGIORNAMENTO")
    private Timestamp dataAggiornamento;
    @Column(name = "UTENTE_AGGIORNAMENTO")
    private String utenteAggiornamento;
    @Column(name = "DATA_INSERIMENTO")
    private Timestamp dataInserimento;
    @Column(name = "UTENTE_INSERIMENTO")
    private String utenteInserimento;
    @Column(name = "NOME")
    private String nome;
}

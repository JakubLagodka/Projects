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
@Table(name = "UPL_CRM_ANAGRAFICHE_PF")
@NoArgsConstructor
@Data
public class UplCrmAnagrafichePf {
    @Id
    @Column(name = "ID_SOGGETTO")
    private BigInteger idSoggetto;
    @Column(name = "CODICE_STATO_CIVILE")
    private BigInteger codicestatocivile;
    @Column(name = "CODICE_SETTORE")
    private BigInteger codicesettore;
    @Column(name = "CODICE_MERCATO_PREFERENZIALE")
    private BigInteger codicemercatopreferenziale;
    @Column(name = "SESSO")
    private String sesso;
    @Column(name = "DATA_NASCITA")
    private Timestamp datanascita;
    @Column(name = "DATA_AGGIORNAMENTO")
    private Timestamp dataAggiornamento;
    @Column(name = "UTENTE_AGGIORNAMENTO")
    private String utenteAggiornamento;
    @Column(name = "NOME")
    private String nome;
    @Column(name = "COGNOME")
    private String cognome;
    @Column(name = "NATURA_NOMINATIVO")
    private String naturanominativo;
    @Column(name = "FLAG_STANDARDIZZAZIONE")
    private String flagstandardizzazione;
    @Column(name = "DATA_INSERIMENTO")
    private Timestamp dataInserimento;
    @Column(name = "UTENTE_INSERIMENTO")
    private String utenteInserimento;
}

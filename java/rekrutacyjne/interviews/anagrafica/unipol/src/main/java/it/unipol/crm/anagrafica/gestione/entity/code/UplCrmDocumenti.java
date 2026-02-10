package it.unipol.crm.anagrafica.gestione.entity.code;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "UPL_CRM_DOCUMENTI")
@NoArgsConstructor
@Data
public class UplCrmDocumenti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DOCUMENTO")
    private BigInteger idDocumento;
    @Column(name = "CODICE_STATO_DOCUMENTO")
     private BigInteger         codicestatodocumento;
    @Column(name = "ID_SOGGETTO")
    
     private BigInteger idSoggetto;
    @Column(name = "CODICE_TIPO_DOCUMENTO")
    
     private BigInteger         codicetipodocumento;
    @Column(name = "NUMERO_DOCUMENTO")
     private String numerodocumento;
    @Column(name = "DATA_INIZIO")
    
     private Timestamp dataInizio;
    @Column(name = "DATA_FINE")
     private Timestamp dataFine;
    @Column(name = "DATA_EMISSIONE")
     private Timestamp         dataemissione;
    @Column(name = "DATA_AGGIORNAMENTO")
    
     private Timestamp dataAggiornamento;
    @Column(name = "UTENTE_AGGIORNAMENTO")
     private String         utenteAggiornamento;
    @Column(name = "DESCRIZIONE")
     private String descrizione;
    @Column(name = "LOCALITA_RILASCIO_DOCUMENTO")
     private String         localitarilasciodocumento;
    @Column(name = "DATA_SCADENZA")
     private Timestamp datascadenza;
    @Column(name = "DATA_INSERIMENTO")
    
     private Timestamp         dataInserimento;
    @Column(name = "UTENTE_INSERIMENTO")
     private String utenteInserimento;
}

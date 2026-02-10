package it.unipol.crm.anagrafica.gestione.entity.code;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "UPL_CRM_ANAG_REL")
@NoArgsConstructor
@Data
public class UplCrmAnagRel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ANAG_REL")
     private BigInteger idAnagRel;
    
    @Column(name = "CODICE_TIPO_RELAZIONE")
     private BigInteger         codicetiporelazione;
    @Column(name = "DESCRIZIONE")
     private String descrizione;
    @Column(name = "DATA_INIZIO")
    
     private Timestamp dataInizio;
    @Column(name = "DATA_FINE")
     private Timestamp dataFine;
    @Column(name = "ID_SOGGETTO_ARRIVO")
    
     private BigInteger         contIdarrivo;
    @Column(name = "ID_SOGGETTO_PARTENZA")
    
     private BigInteger contIdpartenza;
    @Column(name = "DATA_AGGIORNAMENTO")
    
     private Timestamp  dataAggiornamento;
    @Column(name = "UTENTE_AGGIORNAMENTO")
     private String utenteAggiornamento;
    @Column(name = "DATA_INSERIMENTO")
    
     private Timestamp         dataInserimento;
    @Column(name = "UTENTE_INSERIMENTO")
     private String utenteInserimento;
}

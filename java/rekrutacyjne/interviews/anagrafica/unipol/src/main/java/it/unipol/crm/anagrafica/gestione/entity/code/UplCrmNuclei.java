package it.unipol.crm.anagrafica.gestione.entity.code;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "UPL_CRM_NUCLEI")
@NoArgsConstructor
@Data
public class UplCrmNuclei {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_NUCLEO")
    private BigInteger idNucleo;
    @Column(name = "CODICE_TIPO_NUCLEO")
    
    private BigInteger         codicetiponucleo;
    @Column(name = "CONTACT")
    
    private String contact;
    @Column(name = "ID_SOGGETTO_CAPOGRUPPO")
    
    private String         idSoggettocapogruppo;
    @Column(name = "RAGIONE_SOCIALE_CAPOGRUPPO")
    private String ragionesocialecapogruppo;
    @Column(name = "DATA_INIZIO")
    
    private Timestamp dataInizio;
    @Column(name = "DATA_FINE")
    private Timestamp dataFine;
    @Column(name = "UTENTE_AGGIORNAMENTO")
    private String         utenteAggiornamento;
    @Column(name = "DATA_AGGIORNAMENTO")
    
    private Timestamp dataAggiornamento;
    @Column(name = "DATA_INSERIMENTO")
    private Timestamp dataInserimento;
    
    @Column(name = "UTENTE_INSERIMENTO")
    private String utenteInserimento;
}

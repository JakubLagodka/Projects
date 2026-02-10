package it.unipol.crm.anagrafica.gestione.entity.code;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "UPL_CRM_ANOMALIE_ANAGRAFICHE")
@NoArgsConstructor
@Data
public class UplCrmAnomalieAnagrafiche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ANOMALIA")
    private BigInteger idAnomalia;
    
    @Column(name = "ID_SOGGETTO")
    private BigInteger idSoggetto;
    @Column(name = "UTENTE_CANCELLAZIONE")
    private String utentecancellazione;
    @Column(name = "UTENTE_INSERIMENTO")
    private String utenteInserimento;
    @Column(name = "CODICE_TIPO_ANOMALIA")
    
    private BigInteger codicetipoanomalia;
    @Column(name = "CODICE_STATO_ANOMALIA")
    private BigInteger codicestatoanomalia;
    @Column(name = "DATA_INIZIO")
    
    private Timestamp dataInizio;
    @Column(name = "DATA_FINE")
    private Timestamp dataFine;
    @Column(name = "PROVENIENZA_ALERT")
    private String provenienzaalert;
    @Column(name = "UTENTE_AGGIORNAMENTO")
    private String         utenteAggiornamento;
    @Column(name = "DATA_AGGIORNAMENTO")
    
    private Timestamp dataAggiornamento;
    @Column(name = "DATA_INSERIMENTO")
    
    private Timestamp dataInserimento;
}

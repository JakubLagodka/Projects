package it.unipol.crm.anagrafica.gestione.entity.code;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "UPL_CRM_OPTOUT")
@NoArgsConstructor
@Data
public class UplCrmOptout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_OPTOUT")
    private BigInteger idOptout;
    @Column(name = "ID_SOGGETTO")
    
    private BigInteger idSoggetto;
    @Column(name = "DATA_INIZIO")
    private Timestamp         dataInizio;
    @Column(name = "DATA_FINE")
    private Timestamp dataFine;
    @Column(name = "AHD_REF")
    private String ahdref;
    @Column(name = "CODICE_TIPO_OPTOUT")
    
    private BigInteger codicetipooptout;
    @Column(name = "UTENTE_AGGIORNAMENTO")
    private String         utenteAggiornamento;
    @Column(name = "DATA_AGGIORNAMENTO")
    
    private Timestamp dataAggiornamento;
    @Column(name = "DATA_INSERIMENTO")
    
    private Timestamp dataInserimento;
    @Column(name = "UTENTE_INSERIMENTO")
    private String utenteInserimento;
}

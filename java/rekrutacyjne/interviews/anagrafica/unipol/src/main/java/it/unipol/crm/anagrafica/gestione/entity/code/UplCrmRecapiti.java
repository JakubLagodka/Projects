package it.unipol.crm.anagrafica.gestione.entity.code;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "UPL_CRM_RECAPITI")
@NoArgsConstructor
@Data
public class UplCrmRecapiti {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RECAPITO")
    private BigInteger idRecapito;
    @Column(name = "CODICE_TIPO_RECAPITO")
    private BigInteger         codicetiporecapito;
    @Column(name = "RECAPITO")
    private String recapito;
    @Column(name = "DATA_AGGIORNAMENTO")
    private Timestamp dataAggiornamento;
    @Column(name = "UTENTE_AGGIORNAMENTO")
    private String         utenteAggiornamento;
    @Column(name = "CODICE_USO_RECAPITO")
    private BigInteger codiceusorecapito;
    @Column(name = "PROVENIENZA_RECAPITO")
    private String         provenienzarecapito;
    @Column(name = "ID_SOGGETTO")
    private BigInteger idSoggetto;
    @Column(name = "FLAG_MEMBRO_FAMIGLIA")
    private String         flagmembroFamiglia;
    @Column(name = "FLAG_PREFERITO")
    private String flagpreferito;
    @Column(name = "DATA_INIZIO")
    
    private Timestamp dataInizio;
    @Column(name = "DATA_FINE")
    private Timestamp         dataFine;

    @Column(name = "DATA_INSERIMENTO")
    private Timestamp dataInserimento;
    @Column(name = "UTENTE_INSERIMENTO")
    private String utenteInserimento;
}

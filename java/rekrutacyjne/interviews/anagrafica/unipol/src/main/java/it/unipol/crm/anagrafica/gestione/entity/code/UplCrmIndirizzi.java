package it.unipol.crm.anagrafica.gestione.entity.code;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "UPL_CRM_INDIRIZZI")
@NoArgsConstructor
@Data
public class UplCrmIndirizzi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_INDIRIZZO")
    private BigInteger idIndirizzo;
    @Column(name = "NAZIONE")
    private BigInteger         nazione;
    @Column(name = "FLAG_PROVENIENZA_BANCA")
    private BigInteger flagProvenienzaBanca;
    @Column(name = "SIGLA_PROVINCIA")
    private BigInteger         siglaProvincia;
    @Column(name = "INDIRIZZO")
    
    private String         indirizzo;
    @Column(name = "LOCALITA")
    private String localita;
    @Column(name = "CRC")
    private String         crc;
    @Column(name = "COMUNE")
    
    private String comune;
    @Column(name = "CAP")
    private String         cap;
    @Column(name = "FLAG_NORMALIZZATO")
    private String flagNormalizzato;
    @Column(name = "FLAG_NORMALIZZAZIONE_IGNORATA")
    private String flagNormalizzazioneIgnorata;
    @Column(name = "LATITUDINE")
    private String         latitudine;
    @Column(name = "LONGITUDINE")
    private String longitudine;
    @Column(name = "DATA_AGGIORNAMENTO")
    
    private Timestamp dataAggiornamento;
    @Column(name = "UTENTE_AGGIORNAMENTO")
    private String utenteAggiornamento;
    @Column(name = "CAP_RESIDENZA_DOMICILIO")
    private String         capResidenzaDomicilio;
    @Column(name = "NUMERO")
    private String numero;
    @Column(name = "VIA")
    private String via;
    @Column(name = "CODICE_BELFIORE")
    private String         codicebelfiore;
    @Column(name = "CODICE_ISTAT")
    private String codiceistat;
    @Column(name = "CELLA_CENSUARIA")
    private String         cellacensuaria;
    @Column(name = "PREFISSO_STRADA")
    private String prefissostrada;
    @Column(name = "PROVENIENZA")
    private String         provenienza;
    @Column(name = "TIPO_INDIRIZZO")
    
    private BigInteger tipoindirizzo;
    @Column(name = "ID_SOGGETTO")
    
    private BigInteger idSoggetto;
    @Column(name = "FLAG_MEMBRO_FAMIGLIA")
    private String         flagmembroFamiglia;
    @Column(name = "FLAG_INDIRIZZO_PRINCIPALE")
    private String flagindirizzoprincipale;
    @Column(name = "TIPO_ADDRESS")
    
    private String         tipoaddress;
    @Column(name = "DATA_INIZIO")
    
    private Timestamp dataInizio;
    @Column(name = "DATA_FINE")
    private Timestamp         dataFine;
    @Column(name = "DATA_INSERIMENTO")
    private Timestamp dataInserimento;
    @Column(name = "UTENTE_INSERIMENTO")
    
    private String utenteInserimento;
}

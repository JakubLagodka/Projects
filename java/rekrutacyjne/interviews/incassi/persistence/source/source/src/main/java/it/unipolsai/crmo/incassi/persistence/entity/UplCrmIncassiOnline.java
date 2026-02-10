package it.unipolsai.crmo.incassi.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "UPL_CRM_INCASSI_ONLINE")
public class UplCrmIncassiOnline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INCASSO_ID")
    private BigInteger incassoId;

    @Column(name = "TIPO_RECORD")
    private String tipoRecord;

    @Column(name = "COMPAGNIA")
    private String compagnia;

    @Column(name = "AGENZIA")
    private String agenzia;

    @Column(name = "RAMO_POLIZZA")
    private String ramoPolizza;

    @Column(name = "NUMERO_POLIZZA")
    private String numeroPolizza;

    @Column(name = "NUMERO_APPENDICE")
    private String numeroAppendice;

    @Column(name = "DATA_EFFETTO_APPENDICE")
    private Date dataEffettoAppendice;

    @Column(name = "DATA_EFFETTO_TITOLO")
    private Date dataEffettoTitolo;

    @Column(name = "TIME_OPERAZIONE")
    private String timeOperazione;

    @Column(name = "DATA_SCADENZA_TITOLO")
    private Date dataScadenzaTitolo;

    @Column(name = "TIPO_CARICO")
    private String tipoCarico;

    @Column(name = "TIPO_MATRICOLA")
    private String tipoMatricola;

    @Column(name = "RAMO_GESTIONE")
    private String ramoGestione;

    @Column(name = "CODICE_ESITO")
    private String codiceEsito;

    @Column(name = "TIPO_PAGAMENTO")
    private String tipoPagamento;

    @Column(name = "TRANSAZIONE")
    private String transazione;

    @Column(name = "PREMIO_NETTO")
    private BigDecimal premioNetto;

    @Column(name = "INTERESSI_FRAZ")
    private BigDecimal interessiFraz;

    @Column(name = "ACCESSORI")
    private BigDecimal accessori;

    @Column(name = "PREMIO_TOTALE")
    private BigDecimal premioTotale;

    @Column(name = "PROVV_ACQUISTO_RATA_CONT")
    private BigDecimal provvAcquistoRataCont;

    @Column(name = "PROVV_ACQUISTO_RATE_SUCC")
    private BigDecimal provvAcquistoRateSucc;

    @Column(name = "PROVV_INCASSO")
    private BigDecimal provvIncasso;

    @Column(name = "PREMIO_TASS_NEW")
    private BigDecimal premioTassNew;

    @Column(name = "PREMIO_TASS_OLD")
    private BigDecimal premioTassOld;

    @Column(name = "CANONE_UNIBOX")
    private BigDecimal canoneUnibox;

    @Column(name = "DATA_FOGLIO_CASSA")
    private Date dataFoglioCassa;

    @Column(name = "PRODOTTO")
    private String prodotto;

    @Column(name = "TITOLO_ID")
    private String titoloId;

    @Column(name = "TIPO_QUIET")
    private String tipoQuiet;

    @Column(name = "DATA_RETTIFICA")
    private Date dataRettifica;

    @Column(name = "LAST_UPDATE_DT")
    private Timestamp lastUpdateDt;

    @Column(name = "LAST_UPDATE_USER")
    private String lastUpdateUser;

    @Column(name = "TIPO_FORMULA")
    private String tipoFormula;

    @Column(name = "GAR_ASS_PLUS")
    private String garAssPlus;

    @Column(name = "MULTI_OFFERTA")
    private String multiOfferta;

    @Column(name = "NUM_PREVENTIVO")
    private String numPreventivo;

    @Column(name = "NUM_PREVENTIVO_VERS")
    private String numPreventivoVers;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CONTRAENTE")
    private String contraente;

    @Column(name = "INDIRIZZO")
    private String indirizzo;

    @Column(name = "CO")
    private String co;

    @Column(name = "PROVINCIA")
    private String provincia;

    @Column(name = "COMUNE")
    private String comune;

    @Column(name = "CAP")
    private String cap;

    @Column(name = "NAZIONE")
    private String nazione;

    @Column(name = "DATA_EFFETTIVO_PAGAMENTO")
    private Date dataEffettivoPagamento;

    @Column(name = "TIPO_CARICO_DECODIFICATO")
    private String tipoCaricoDecodificato;

    @Column(name = "ID_FOLDER")
    private BigInteger idFolder;
}

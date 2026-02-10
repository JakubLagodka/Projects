package it.unipolsai.crmo.incassi.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;

@Data
@MappedSuperclass
public abstract class UplCrmArretratiCommon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ARRETRATO")
    private BigInteger idArretrato;

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "COMPAGNIA")
    private String compagnia;

    @Column(name = "AGENZIA_MADRE")
    private String agenziaMadre;

    @Column(name = "AGENZIA_FIGLIA")
    private String agenziaFiglia;

    @Column(name = "RAMO")
    private String ramo;

    @Column(name = "POLIZZA")
    private String polizza;

    @Column(name = "SUBAG")
    private String subag;

    @Column(name = "CONVEN")
    private String conven;

    @Column(name = "CONTRACT_ID")
    private BigInteger contractId;

    @Column(name = "CONT_ID")
    private BigInteger contId;

    @Column(name = "DATA_EFFETTO_APP")
    private Timestamp dataEffettoApp;

    @Column(name = "NUM_APP")
    private String numApp;

    @Column(name = "DATA_EFFETTO_TITOLO")
    private Timestamp dataEffettoTitolo;

    @Column(name = "TIPO_CARICO")
    private String tipoCarico;

    @Column(name = "TIPO_MAT")
    private String tipoMat;

    @Column(name = "ESITO")
    private String esito;

    @Column(name = "TIPO_PAG")
    private String tipoPag;

    @Column(name = "DATA_ESITO")
    private Timestamp dataEsito;

    @Column(name = "TASSABILE")
    private BigDecimal tassabile;

    @Column(name = "TOTALE")
    private BigDecimal totale;

    @Column(name = "PR_ACQ")
    private BigDecimal prAcq;

    @Column(name = "PR_INC")
    private BigDecimal prInc;

    @Column(name = "COD_DEL")
    private String codDel;

    @Column(name = "LAST_UPDATE_DT")
    private Timestamp lastUpdateDt;

    @Column(name = "LAST_UPDATE_USER")
    private String lastUpdateUser;

    @Column(name = "NUMERO_ARCHIVIO")
    private String numeroArchivio;

    @Column(name = "IMPORTO_CANONE")
    private BigDecimal importoCanone;

    @Column(name = "FLAG_RID")
    private String flagRid;

    @Column(name = "FLAG_VAR_SCAD")
    private String flagVarScad;

    @Column(name = "PREMIO")
    private BigDecimal premio;

    @Column(name = "TITOLO_A_LEGALE")
    private String titoloALegale;

    @Column(name = "FLAG_MULTIOFFERTA")
    private String flagMultiofferta;

    @Column(name = "ID_TITOLO")
    private String idTitolo;

    @Column(name = "FLAG_INSOLUTO")
    private String flagInsoluto;

    @Column(name = "MOTIVO_INSOLUTO")
    private String motivoInsoluto;

    @Column(name = "MOD_PAGAMENTO")
    private String modPagamento;

    @Column(name = "QUIETANZA_A_SCADENZA")
    private String quietanzaAScadenza;

    @Column(name = "ADDEB_AUTOMATICO")
    private String addAutomatico;

    @Column(name = "ID_FOLDER")
    private BigInteger idFolder;

    @Column(name = "APPENDICE_FOLDER")
    private BigDecimal appendiceFolder;

    @Column(name = "ATTR_TIPO_CARICO")
    private String attrTipoCarico;

    @Column(name = "ASSICURATO")
    private String assicurato;

    @Column(name = "LOB")
    private BigDecimal lob;

    @Column(name = "FLAG_REMUN")
    private String flagRemun;

    @Column(name = "TITOLO_ID_COLLEGAMENTO")
    private BigInteger titoloIdCollegamento;

    @Column(name = "CAUSALE_COLLEGAMENTO")
    private BigDecimal causaleCollegamento;

    @Column(name = "FLAG_CICLO_PREMI")
    private String flagCicloPremi;

    @Column(name = "MOMENTO_CHIAVE")
    private String momentoChiave;

    @Column(name = "TIPO_SCONTRINO")
    private String tipoScontrino;
}

package it.unipol.crm.anagrafica.gestione.entity.code;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "UPL_CRM_DATI_SOCIOECONOMICI_PF")
@NoArgsConstructor
@Data
public class UplCrmDatiSocioeconomiciPf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DATI_SOCIOECONOMICI_PF")
    private BigInteger idDatiSocioeconomiciPf;
    @Column(name = "ID_SOGGETTO")
    
    private BigInteger idSoggetto;
    @Column(name = "COMPAGNIA")
   private String         compagnia;
    @Column(name = "DATA_AGGIORNAMENTO")
   private Timestamp dataAggiornamento;
    @Column(name = "STATO_CIVILE")
   private String statocivile;
    @Column(name = "FLAG_FIGLI")
   private String flagfigli;
    @Column(name = "ANNO_FIGLIO_1")
   private String annoFiglio1;
    @Column(name = "ANNO_FIGLIO_2")
   private String annoFiglio2;
    @Column(name = "ANNO_FIGLIO_3")
   private String annoFiglio3;
    @Column(name = "ANNO_FIGLIO_4")
   private String annoFiglio4;
    @Column(name = "TITOLO_STUDIO")
   private String titolostudio;
    @Column(name = "INT_FAIDATE")
   private String intfaIdate;
    @Column(name = "INT_MUSICA")
   private String intmusica;
    @Column(name = "INT_LETTURA")
   private String intlettura;
    @Column(name = "INT_TECNO")
   private String         inttecno;
    @Column(name = "INT_SPORT")
   private String intsport;
    @Column(name = "INT_VIAGGI")
   private String intviaggi;
    @Column(name = "INT_SALUTE")
   private String intsalute;
    @Column(name = "INT_NATURA")
   private String intnatura;
    @Column(name = "INT_VOLONT")
   private String intvolont;
    @Column(name = "INT_FOTO")
   private String intfoto;
    @Column(name = "INT_MOTORI")
   private String intmotori;
    @Column(name = "INT_ENOGAS")
   private String intenogas;
    @Column(name = "INET_LAVORO")
   private String inetlavoro;
    @Column(name = "INET_SOCIAL")
   private String inetsocial;
    @Column(name = "INET_ACQUISTI")
   private String inetacquisti;
    @Column(name = "INET_APPL")
   private String         inetappl;
    @Column(name = "CASA_PROPR")
   private String casapropr;
    @Column(name = "CASA_AFFITTO")
   private String casaaffitto;
    @Column(name = "CASA_SECONDA")
   private String casaseconda;
    @Column(name = "CASA_MUTUO")
   private String casamutuo;
    @Column(name = "TIPO_RISPARMIATORE")
   private String tiporisparmiatore;
    @Column(name = "INFO_RISP_AUTO")
   private String inforispauto;
    @Column(name = "INFO_INT_PENS")
   private String infointpens;
    @Column(name = "INFO_RISP_NO_RISCHI")
   private String inforispnorischi;
    @Column(name = "INFO_STUDIO_FIGLI")
   private String infostudiofigli;
    @Column(name = "INFO_REND_CAP")
   private String inforendcap;
    @Column(name = "INFO_EREDITA")
   private String infoeredita;
    @Column(name = "INFO_ASSISTENZA")
   private String infoassistenza;
    @Column(name = "INFO_TERREMOTO")
   private String         infoterremoto;
    @Column(name = "INFO_DANNI")
   private String infoDanni;
    @Column(name = "INFO_INDENNIZZO")
   private String infoindennizzo;
    @Column(name = "INFO_PERDITA_IMPIEGO")
   private String infoperditaimpiego;
    @Column(name = "PREV_CAMBIO_AUTO")
   private String prevcambioauto;
    @Column(name = "PREV_PENSIONE")
   private String prevpensione;
    @Column(name = "PREV_MUTUO")
   private String prevmutuo;
    @Column(name = "PREV_NUOVA_ATT")
   private String prevnuovaatt;
    @Column(name = "PREV_PROMOZIONE")
   private String prevpromozione;
    @Column(name = "PREV_VACANZA")
   private String prevvacanza;
    @Column(name = "PREV_FINE_STUDIO_FIGLI")
   private String prevFinestudiofigli;
    @Column(name = "PREV_CAMBIO_CASA")
   private String prevcambiocasa;
    @Column(name = "UTENTE_AGGIORNAMENTO")
    private String         utenteAggiornamento;
    @Column(name = "FLAG_CONIUGE_CARICO")
    private String flagconiugecarico;
    @Column(name = "NUM_FIGLI_CARICO")
    private Integer numfiglicarico;
    @Column(name = "DATA_INIZIO_ATT_LAV")
    private Date dataInizioattlav;
    @Column(name = "CATPREV_TP_CD")
    private BigInteger codiceprofessione;
    @Column(name = "REDDITO_NETTO_LAV")
    private BigDecimal redditonettolav;
    @Column(name = "REDDITO_LAV_STIMATO")
    private BigDecimal redditolavstimato;
    @Column(name = "EVOL_REDDITO_LAV")
    private Integer evolredditolav;
    @Column(name = "REDDITO_NETTO_ALTRO")
    private BigDecimal redditonettoaltro;
    @Column(name = "EVOL_REDDITO_ALTRO")
    private Integer evolredditoaltro;
    @Column(name = "SPESE_INCOMPRIMIBILI")
    private BigDecimal speseincomprimibili;
    @Column(name = "SPESE_INCOMPRIMIBILI_STIMATO")
    private BigDecimal speseincomprimibilistimato;
    @Column(name = "SPESE_COMPRIMIBILI")
    private BigDecimal spesecomprimibili;
    @Column(name = "SPESE_COMPRIMIBILI_STIMATO")
    private BigDecimal spesecomprimibilistimato;
    @Column(name = "TREND_ATTESO_SPESE")
    private Integer trendattesospese;
    @Column(name = "TIPO_ATTIVITA")
    private String tipoAttivita;
    @Column(name = "APPLICAZIONE")
    private String applicazione;
    @Column(name = "DT_NAS_FIGLIO_1")
    private Date dtnasFiglio1;
    @Column(name = "DT_NAS_FIGLIO_2")
    private Date dtnasFiglio2;
    @Column(name = "DT_NAS_FIGLIO_3")
    private Date dtnasFiglio3;
    @Column(name = "DT_NAS_FIGLIO_4")
    private Date dtnasFiglio4;
    @Column(name = "DT_NAS_CONIUGE")
    private Date dtnasconiuge;
    @Column(name = "NR_NUCLEO_FAMILIARI")
    private Integer nrnucleofamiliari;
    @Column(name = "FLAG_ANIMALI_DOMEST")
    private String flaganimalIdomest;
    @Column(name = "FLAG_COLLABORI_DOMEST")
    private String flagcollaborIdomest;
    @Column(name = "DATA_INSERIMENTO")
    
    private Timestamp dataInserimento;
    @Column(name = "UTENTE_INSERIMENTO")
    private String utenteInserimento;
}

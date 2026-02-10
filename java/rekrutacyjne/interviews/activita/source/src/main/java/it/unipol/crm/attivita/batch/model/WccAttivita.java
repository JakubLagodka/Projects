package it.unipol.crm.attivita.batch.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "WCC_ATTIVITA")
public class WccAttivita {

    @Id
    @Column(name = "REQUEST_ID")
    private BigInteger requestId;

    @Column(name = "COD_ISTITUTO")
    private Integer codIstituto;

    @Column(name = "TIPO_OPERAZIONE")
    private String tipoOperazione;

    @Column(name = "FLG_CARICATO")
    private Integer flgCaricato;

    @Column(name = "UPD_TIMESTAMP")
    private Timestamp updTimestamp;

    @Column(name = "INS_TIMESTAMP")
    private Timestamp insTimestamp;

    @Column(name = "PROVENIENZA")
    private String provenienza;

    @Column(name = "ATTIVITA_ID")
    private BigInteger attivitaId;

    @Column(name = "SISTEMA_ID")
    private String sistemaId;

    @Column(name = "TIPOATTIVITA_ID")
    private BigInteger tipoAttivitaId;

    @Column(name = "ATTIVITA_CLIENTE")
    private String attivitaCliente;

    @Column(name = "CREATO_DA_TIPO")
    private String creatoDaTipo;

    @Column(name = "CREATO_DA_UTENTE")
    private String creatoDaUtente;

    @Column(name = "CREATO_DA_NOMINATIVO")
    private String creatoDaNominativo;

    @Column(name = "COMPAGNIA")
    private String compagnia;

    @Column(name = "AGENZIA_MADRE")
    private String agenziaMadre;

    @Column(name = "AGENZIA_FIGLIA")
    private String agenziaFiglia;

    @Column(name = "CFPIVA_CLIENTE")
    private String cfpivaCliente;

    @Column(name = "CONT_ID")
    private BigInteger contId;

    @Column(name = "CONTEXT_ID")
    private String contextId;

    @Column(name = "REGOLA_ASSEGNAZIONE")
    private String regolaAssegnazione;

    @Column(name = "PRIORITA")
    private String priorita;

    @Column(name = "ATTIVITA_ST_TP_CD")
    private BigInteger attivitaStTpCd;

    @Column(name = "AVVIO_DT")
    private Timestamp avvioDt;

    @Column(name = "SCADENZA_DT")
    private Timestamp scadenzaDt;

    @Column(name = "COMPLETATA_DT")
    private Timestamp completataDt;

    @Column(name = "FINE_DT")
    private Timestamp fineDt;

    @Column(name = "RIAPERTURA")
    private Integer riapertura;

    @Column(name = "RIAPERTURA_DT")
    private Timestamp riaperturaDt;

    @Column(name = "ESCALATION")
    private String escalation;

    @Column(name = "ESCALATION_DT")
    private Timestamp escalationDt;

    @Column(name = "ASSEGNATORE")
    private String assegnatore;

    @Column(name = "ASSEGNATORE_DESC")
    private String assegnatoreDesc;

    @Column(name = "ASSEGNAZIONE")
    private String assegnazione;

    @Column(name = "ASSEGNATARIO")
    private String assegnatario;

    @Column(name = "ASSEGNATARIO_DESC")
    private String assegnatarioDesc;

    @Column(name = "FLAG_ANNOTAZIONE")
    private String flagAnnotazione;

    @Column(name = "ANNOTAZIONE")
    private String annotazione;

    @Column(name = "CHIUSA_SCADUTA")
    private String chiusaScaduta;

    @Column(name = "DELEGA_CC")
    private String delegaCc;

    @Column(name = "DELEGA_CC_ABILITATA")
    private String delegaCcAbilitata;

    @Column(name = "DELEGA_CC_INIZIALE")
    private String delegaCcIniziale;

    @Column(name = "GESTIONE_MC")
    private String gestioneMc;

    @Column(name = "ID_PROCESSO")
    private BigInteger idProcesso;

    @Column(name = "INDICATORE_ICONA")
    private Integer indicatoreIcona;

    @Column(name = "LAST_UPDATE_DT")
    private String lastUpdateDt;

}

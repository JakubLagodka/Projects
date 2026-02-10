package it.unipol.crm.anagrafica.gestione.entity.code;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "UPL_CRM_ANAGRAFICHE")
@NoArgsConstructor
@Data
public class UplCrmAnagrafiche {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SOGGETTO")
    private BigInteger idSoggetto;
    @Column(name = "TIPO_NDG")
    private BigInteger         tipondg;
        @Column(name = "CODICE_LINGUA_PREFERITA")
    private BigInteger codicelinguapreferita;
        @Column(name = "DATA_CREAZIONE")

    private Timestamp datacreazione;
        @Column(name = "DATA_INATTIVAZIONE")
    private Timestamp datainattivazione;
        @Column(name = "LUOGO_NASCITA")
    private String         luogonascita;
        @Column(name = "TIPO_PERSONA")
   
    private String tipopersona;
        @Column(name = "FLAG_AFFIDATO")
    private String flagaffIdato;
        @Column(name = "CODICE_SEGMENTO_CLIENTELA")
    private BigInteger         codicesegmentoclientela;
        @Column(name = "CODICE_STATO_CLIENTE")
    private BigInteger codicestatocliente ;
        @Column(name = "CODICE_TIPO_ANAGRAFE")
    private BigInteger         codicetipoanagrafe ;
        @Column(name = "CODICE_PROFESSIONE")
    private BigInteger codiceprofessione;
        @Column(name = "DATA_AGGIORNAMENTO")
   
    private Timestamp dataAggiornamento ;
        @Column(name = "UTENTE_AGGIORNAMENTO")
    private String         utenteAggiornamento ;
        @Column(name = "CODICE_TIPO_SOFFERENZA")
    private BigInteger codicetiposofferenza ;
        @Column(name = "DATA_REGISTRAZIONE")
    private Timestamp         dataregistrazione ;
        @Column(name = "COGNOME_O_RAGIONE_SOCIALE")
    private String cognomeoragionesociale ;
        @Column(name = "NOME")
    private String         nome ;
        @Column(name = "CONSENSO_BANCA")
    private BigInteger consensobanca ;
        @Column(name = "DATA_CONSENSO_BANCA")
    private LocalDate dataconsensobanca ;
        @Column(name = "DATA_REVOCA_CONSENSO_BANCA")
    private LocalDate datarevocaconsensobanca ;
        @Column(name = "CONSENSO_ASSIC")
    private BigInteger         consensoassic;
        @Column(name = "DATA_CONSENSO_ASSIC")
    private LocalDate dataconsensoassic ;
        @Column(name = "DATA_REVOCA_CONSENSO_ASSIC")
    private LocalDate         datarevocaconsensoassic ;
        @Column(name = "MATRICOLA_RESP_CLIENTE")
    private String matricolarespcliente;
        @Column(name = "CITTADINANZA")
    private String         cittadinanza ;
        @Column(name = "DATI_CCIAA")
    private String         daticciaa ;
        @Column(name = "INCAGLIO_SOFFERENZA")
    private BigInteger incagliosofferenza ;
        @Column(name = "FLAG_CAPOFAMIGLIA")
    private String         flagcapoFamiglia ;
        @Column(name = "FLAG_CAPOGRUPPO")
    private String flagcapogruppo ;
        @Column(name = "PREMI_ANNO_CORRENTE")
    private BigDecimal premiannocorrente ;
        @Column(name = "LIQUIDATO_ANNO_CORRENTE")
    private BigDecimal liquIdatoannocorrente ;
        @Column(name = "RISERVATO_ANNO_CORRENTE")
    private BigDecimal         riservatoannocorrente ;
        @Column(name = "PREMI_ANNO_PRECEDENTE")
    private BigDecimal premiannoprecedente;
        @Column(name = "LIQUIDATO_ANNO_PRECEDENTE")
    private BigDecimal         liquIdatoannoprecedente ;
        @Column(name = "RISERVATO_ANNO_PRECEDENTE")
    private BigDecimal riservatoannoprecedente ;
        @Column(name = "PREMI_TOTALE")
    private BigDecimal         premitotale ;
        @Column(name = "LIQUIDATO_TOTALE")
    private BigDecimal liquIdatototale ;
        @Column(name = "RISERVATO_TOTALE")
    private BigDecimal         riservatototale ;
        @Column(name = "FLAG_AUTORIZZAZIONE_FEA")
    private String flagautorizzazionefea ;
        @Column(name = "DATA_AUTORIZZAZIONE_FEA")
    private LocalDate         dataautorizzazionefea ;
        @Column(name = "TIPO_COD_ATECO")
    private String tipocoLocalDateco ;
        @Column(name = "COD_ATECO")
    private String         coLocalDateco ;
        @Column(name = "FLAG_CORPORATE")
    private String flagcorporate ;
        @Column(name = "NUM_DIPENDENTI_ATECO")
    private String         numdipendentiateco ;
        @Column(name = "FATTURATO_ATECO")
    private String fatturatoateco ;
        @Column(name = "DT_ULTIMO_STORNO")
    private LocalDate dtultimostorno ;
        @Column(name = "CANALE_PRIVACY")
    private String         canaleprivacy ;
        @Column(name = "CANALE_REVOCA_PRIVACY")
    private String canalerevocaprivacy ;
        @Column(name = "COD_OPTOUT")
    private String         codoptout ;
        @Column(name = "DT_INIZIO_OPTOUT")
    private LocalDate dtiniziooptout ;
        @Column(name = "CANALE_INIZIO_OPTOUT")
    private String         canaleiniziooptout ;
        @Column(name = "DT_FINE_OPTOUT")
    private LocalDate dtFineoptout ;
        @Column(name = "CANALE_FINE_OPTOUT")
    private String         canaleFineoptout ;
        @Column(name = "CONS_TP_CD")
    private BigInteger constpcd ;
    @Column(name = "DT_MODIFICA_CONS")
    private LocalDate         dtmodificacons;
        @Column(name = "CANALE_MODIFICA_CONS")
    private String canalemodificacons ;
        @Column(name = "DATA_ESTENSIONE_PRIVACY")
    private LocalDate dataestensioneprivacy ;
        @Column(name = "RIFIUTO_LOYALTY_PROGRAM")
    private String         rifiutoloyaltyprogram ;
        @Column(name = "DATA_RIFIUTO_LOYALTY_PROGRAM")
    private Timestamp datarifiutoloyaltyprogram ;
        @Column(name = "DATA_CONSENSO_ASSIC_TS")
    private Timestamp         dataconsensoassicts ;
        @Column(name = "DATA_REG_CONSENSO_ASSIC_TS")
    private Timestamp dataregconsensoassicts ;
        @Column(name = "DATA_REVOCA_CONSENSO_ASSIC_TS")
    private Timestamp         datarevocaconsensoassicts ;
        @Column(name = "ATECO_FSOC")
    private String atecofsoc ;
        @Column(name = "ATECO_AE_GRUPPO")
    private String         atecoaegruppo ;
        @Column(name = "ATECO_AE_SOTTOGRUPPO")
    private String atecoaesottogruppo ;
        @Column(name = "ATECO_AE_UIC")
    private String         atecoaeuic;
        @Column(name = "CANALE_TP_CD")
    private BigInteger canaletpcd ;
        @Column(name = "VALORE_CLIENTE")
    private String         valorecliente ;
        @Column(name = "INDICE_PROPENSIONE")
    private String indicepropensione ;
        @Column(name = "CLIENTE_VIP")
    private String         clientevip ;
        @Column(name = "UTENTE_AUTORIZZAZIONE_FEA")
    private String utenteautorizzazionefea;
        @Column(name = "DATA_INSERIMENTO")
    private Timestamp dataInserimento ;
    @Column(name = "UTENTE_INSERIMENTO")
    private String         utenteInserimento;
}

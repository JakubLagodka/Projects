package it.unipol.crm.anagrafica.gestione.entity.code;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "UPL_CRM_DATI_SOCIOECONOMICI_PF_ERRORI")
@NoArgsConstructor
@Data
public class UplCrmDatiSocioeconomiciPfErrori {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DATI_SOCIOECONOMICI_PF_ERRORI")
    private BigInteger idDatiSocioeconomiciPfErrori;
    @Column(name = "ID_SOGGETTO")
     private BigInteger idSoggetto;
    @Column(name = "COMPAGNIA")
     private String         compagnia;
    @Column(name = "DATA_AGGIORNAMENTO")
     private Timestamp dataAggiornamento;
    @Column(name = "STATO_CIVILE_F")
     private String statocivilef;
    @Column(name = "FLAG_FIGLI_F")
     private String flagfiglif;
    @Column(name = "ANNO_FIGLIO_1_F")
     private String annoFiglio1f;
    @Column(name = "ANNO_FIGLIO_2_F")
     private String annoFiglio2f;
    @Column(name = "ANNO_FIGLIO_3_F")
     private String annoFiglio3f;
    @Column(name = "ANNO_FIGLIO_4_F")
     private String annoFiglio4f;
    @Column(name = "TITOLO_STUDIO_F")
     private String titolostudiof;
    @Column(name = "INT_FAIDATE_F")
     private String intfaIdatef;
    @Column(name = "INT_MUSICA_F")
     private String intmusicaf;
    @Column(name = "INT_LETTURA_F")
     private String intletturaf;
    @Column(name = "INT_TECNO_F")
     private String         inttecnof;
    @Column(name = "INT_SPORT_F")
     private String intsportf;
    @Column(name = "INT_VIAGGI_F")
     private String intviaggif;
    @Column(name = "INT_SALUTE_F")
     private String intsalutef;
    @Column(name = "INT_NATURA_F")
     private String intnaturaf;
    @Column(name = "INT_VOLONT_F")
     private String intvolontf;
    @Column(name = "INT_FOTO_F")
     private String intfotof;
    @Column(name = "INT_MOTORI_F")
     private String intmotorif;
    @Column(name = "INT_ENOGAS_F")
     private String intenogasf;
    @Column(name = "INET_LAVORO_F")
     private String inetlavorof;
    @Column(name = "INET_SOCIAL_F")
     private String inetsocialf;
    @Column(name = "INET_ACQUISTI_F")
     private String inetacquistif;
    @Column(name = "INET_APPL_F")
     private String         inetapplf;
    @Column(name = "CASA_PROPR_F")
     private String casaproprf;
    @Column(name = "CASA_AFFITTO_F")
     private String casaaffittof;
    @Column(name = "CASA_SECONDA_F")
     private String casasecondaf;
    @Column(name = "CASA_MUTUO_F")
     private String casamutuof;
    @Column(name = "TIPO_RISPARMIATORE_F")
     private String tiporisparmiatoref;
    @Column(name = "INFO_RISP_AUTO_F")
     private String inforispautof;
    @Column(name = "INFO_INT_PENS_F")
     private String infointpensf;
    @Column(name = "INFO_RISP_NO_RISCHI_F")
     private String inforispnorischif;
    @Column(name = "INFO_STUDIO_FIGLI_F")
     private String infostudiofiglif;
    @Column(name = "INFO_REND_CAP_F")
     private String inforendcapf;
    @Column(name = "INFO_EREDITA_F")
     private String infoereditaf;
    @Column(name = "INFO_ASSISTENZA_F")
     private String infoassistenzaf;
    @Column(name = "INFO_TERREMOTO_F")
     private String         infoterremotof;
    @Column(name = "INFO_DANNI_F")
     private String infoDannif;
    @Column(name = "INFO_INDENNIZZO_F")
     private String infoindennizzof;
    @Column(name = "INFO_PERDITA_IMPIEGO_F")
     private String infoperditaimpiegof;
    @Column(name = "PREV_CAMBIO_AUTO_F")
     private String prevcambioautof;
    @Column(name = "PREV_PENSIONE_F")
     private String prevpensionef;
    @Column(name = "PREV_MUTUO_F")
     private String prevmutuof;
    @Column(name = "PREV_NUOVA_ATT_F")
     private String prevnuovaattf;
    @Column(name = "PREV_PROMOZIONE_F")
     private String prevpromozionef;
    @Column(name = "PREV_VACANZA_F")
     private String prevvacanzaf;
    @Column(name = "PREV_FINE_STUDIO_FIGLI_F")
     private String prevFinestudiofiglif;
    @Column(name = "PREV_CAMBIO_CASA_F")
     private String prevcambiocasaf;
    @Column(name = "REC_CELLULARE_F")
     private String reccellularef;
    @Column(name = "REC_TELEFONO_F")
     private String rectelefonof;
    @Column(name = "REC_FAX_F")
     private String recfaxf;
    @Column(name = "REC_MAIL_F")
     private String recmailf;
    @Column(name = "PROFESSIONE_F")
     private String professionef;
    @Column(name = "FIRMA_1_F")
     private String firma1f;
    @Column(name = "FIRMA_2_F")
     private String firma2f;
    @Column(name = "LOG_ERRORI")
     private String logerrori;
    @Column(name = "UTENTE_AGGIORNAMENTO")
     private String utenteAggiornamento;
    @Column(name = "DATA_INSERIMENTO")
     private Timestamp dataInserimento;
    @Column(name = "UTENTE_INSERIMENTO")
     private String utenteInserimento;
}

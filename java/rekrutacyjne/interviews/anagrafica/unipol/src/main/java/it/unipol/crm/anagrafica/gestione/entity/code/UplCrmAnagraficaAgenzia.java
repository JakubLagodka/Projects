package it.unipol.crm.anagrafica.gestione.entity.code;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "UPL_CRM_ANAGRAFICA_AGENZIA")
@NoArgsConstructor
@Data
public class UplCrmAnagraficaAgenzia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ANAGRAFICA_AGENZIA")
    private BigInteger idAnagraficaAgenzia;
    
     @Column(name = "ID_SOGGETTO")
    private BigInteger         idSoggetto;
     @Column(name = "RETE_VENDITA_DI_PROVENIENZA")

    private String retevenditadiprovenienza;
     @Column(name = "AGENZIA_MADRE_ASSICURATIVA")

    private String         agenziamadreassicurativa;
     @Column(name = "AGENZIA_PREVALENTE")
    private String agenziaprevalente;
     @Column(name = "DATA_INSERIMENTO")
    private Timestamp dataInserimento;
     @Column(name = "DATA_CESSAZIONE_CLIENTE")
    private Date datacessazionecliente;
     @Column(name = "STATO_CLIENTE_AGENZIA")
    private String         statoclienteagenzia;
     @Column(name = "FLAG_CLIENTE_TOP")
    private String flagclientetop;
     @Column(name = "DATA_CLIENTE_TOP")
    private Date         dataclientetop;
     @Column(name = "SUBAGENZIA")
    private String subagenzia;
     @Column(name = "PRODUTTORE")
    private String         produttore;
     @Column(name = "ZONA_TERRITORIALE")
    private String zonaterritoriale;
     @Column(name = "MODALITA_INCASSO")
    private String         modalitaincasso;
     @Column(name = "TIPOLOGIA_AVVISO")
    private String tipologiaavviso;
     @Column(name = "DATA_AGGIORNAMENTO")
    private Timestamp dataAggiornamento;
     @Column(name = "UTENTE_AGGIORNAMENTO")
    private String utenteAggiornamento;
     @Column(name = "UTENTE_INSERIMENTO")
    private String utenteInserimento;
}

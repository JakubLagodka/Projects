package it.unipol.crm.anagrafica.gestione.entity.code;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "UPL_CRM_DATI_SOCIOECONOMICI")
@NoArgsConstructor
@Data
public class UplCrmDatiSocioeconomici {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DATI_SOCIOECONOMICI")
    private BigInteger idDatiSocioeconomici;
    
    @Column(name = "ID_SOGGETTO")
    private BigInteger idSoggetto;
    
    @Column(name = "COMPAGNIA")
    private String         compagnia;
    
    @Column(name = "NOME_ENTITA_RIFERITA")
    private String nomeentitariferita;
    
    @Column(name = "ID_ENTITA_RIFERITA")
    private BigInteger         identitariferita;
    
    @Column(name = "UTENTE_AGGIORNAMENTO")
    private String         utenteAggiornamento;
    @Column(name = "DATA_AGGIORNAMENTO")
    
    private Timestamp dataAggiornamento;
    @Column(name = "DATA_INSERIMENTO")
    private Timestamp dataInserimento;
    @Column(name = "UTENTE_INSERIMENTO")
    private String utenteInserimento;
}

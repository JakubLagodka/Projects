package it.unipol.crm.anagrafica.gestione.entity.code;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "UPL_CRM_ANAGRAFICA_IDENTITA")
@NoArgsConstructor
@Data
public class UplCrmAnagraficaIdentita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ANAGRAFICA_IDENTITA")
    private BigInteger idAnagraficaIdentita;
    
     @Column(name = "ID_SOGGETTO")
    private BigInteger idSoggetto;
    
     @Column(name = "CODICE_TIPO")
    private BigInteger codicetipo;
     @Column(name = "VALORE")
    private String valore;
     @Column(name = "DATA_AGGIORNAMENTO")
    private Timestamp dataAggiornamento;
     @Column(name = "UTENTE_AGGIORNAMENTO")
    private String utenteAggiornamento;
    @Column(name = "DATA_INSERIMENTO")
    private Timestamp dataInserimento;
    @Column(name = "UTENTE_INSERIMENTO")
    private String utenteInserimento;
}
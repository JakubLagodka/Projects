package it.unipol.crm.anagrafica.gestione.entity.code;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "UPL_CRM_NUCLEI_DETT")
@NoArgsConstructor
@Data
public class UplCrmNucleiDett {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_NUCLEI_DETT")
    private BigInteger idNucleiDett;
    @Column(name = "ID_SOGGETTO")
    private BigInteger         idSoggetto;
    @Column(name = "ID_NUCLEO")
    
    private BigInteger idnucleo;
    @Column(name = "RAGIONE_SOCIALE_CLIENTE")
    private String         ragionesocialecliente;
    @Column(name = "DATA_INIZIO")
    
    private Timestamp dataInizio;
    @Column(name = "DATA_FINE")
    private Timestamp         dataFine;
    @Column(name = "UTENTE_AGGIORNAMENTO")
    
    private String         utenteAggiornamento;
    @Column(name = "DATA_AGGIORNAMENTO")
    
    private Timestamp dataAggiornamento;
    @Column(name = "DATA_INSERIMENTO")
    
    private Timestamp dataInserimento;
    @Column(name = "UTENTE_INSERIMENTO")
    private String utenteInserimento;
}

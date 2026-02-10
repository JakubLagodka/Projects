package it.unipol.crm.anagrafica.gestione.entity.code;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
@Table(name = "UPL_CRM_CONVENZIONI")
@NoArgsConstructor
@Data
public class UplCrmConvenzioni {
    @Id
    @Column(name = "ID_CONVENZIONE")
    private BigInteger idConvenzione;
    
    @Column(name = "CODICE_FISCALE")
    private String codicefiscale;
    
    @Column(name = "PROVENIENZA")
    private String provenienza;
    @Column(name = "CONVENZIONE")
    private String convenzione;
    @Column(name = "UTENTE_AGGIORNAMENTO")
    private String utenteAggiornamento;
    @Column(name = "DATA_AGGIORNAMENTO")
    
    private Timestamp dataAggiornamento;
    @Column(name = "DATA_INSERIMENTO")
    
    private Timestamp dataInserimento;
    @Column(name = "UTENTE_INSERIMENTO")
    private String utenteInserimento;
}

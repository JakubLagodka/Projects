package it.unipol.crm.attivita.model;

import it.unipol.crm.attivita.enums.OperationType;
import it.unipol.crm.attivita.persistence.model.Attivita;
import it.unipol.crm.attivita.persistence.model.NuovaAttivita;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateAttivitaEventoRequest {

    private OperationType attivitaOperationType;
    private OperationType eventiOperationType;
    private NuovaAttivita nuovaAttivita;
    private Attivita attivita;
    private McEventi mcEventi;
}

package it.unipol.crm.attivita.model;

import it.unipol.crm.attivita.enums.OperationType;
import it.unipol.crm.attivita.persistence.model.Attivita;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateAttivitaEventoResponse {

    private OperationType attivitaOperationType;
    private OperationType eventiOperationType;
    private Attivita attivita;
    private McEventi mcEventi;
}
